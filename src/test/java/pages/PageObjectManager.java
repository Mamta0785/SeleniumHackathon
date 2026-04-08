package pages;

import DriverManager.DriverFactory;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {


    private DashboardPage dashboardPage;
    private LoginPage loginPage;
    private AddPatientPage newPatientPage;

    private EditPatientPage editPatientPage;
    private WebDriver driver;

    private MyPatientPage myPatientPage;
    private ViewTestReportPage viewtestreportPage;
    public PageObjectManager (WebDriver driver) {
        this.driver = driver;
    }


    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public DashboardPage getDashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage(driver);
        }
        return dashboardPage;
    }

    public MyPatientPage getMyPatientPage() {
        if (myPatientPage == null) {
            myPatientPage = new MyPatientPage(driver);
        }
        return myPatientPage;
    }

    public EditPatientPage getEditPatientPage() {
        if (editPatientPage == null) {
            editPatientPage = new EditPatientPage(driver);
        }
        return editPatientPage;
    }

    public AddPatientPage getNewPatientPage() {
        if (newPatientPage == null) {
            newPatientPage = new AddPatientPage(driver);
        }
        return newPatientPage;
    }

    public ViewTestReportPage getViewTestReportPage() {
        if (viewtestreportPage == null) {
            viewtestreportPage = new ViewTestReportPage(driver);
        }
        return viewtestreportPage;
    }
}