package stepdefinition;

import java.util.List;
import DriverManager.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MyPatientPage;
import pages.DashboardPage;
import pages.EditPatientPage;
import pages.PageObjectManager;
import utils.ElementUtil;

public class EditPatientPageStepDefinition {

	private final PageObjectManager pom;
	private static final Logger logger = LoggerFactory.getLogger(EditPatientPageStepDefinition.class);
	WebDriver driver;
	private EditPatientPage editPatientPage;
	private DashboardPage dashboardPage;
	private MyPatientPage myPatientPage;

	public EditPatientPageStepDefinition(PageObjectManager pom) {
		//pom = new PageObjectManager();
        this.pom=pom;
		driver = DriverFactory.getDriver();
		editPatientPage = pom.getEditPatientPage();
		dashboardPage = pom.getDashboardPage();
		myPatientPage = pom.getMyPatientPage();
	}

	@Given("User is on the My Patient page after login with existing patients")
	public void user_Is_On_The_MyPatient_Page_After_Login_With_Existing_Patients() {
		try {
			logger.info("User is on" + ElementUtil.getURL() + "page");
			logger.info("Clicking My Patient header link...");
			dashboardPage.clicknavigationLink("MyPatients");
		} catch (Exception e) {
			logger.error("Failed to navigate to My Patients Page", e);
		}
	}

	@When("User clicks edit icon for the particular patient")
	public void userClicksEditIconForTheParticularPatient() {
		try {
			WebElement rowToSelect = myPatientPage.getAllRows().get(1); // skipping header row
			myPatientPage.selectRow(rowToSelect);
			logger.info("First row selected");
			myPatientPage.clickEditIconForSelectedRow();
		} catch (Exception e) {
			logger.error("Failed to select the first row", e);
		}
	}

	@Then("User should see  Edit Patient page on the dialog box")
	public void user_should_see_add_patient_details_on_the_dialog_box() {

		try {
			logger.info("Validating Edit Patient Details dialog...");

			boolean dialogIsValid = editPatientPage.iseDialogDisplayed();

			Assert.assertTrue(dialogIsValid, "Dialog is not displayed OR dialog title is incorrect");

		} catch (Exception e) {
			Assert.fail("Dialog title validation failed (expected failure)", e);
		}
	}

	@Then("User should see  submit button")
	public void user_Should_See_Submit_Button() {
		try {
			logger.info("Validating Submit button on Edit Patient Details dialog...");

			boolean dialogIsValid = editPatientPage.iseDialogDisplayed();

			Assert.assertTrue(dialogIsValid, "Dialog is not displayed OR dialog title is incorrect");

		} catch (Exception e) {
			Assert.fail("Dialog title validation failed (expected failure)", e);
		}
		try {
			boolean isDisplayed = editPatientPage.isSubmitButtonDisplayed();
			Assert.assertTrue(isDisplayed, "Submit button should be visible");
		} catch (Exception e) {
			Assert.fail("Failed to check if Submit button is visible:" + e.getMessage());
		}
	}

	@Then("User should see submit button in enable mode")
	public void user_Should_See_Submit_Button_In_EnableMode() {
		try {
			logger.info("Validating Submit button on Edit Patient Details dialog...");

			boolean dialogIsValid = editPatientPage.iseDialogDisplayed();

			Assert.assertTrue(dialogIsValid, "Dialog is not displayed OR dialog title is incorrect");

		} catch (Exception e) {
			Assert.fail("Dialog title validation failed (expected failure)", e);
		}
		try {
			boolean isDisplayed = editPatientPage.isSubmitButtonDisplayed();
			Assert.assertTrue(isDisplayed, "Submit button should be visible");

			// boolean isEnabled = editPatientPage.isSubmitButtonEnabled();
		} catch (Exception e) {
			Assert.fail("Failed to validate Submit button :" + e.getMessage());
		}
	}

	@Then("User should see  Close button")
	public void user_Should_See_Close_Button() {
		try {
			logger.info("Validating close button on Edit Patient Details dialog...");

			boolean dialogIsValid = editPatientPage.iseDialogDisplayed();

			Assert.assertTrue(dialogIsValid, "Dialog is not displayed OR dialog title is incorrect");

		} catch (Exception e) {
			Assert.fail("Dialog title validation failed (expected failure)", e);
		}
		try {
			boolean isDisplayed = editPatientPage.iscloseButtonDisplayed();
			Assert.assertTrue(isDisplayed, "Close button should be visible");
		} catch (Exception e) {
			Assert.fail("Failed to check if Close button is visible:" + e.getMessage());
		}
	}

	@Then("User should see close button in enable mode")
	public void user_Should_See_Close_Button_In_EnableMode() {
		try {
			logger.info("Validating close button on Edit Patient Details dialog...");

			boolean dialogIsValid = editPatientPage.iseDialogDisplayed();

			Assert.assertTrue(dialogIsValid, "Dialog is not displayed OR dialog title is incorrect");

		} catch (Exception e) {
			Assert.fail("Dialog title validation failed (expected failure)", e);
		}
		try {
			boolean isDisplayed = editPatientPage.iscloseButtonDisplayed();
			Assert.assertTrue(isDisplayed, "Close button should be visible");

		} catch (Exception e) {
			// boolean isEnabled = editPatientPage.iscloseButtonEnabled();
			Assert.fail("Failed to validate Submit button :" + e.getMessage());

		}
	}

