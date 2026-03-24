package stepdefinition;

import DriverManager.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pages.AddPatientPage;
import pages.LoginPage;
import pages.PageObjectManager;
import utils.ConfigReader;
import utils.ExcelReader;

import java.util.Map;
import java.util.Properties;

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
            Properties prop = ConfigReader.initializeProperties();
            ExcelReader.readDataFromExcel(prop.getProperty("sheetName"));
            Map<String, String> testData = ExcelReader.getTestData("valid_login");
            String username = testData.get("username");
            String password = testData.get("password");
            loginPage.enterUsername(username);
            loginPage.enterPassword(password);
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

    @Then("User should see 9 input boxes in the Add Patient Details dialog box")
    public void user_should_see_9_input_boxes_in_the_add_patient_details_dialog_box() {
        try {
            int actualCount = addPatientPage.getInputFieldCount();
            Assert.assertEquals(actualCount, 9, "Input field count mismatch");
        } catch (Exception e) {
            Assert.fail("Failed to validate the number of input fields in Add Patient dialog", e);
        }
    }

    @Then("User should see 3 dropdowns in the Add Patient Details dialog box")
    public void user_should_see_3_dropdowns_in_the_add_patient_details_dialog_box() {
        try {
            int actualCount = addPatientPage.getDropdownCount();
            Assert.assertEquals(actualCount, 3, "Dropdown count mismatch");
        } catch (Exception e) {
            Assert.fail("Failed to validate dropdown count in Add Patient dialog", e);
        }
    }


}




