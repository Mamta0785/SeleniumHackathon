package pages;

import DriverManager.DriverFactory;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    // ✅ Has implicit zero-arg constructor (you didn't define any constructor)
//    public PageObjectManager() {
//        // Java provides this automatically
//    }



    private DashboardPage dashboardPage;
    private LoginPage loginPage;
    private AddPatientPage newPatientPage;

    private EditPatientPage editPatientPage;
    private WebDriver driver;

    private MyPatientPage myPatientPage;
    private ViewTestReportPage viewtestreportPage;
//WebDriver comes from ThreadLocal, not from DI
    private WebDriver getDriver() {
        return DriverFactory.getDriver();   // always correct ThreadLocal driver
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(getDriver());
        }
        return loginPage;
    }

    public DashboardPage getDashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage(getDriver());
        }
        return dashboardPage;
    }

    public MyPatientPage getMyPatientPage() {
        if (myPatientPage == null) {
            myPatientPage = new MyPatientPage(getDriver());
        }
        return myPatientPage;
    }

    public EditPatientPage getEditPatientPage() {
        if (editPatientPage == null) {
            editPatientPage = new EditPatientPage(getDriver());
        }
        return editPatientPage;
    }

    public AddPatientPage getNewPatientPage() {
        if (newPatientPage == null) {
            newPatientPage = new AddPatientPage(getDriver());
        }
        return newPatientPage;
    }

    public ViewTestReportPage getViewTestReportPage() {
        if (viewtestreportPage == null) {
            viewtestreportPage = new ViewTestReportPage(getDriver());
        }
        return viewtestreportPage;
    }
}