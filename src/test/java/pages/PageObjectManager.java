package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private WebDriver driver;

    private DashboardPage dashboardPage;
    private LoginPage loginPage;
    private AddPatientPage newPatientPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }


    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public AddPatientPage getNewPatientPage() {
        if (newPatientPage == null) {
            newPatientPage = new AddPatientPage(driver);
        }
        return newPatientPage;
    }
}
