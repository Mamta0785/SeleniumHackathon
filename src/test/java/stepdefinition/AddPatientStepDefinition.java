package stepdefinition;

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

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class AddPatientStepDefinition {

    private static final Logger logger = LoggerFactory.getLogger(AddPatientStepDefinition.class);

    private WebDriver driver;
    private PageObjectManager pom;
    private AddPatientPage addPatientPage;
    private LoginPage loginPage;

    public AddPatientStepDefinition(PageObjectManager pom) {
        pom = new PageObjectManager();
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

            boolean dialogIsValid =
                    addPatientPage.isDialogDisplayed() &&
                            addPatientPage.getDialogTitle().equals("Add Patient Details");

            Assert.assertTrue(dialogIsValid,
                    "Dialog is not displayed OR dialog title is incorrect");

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

    @Then("User should see a date picker for DOB field with MM\\/DD\\/YYYY displayed")
    public void user_should_see_a_date_picker_for_dob_field_with_mm_dd_yyyy_displayed() {
        try {
            logger.info("Validating DOB date picker field...");

            boolean isValid =
                    addPatientPage.isDobDatePicker() &&
                            addPatientPage.getDobPlaceholder().matches(".*(MM|mm|YYYY|yyyy).*");

            Assert.assertTrue(
                    isValid,
                    "DOB date picker validation failed. " +
                            "isDatePicker=" + addPatientPage.isDobDatePicker() +
                            ", placeholder=" + addPatientPage.getDobPlaceholder()
            );

        } catch (Exception e) {
            Assert.fail("Failed to validate DOB date picker field", e);
        }
    }

    @Then("User should see exactly 1 file upload option in Add Patient Details dialog box")
    public void user_should_see_exactly_1_file_upload_option_in_add_patient_details_dialog_box() {
        try {
            int actualCount = addPatientPage.getFileUploadCount();
            Assert.assertEquals(actualCount, 1, "File upload option count mismatch");
        } catch (Exception e) {
            Assert.fail("Failed to validate file upload option in Add Patient dialog", e);
        }
    }

    @Then("User should see one Submit button")
    public void user_should_see_one_submit_button() {
        try {
            int actualCount = addPatientPage.getSubmitButtonCount();
            Assert.assertEquals(actualCount, 1, "Submit button count mismatch");
        } catch (Exception e) {
            Assert.fail("Failed to validate Submit button in Add Patient dialog", e);
        }
    }

    @Then("User should see one Submit button in disabled state")
    public void user_should_see_one_submit_button_in_disabled_state() {
        try {
            logger.info("Validating disabled state of Submit button...");

            Assert.assertTrue(
                    addPatientPage.isSubmitButtonDisabled(),
                    "Submit button is NOT disabled"
            );

        } catch (Exception e) {
            Assert.fail("Failed to validate disabled state of Submit button", e);
        }
    }

    @Then("User should see one Close button")
    public void user_should_see_one_close_button() {
        try {
            int actualCount = addPatientPage.getCloseButtonCount();
            Assert.assertEquals(actualCount, 1, "Close button count mismatch");
        } catch (Exception e) {
            Assert.fail("Failed to validate Close button in Add Patient dialog", e);
        }
    }

    @Then("User should see one Close button in enabled state")
    public void user_should_see_one_close_button_in_enabled_state() {
        try {
            logger.info("Validating enabled state of Close button...");

            Assert.assertTrue(
                    addPatientPage.isCloseButtonEnabled(),
                    "Close button is NOT enabled"
            );

        } catch (Exception e) {
            Assert.fail("Failed to validate enabled state of Close button", e);
        }
    }

    @Then("User should see mandatory field error for First name")
    public void user_should_see_mandatory_field_error_for_first_name() {
        try {
            logger.info("Validating mandatory error message for First Name...");

            addPatientPage.clickFirstNameAndBlur();

            Assert.assertTrue(
                    addPatientPage.isFirstNameErrorDisplayed(),
                    "Expected 'First name is required' error message was NOT displayed"
            );

        } catch (Exception e) {
            Assert.fail("Failed to validate First Name mandatory error message", e);
        }
    }

    @Then("User should see mandatory field with placeholder {string} for last name")
    public void user_should_see_mandatory_field_with_placeholder_for_last_name(String expectedPlaceholder) {
        try {
            logger.info("Validating placeholder and mandatory state for Last Name field...");

            String actualPlaceholder = addPatientPage.getLastNamePlaceholder();
            boolean isMandatory = addPatientPage.isLastNameMandatory();

            boolean isValid =
                    actualPlaceholder.equals(expectedPlaceholder) &&
                            isMandatory;

            Assert.assertTrue(
                    isValid,
                    "Last Name validation failed. " +
                            "placeholder=" + actualPlaceholder +
                            ", mandatory=" + isMandatory
            );

        } catch (Exception e) {
            Assert.fail("Failed to validate Last Name placeholder or mandatory state", e);
        }
    }

    @Then("User should see mandatory field with placeholder {string} for email")
    public void user_should_see_mandatory_field_with_placeholder_for_email(String expectedPlaceholder) {
        try {
            logger.info("Validating placeholder and mandatory state for Email field...");

            String actualPlaceholder = addPatientPage.getEmailPlaceholder();
            boolean isMandatory = addPatientPage.isEmailMandatory();

            boolean isValid =
                    actualPlaceholder.equals(expectedPlaceholder) &&
                            isMandatory;

            Assert.assertTrue(
                    isValid,
                    "Email field validation failed. " +
                            "placeholder=" + actualPlaceholder +
                            ", mandatory=" + isMandatory
            );

        } catch (Exception e) {
            Assert.fail("Failed to validate Email placeholder or mandatory state", e);
        }
    }

    @Then("User should see mandatory field with placeholder {string} for contact number")
    public void user_should_see_mandatory_field_with_placeholder_for_contact_number(String expectedPlaceholder) {
        try {
            logger.info("Validating placeholder and mandatory state for Contact Number field...");

            String actualPlaceholder = addPatientPage.getContactNumberPlaceholder();
            boolean isMandatory = addPatientPage.isContactNumberMandatory();

            boolean isValid =
                    actualPlaceholder.equals(expectedPlaceholder) &&
                            isMandatory;

            Assert.assertTrue(
                    isValid,
                    "Contact Number field validation failed. " +
                            "placeholder=" + actualPlaceholder +
                            ", mandatory=" + isMandatory
            );

        } catch (Exception e) {
            Assert.fail("Failed to validate Contact Number placeholder or mandatory state", e);
        }
    }

    @Then("User should see mandatory dropdown with placeholder {string} for allergies")
    public void user_should_see_mandatory_dropdown_with_placeholder_for_allergies(String expectedPlaceholder) {
        try {
            logger.info("Validating placeholder and mandatory state for Allergies dropdown...");

            String actualText = addPatientPage.getAllergiesSelectedText();
            boolean isMandatory = addPatientPage.isAllergiesMandatory();

            boolean isValid =
                    actualText.equals(expectedPlaceholder) &&
                            isMandatory;

            Assert.assertTrue(
                    isValid,
                    "Allergies dropdown validation failed. " +
                            "placeholder=" + actualText +
                            ", mandatory=" + isMandatory
            );

        } catch (Exception e) {
            Assert.fail("Failed to validate Allergies dropdown placeholder or mandatory state", e);
        }

    }

    @Then("User should see mandatory dropdown with placeholder {string} for food preference")
    public void user_should_see_mandatory_dropdown_with_placeholder_for_food_preference(String expectedPlaceholder) {
        try {
            logger.info("Validating placeholder and mandatory state for Food Preference dropdown...");

            String actualText = addPatientPage.getFoodPreferencePlaceholder();
            boolean isMandatory = addPatientPage.isFoodPreferenceMandatory();

            boolean isValid =
                    actualText.equals(expectedPlaceholder) &&
                            isMandatory;

            Assert.assertTrue(
                    isValid,
                    "Food Preference dropdown validation failed. " +
                            "placeholder=" + actualText +
                            ", mandatory=" + isMandatory
            );

        } catch (Exception e) {
            Assert.fail("Failed to validate Food Preference dropdown placeholder or mandatory state", e);
        }

    }

    @Then("User should see mandatory dropdown with placeholder {string} for cuisine category")
    public void user_should_see_mandatory_dropdown_with_placeholder_for_cuisine_category(String expectedPlaceholder) {
        try {
            logger.info("Validating placeholder and mandatory state for Cuisine Category dropdown...");

            String actualText = addPatientPage.getCuisineCategoryPlaceholder();
            boolean isMandatory = addPatientPage.isCuisineCategoryMandatory();

            boolean isValid =
                    actualText.equals(expectedPlaceholder) &&
                            isMandatory;

            Assert.assertTrue(
                    isValid,
                    "Cuisine Category dropdown validation failed. " +
                            "placeholder=" + actualText +
                            ", mandatory=" + isMandatory
            );

        } catch (Exception e) {
            Assert.fail("Failed to validate Cuisine Category dropdown placeholder or mandatory state", e);
        }

    }

    @Then("User should see mandatory DOB with placeholder {string}")
    public void user_should_see_mandatory_dob_with_placeholder(String expectedPlaceholder) {
        try {
            logger.info("Validating placeholder and mandatory state for DOB field...");

            String actualPlaceholder = addPatientPage.getDobPlaceholder();
            boolean isMandatory = addPatientPage.isDobMandatory();

            boolean isValid =
                    actualPlaceholder.equals(expectedPlaceholder) &&
                            isMandatory;

            Assert.assertTrue(
                    isValid,
                    "DOB field validation failed. " +
                            "placeholder=" + actualPlaceholder +
                            ", mandatory=" + isMandatory
            );

        } catch (Exception e) {
            Assert.fail("Failed to validate DOB placeholder or mandatory state", e);
        }

    }

    @Then("User should see non-mandatory field placeholder with {string} for weight")
    public void user_should_see_non_mandatory_field_placeholder_with_for_weight(String expectedPlaceholder) {
        try {
            logger.info("Validating placeholder and non-mandatory state for Weight field...");

            String actualPlaceholder = addPatientPage.getWeightPlaceholder();
            boolean isMandatory = addPatientPage.isWeightMandatory();

            boolean isValid =
                    actualPlaceholder.equals(expectedPlaceholder) &&
                            !isMandatory;

            Assert.assertTrue(
                    isValid,
                    "Weight field validation failed. " +
                            "placeholder=" + actualPlaceholder +
                            ", mandatory=" + isMandatory
            );

        } catch (Exception e) {
            Assert.fail("Failed to validate Weight placeholder or mandatory state", e);
        }

    }

    @Then("User should see non-mandatory field placeholder with {string} for height")
    public void user_should_see_non_mandatory_field_placeholder_with_for_height(String expectedPlaceholder) {
        try {
            logger.info("Validating placeholder and non-mandatory state for Height field...");

            String actualPlaceholder = addPatientPage.getHeightPlaceholder();
            boolean isMandatory = addPatientPage.isHeightMandatory();

            boolean isValid =
                    actualPlaceholder.equals(expectedPlaceholder) &&
                            !isMandatory;

            Assert.assertTrue(
                    isValid,
                    "Height field validation failed. " +
                            "placeholder=" + actualPlaceholder +
                            ", mandatory=" + isMandatory
            );

        } catch (Exception e) {
            Assert.fail("Failed to validate Height placeholder or mandatory state", e);
        }
    }


    @Then("User should see non-mandatory field placeholder with {string} for temperature")
    public void user_should_see_non_mandatory_field_placeholder_with_for_temperature(String expectedPlaceholder) {
        try {
            logger.info("Validating placeholder and non-mandatory state for Temperature field...");

            String actualPlaceholder = addPatientPage.getTemperaturePlaceholder();
            boolean isMandatory = addPatientPage.isTemperatureMandatory();

            boolean isValid =
                    actualPlaceholder.equals(expectedPlaceholder) &&
                            !isMandatory;

            Assert.assertTrue(
                    isValid,
                    "Temperature field validation failed. " +
                            "placeholder=" + actualPlaceholder +
                            ", mandatory=" + isMandatory
            );

        } catch (Exception e) {
            Assert.fail("Failed to validate Temperature placeholder or mandatory state", e);
        }
    }

    @Then("User should see non-mandatory field placeholder with {string} for sp")
    public void user_should_see_non_mandatory_field_placeholder_with_for_sp(String expectedPlaceholder) {
        try {
            logger.info("Validating placeholder and non-mandatory state for SP field...");

            String actualPlaceholder = addPatientPage.getSpPlaceholder();
            boolean isMandatory = addPatientPage.isSpMandatory();

            boolean isValid =
                    actualPlaceholder.equals(expectedPlaceholder) &&
                            !isMandatory;

            Assert.assertTrue(
                    isValid,
                    "SP field validation failed. " +
                            "placeholder=" + actualPlaceholder +
                            ", mandatory=" + isMandatory
            );

        } catch (Exception e) {
            Assert.fail("Failed to validate SP placeholder or mandatory state", e);
        }
    }

    @Then("User should see non-mandatory field placeholder with {string} for dp")
    public void user_should_see_non_mandatory_field_placeholder_with_for_dp(String expectedPlaceholder) {
        try {
            logger.info("Validating placeholder and non-mandatory state for DP field...");

            String actualPlaceholder = addPatientPage.getDpPlaceholder();
            boolean isMandatory = addPatientPage.isDpMandatory();

            boolean isValid =
                    actualPlaceholder.equals(expectedPlaceholder) &&
                            !isMandatory;

            Assert.assertTrue(
                    isValid,
                    "DP field validation failed. " +
                            "placeholder=" + actualPlaceholder +
                            ", mandatory=" + isMandatory
            );

        } catch (Exception e) {
            Assert.fail("Failed to validate DP placeholder or mandatory state", e);
        }
    }

    @Then("User should see text Upload Health Report")
    public void user_should_see_text_upload_health_report() {
        try {
            logger.info("Validating presence of Upload Health Report text...");

            boolean isVisible = addPatientPage.isUploadHealthReportVisible();

            Assert.assertTrue(
                    isVisible,
                    "Upload Health Report text is NOT visible"
            );

        } catch (Exception e) {
            Assert.fail("Failed to validate presence of Upload Health Report text", e);
        }
    }

    @Then("User should see text No file Chosen")
    public void user_should_see_text_no_file_chosen() {
        try {
            logger.info("Validating presence of 'No file Chosen' text...");

            boolean isVisible = addPatientPage.isNoFileChosenVisible();

            Assert.assertTrue(
                    isVisible,
                    "'No file Chosen' text is NOT visible"
            );

        } catch (Exception e) {
            Assert.fail("Failed to validate presence of 'No file Chosen' text", e);
        }
    }

    @Then("User should see a scroll bar at the right side of dialog box")
    public void user_should_see_a_scroll_bar_at_the_right_side_of_dialog_box() {
        try {
            logger.info("Validating presence of scroll bar on dialog box...");

            boolean isScrollable = addPatientPage.isDialogScrollable();

            Assert.assertTrue(
                    isScrollable,
                    "Scroll bar is NOT present on the dialog box"
            );

        } catch (Exception e) {
            Assert.fail("Failed to validate scroll bar presence on dialog box", e);
        }
    }

    @When("User clicks on Allergy dropdown")
    public void user_clicks_on_allergy_dropdown() {
        try {
            logger.info("Clicking Allergy dropdown...");
            addPatientPage.clickAllergyDropdown();
        } catch (Exception e) {
            Assert.fail("Failed to click Allergy dropdown", e);
        }
    }

    @Then("Values should be present inside Allergy dropdown")
    public void values_should_be_present_inside_allergy_dropdown() {
        try {
            logger.info("Validating Allergy dropdown values...");


            List<String> actualValues = addPatientPage.getAllergyDropdownValues();


            List<Map<String, String>> excelData =
                    ExcelReader.readDataFromExcel("allergies");

            List<String> expectedValues = excelData.stream()
                    .map(row -> row.get("Values"))
                    .toList();

            boolean isValid = actualValues.containsAll(expectedValues);

            Assert.assertTrue(
                    isValid,
                    "Allergy dropdown values mismatch.\nExpected: " + expectedValues +
                            "\nActual: " + actualValues
            );

        } catch (Exception e) {
            Assert.fail("Failed to validate Allergy dropdown values", e);
        }
    }


    @Then("Dropdown should contain {int} values")
    public void dropdown_should_contain_values(Integer expectedCount) {
        try {
            logger.info("Validating number of values in Allergy dropdown...");

            List<String> actualValues = addPatientPage.getAllergyDropdownValues();

            int actualCount = actualValues.size();

            Assert.assertEquals(
                    actualCount,
                    expectedCount,
                    "Mismatch in number of Allergy dropdown values. Actual: " + actualCount
            );

        } catch (Exception e) {
            Assert.fail("Failed to validate Allergy dropdown value count", e);
        }
    }

    @Then("Dropdown should contain specific allergy values")
    public void dropdown_should_contain_specific_allergy_values() {
        try {
            logger.info("Validating specific Allergy dropdown values from Excel...");


            List<String> actualValues = addPatientPage.getAllergyDropdownValues();


            List<Map<String, String>> excelData =
                    ExcelReader.readDataFromExcel("allergies");

            List<String> expectedValues = excelData.stream()
                    .map(row -> row.get("Values"))
                    .toList();

            boolean isValid = actualValues.containsAll(expectedValues);

            Assert.assertTrue(
                    isValid,
                    "Allergy dropdown values mismatch.\nExpected: " + expectedValues +
                            "Actual: " + actualValues
            );

        } catch (Exception e) {
            Assert.fail("Failed to validate specific Allergy dropdown values", e);
        }
    }


}




