package stepdefinition;

import DriverManager.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.PageObjectManager;
import utils.*;
import io.qameta.allure.Allure;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Properties;

public class Hooks {

    private WebDriver driver;
    private TestContext context;
    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);
    // PicoContainer injects the SAME PageObjectManager into all step defs

    public Hooks(TestContext context) {
        this.context = context;
    }
    @Before(order = 0)
    public void setup() {
        logger.info("Initializing test setup on thread: {}", Thread.currentThread().getId());
        logger.info("Starting Hooks setup");
        Properties prop = ConfigReader.initializeProperties();
        logger.debug("Loaded configuration properties");

        String browser = null;

        // First: Try to get browser from TestRunner's ThreadLocal (set by @BeforeClass)
        browser = runner.TestRunner.browserName.get();
        if (browser != null && !browser.trim().isEmpty()) {
            logger.info("Browser from TestRunner ThreadLocal: {}", browser);
        }

        // Fallback to config.properties if not set
        if (browser == null || browser.trim().isEmpty()) {
            browser = prop.getProperty("browserName");
            logger.info("Browser from config.properties: {}", browser);
        }

        // Final fallback to chrome
        if (browser == null || browser.trim().isEmpty()) {
            browser = "chrome";
            logger.warn("No browser specified, using default: chrome");
        }

        logger.info("Final browser selection: {} on thread {}", browser, Thread.currentThread().getId());
        context.driverFactory.launchBrowser(browser);
        context.initializeContext();
        context.driverFactory.getDriver().get(prop.getProperty("baseURL"));
        logger.info("Navigated to base URL: {}", prop.getProperty("baseURL"));

        logger.info("PageObjectManager initialized");

        ExcelReader.readDataFromExcel(prop.getProperty("sheetName"));
        logger.info("Excel test data loaded");
    }

    @Before(value = "@Login", order = 1)
    public void performLogin() throws IOException {
        logger.info("Clicked Sign In button");
context.loginPage.login("Submits the login form", "valid_login");
        logger.info("Performed login with valid credentials");
    }


    @AfterStep
    public void screenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            logger.warn("Scenario '{}' failed. Capturing screenshot...", scenario.getName());
            byte[] screenshot = ScreenShot.takeScreenshotAsBytes(context.driverFactory.getDriver(), scenario.getName());
            // Attach for Cucumber
            scenario.attach(screenshot, "image/png", "Failed Step Screenshot");
            // Attach for Allure
            Allure.addAttachment("Failed Step Screenshot", "image/png", new ByteArrayInputStream(screenshot), ".png");
        }
    }

    @After
    public void tearDown() {
        if (DriverFactory.getDriver() != null) {
            logger.info("Tearing down WebDriver and closing browser");
            context.driverFactory.closeDriver();
            logger.info("Driver removed from ThreadLocal");
        }
    }
}