	@Then("User should see {int} input field")
	public void user_Should_See_Input_Field(Integer int1) {
		try {
			logger.info("Validating input fields on Edit Patient Details dialog...");

			boolean dialogIsValid = editPatientPage.iseDialogDisplayed();

			Assert.assertTrue(dialogIsValid, "Dialog is not displayed OR dialog title is incorrect");

		} catch (Exception e) {
			Assert.fail("Dialog title validation failed (expected failure)", e);
		}
		try {
			int actualCount = editPatientPage.getInputFieldCount();
			Assert.assertEquals(actualCount, int1, "Input field count mismatch");
		} catch (Exception e) {
			Assert.fail("Failed to validate the number of input fields in Edit Patient dialog", e);
		}
	}

	@Then("User should see {int} drop down")
	public void user_Should_See_Dropdown(Integer int1) {
		try {
			logger.info("Validating Submit button on Edit Patient Details dialog...");

			boolean dialogIsValid = editPatientPage.iseDialogDisplayed();

			Assert.assertTrue(dialogIsValid, "Dialog is not displayed OR dialog title is incorrect");

		} catch (Exception e) {
			Assert.fail("Dialog title validation failed (expected failure)", e);
		}
		try {
			int actualCount = editPatientPage.getDropdownCount();
			Assert.assertEquals(actualCount, int1, "Dropdown count mismatch");
		} catch (Exception e) {
			Assert.fail("Failed to validate dropdown count in Add Patient dialog", e);
		}
	}

	@Then("User should see exactly 1 file upload option")
	public void User_should_see_exactly_1_file_upload_option() {
		try {
			logger.info("Validating File upload on Edit Patient Details dialog...");

			boolean dialogIsValid = editPatientPage.iseDialogDisplayed();

			Assert.assertTrue(dialogIsValid, "Dialog is not displayed OR dialog title is incorrect");

		} catch (Exception e) {
			Assert.fail("Dialog title validation failed (expected failure)", e);
		}
		try {
			List<WebElement> fileInputs = editPatientPage.getFileUploadFields();
			Assert.assertEquals(1, fileInputs.size());
		} catch (Exception e) {
			Assert.fail("Failed to validate file upload option :" + e.getMessage());
		}
	}

	@Given("User is edit dialog box")
	public void User_is_edit_dialog_box() {
		try {
			logger.info("User is on" + ElementUtil.getURL() + "page");
			logger.info("Clicking My Patient header link...");
			dashboardPage.clicknavigationLink("MyPatients");
			myPatientPage.clickEditIconForSelectedRow();
		} catch (Exception e) {
			logger.error("Failed to navigate to My Patients Page", e);
		}
	}

	@Then("User should see placeholder {string} for FirstName")
	public void user_Should_See_Placeholder_for_firstname(String fExpectedPlaceholder) {
		try {
			logger.info("Validating placeholder for firstname field");
			String actualPlaceholder = editPatientPage.getFirstNamePlaceholder();
			Assert.assertEquals(actualPlaceholder, fExpectedPlaceholder,
					"FirstName field placeholder validation failed");

		} catch (Exception e) {

			logger.error("Exception while validating First field placeholder", e);
			Assert.fail("Test Failed due to Exception :" + e.getMessage());
		}
	}

	@Then("User should see placeholder {string} for weight")
	public void user_Should_See_Placeholder_for_weight(String wExpectedPlaceholder) {
		try {
			logger.info("Validating placeholderfor Weight field");

			String actualPlaceholder = editPatientPage.getWeightPlaceholder();

			Assert.assertEquals(actualPlaceholder, wExpectedPlaceholder, "Weight field placeholder validation failed");

		} catch (Exception e) {

			logger.error("Exception while validating weght field placeholder", e);
			Assert.fail("Test Failed due to Exception :" + e.getMessage());
		}
	}

	@Then("User should see placeholder {string} for LastName")
	public void User_Should_See_Placeholder_for_lastName(String lExpectedPlaceholder) {
		try {
			logger.info("Validating placeholderfor LastName field");

			String actualPlaceholder = editPatientPage.getLastNamePlaceholder();

			Assert.assertEquals(actualPlaceholder, lExpectedPlaceholder,
					"LastName field placeholder validation failed");

		} catch (Exception e) {

			logger.error("Exception while validating Last Name field placeholder", e);
			Assert.fail("Test Failed due to Exception :" + e.getMessage());
		}
	}

	@When("User clears existing value in Last Name field")
	public void userClearsExistingValueInLastNameField() {
		editPatientPage.clearLastNameField();
		editPatientPage.getLastNamePlaceholder();
	}

	@Then("User should see the {string} field populated with the value entered during patient creation for first name.")
	public void userShouldSeeTheFieldPopulatedWithTheValueEnteredDuringPatientCreationForFirstName(String string) {
		String patientName = editPatientPage.getFirstNamefield();
		Assert.assertEquals(editPatientPage.getFirstRowName(), patientName, "First Name field populated failed");
	}

	@Then("User should see the {string} field populated with the value entered during patient creation for last name.")
	public void userShouldSeeTheLastNameFieldPopulatedWithTheValueEnteredDuringPatientCreationForLastName() {
		String patientName = editPatientPage.getLastNamefield();
		Assert.assertEquals(editPatientPage.getFirstRowName(), patientName, "Last Name field didnt populate with data");
	}

	@When("User clears existing value in First Name field")
	public void userClearsExistingValueInFirstNameField() {
		editPatientPage.clearFirstNameField();
		editPatientPage.getFirstNamePlaceholder();
	}

}
