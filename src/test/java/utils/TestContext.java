package utils;

import DriverManager.DriverFactory;
import org.openqa.selenium.WebDriver;
import pages.PageObjectManager;

import java.util.Map;
import pages.LoginPage;

public class TestContext {
    public WebDriver driver;
    public DriverFactory driverFactory;
    public PageObjectManager poManager;
    public LoginPage loginPage;

    public static Map<String, String> testData;

    public TestContext() {

        driverFactory = new DriverFactory();

    }
    public void initializeContext() {

        this.driver = driverFactory.getDriver();
        this.poManager = new PageObjectManager(driver);
        this.loginPage = new LoginPage(driver);


    }
}
