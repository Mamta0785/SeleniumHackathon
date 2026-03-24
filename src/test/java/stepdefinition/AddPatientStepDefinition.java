package stepdefinition;





import DriverManager.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pages.AddPatientPage;
import pages.LoginPage;
import pages.PageObjectManager;

public class AddPatientStepDefinition {

    private static final Logger logger = LoggerFactory.getLogger(AddPatientStepDefinition.class);

    private WebDriver driver;
    private PageObjectManager pom;
    private AddPatientPage addPatientPage;
    private LoginPage loginPage;

    public AddPatientStepDefinition() {
        driver = DriverFactory.getDriver();
        pom = new PageObjectManager(driver);
        addPatientPage = pom.getNewPatientPage();
        loginPage = pom.getLoginPage();
    }



    @Given("User is in Home Page")
    public void user_is_in_home_page() {
        try {
            loginPage.enterUsername("admin");
            loginPage.enterPassword("admin123");
            loginPage.clickLoginButton();
        } catch (Exception e) {
            Assert.fail("Failed to load Home Page or login", e);
        }
    }



    @When("User clicks on New Patient in the header section")
    public void user_clicks_on_new_patient_in_the_header_section() {
        try {
            logger.info("Clicking New Patient header link...");
            addPatientPage.clickNewPatientHeader();
        } catch (Exception e) {
            Assert.fail("Failed to click New Patient header (expected failure)", e);
        }
    }


    @Then("User should see Add Patient Details on the dialog box")
    public void user_should_see_add_patient_details_on_the_dialog_box() {
        try {
            logger.info("Validating Add Patient Details dialog...");

            Assert.assertTrue(
                    addPatientPage.isDialogDisplayed(),
                    "Dialog box is NOT displayed"
            );

            Assert.assertEquals(
                    addPatientPage.getDialogTitle(),
                    "Add Patient Details",
                    "Dialog title mismatch"
            );

        } catch (Exception e) {
            Assert.fail("Dialog title validation failed (expected failure)", e);
        }
    }
}




