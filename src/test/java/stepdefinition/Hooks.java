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

import java.io.IOException;
import java.util.Properties;

public class Hooks {

    private WebDriver driver;
    private final PageObjectManager pom;
    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);
    // PicoContainer injects the SAME PageObjectManager into all step defs
    public Hooks(PageObjectManager pom) {
        this.pom = pom;
    }
    @Before(order = 0)
    public void setup() {
        logger.info("Initializing test setup on thread: {}", Thread.currentThread().getId());

        Properties prop = ConfigReader.initializeProperties();
        logger.debug("Loaded configuration properties");

        ExcelReader.readDataFromExcel(prop.getProperty("sheetName"));
        logger.info("Excel test data loaded");

        TestContext testContext = new TestContext();
        String browser = testContext.getBrowserFromTestNG();
        logger.info("Browser from TestNG (ThreadLocal): {}", browser);

        if (browser == null || browser.trim().isEmpty()) {
            browser = System.getProperty("browserName");
            logger.info("Browser from System Property: {}", browser);
        }
        if (browser == null || browser.trim().isEmpty()) {
            browser = prop.getProperty("browserName");
            logger.info("Browser from config.properties: {}", browser);
        }
        if (browser == null || browser.trim().isEmpty()) {
            browser = "chrome"; // Final fallback
            logger.warn("No browser specified, using default: chrome");
        }

        logger.info("Final browser selection: {} on thread {}", browser, Thread.currentThread().getId());
        DriverFactory.launchBrowser(browser);
        driver = DriverFactory.getDriver();
        driver.get(prop.getProperty("baseURL"));
        logger.info("Navigated to base URL: {}", prop.getProperty("baseURL"));

//        pom = new PageObjectManager();
        logger.info("PageObjectManager initialized");
    }

    @Before(value = "@Login", order = 1)
    public void performLogin() throws IOException {
        logger.info("Clicked Sign In button");

        pom.getLoginPage().login("Submits the login form", "valid_login");
        logger.info("Performed login with valid credentials");
    }


    @AfterStep
    public void screenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            logger.warn("Scenario '{}' failed. Capturing screenshot...", scenario.getName());
            byte[] screenshot = ScreenShot.takeScreenshotAsBytes(DriverFactory.getDriver(), scenario.getName());
            scenario.attach(screenshot, "image/png", "Failed Step Screenshot");
        }
    }

    @After
    public void tearDown() {
        if (DriverFactory.getDriver() != null) {
            logger.info("Tearing down WebDriver and closing browser");
            DriverFactory.getDriver().quit();
            DriverFactory.mydriver.remove();
            logger.info("Driver removed from ThreadLocal");
        }
    }
}