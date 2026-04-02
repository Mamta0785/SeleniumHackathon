package stepdefinition;

import DriverManager.DriverFactory;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import pages.PageObjectManager;
import utils.ExcelReader;

import java.util.List;
import java.util.Map;


public class AddPatientStepDefinition {

    private static final Logger logger = LoggerFactory.getLogger(AddPatientStepDefinition.class);


    WebDriver driver;
    private final PageObjectManager pom;
//    private AddPatientPage addPatientPage;
//    private LoginPage loginPage;
//    private DashboardPage dashboardPage;
    private boolean selectionAttempt;
    // THIS constructor enables PicoContainer
    /*
    What PicoContainer Does Automatically
Before each scenario,
 Cucumber asks PicoContainer: *"Give me an instance of AddPatientStepDefinitionAddPatientStepDefinition"

PicoContainer sees your constructor needs a PageObjectManager

PicoContainer tries to create a PageObjectManager by calling its zero-argument constructor:
PicoContainer injects the newly created PageObjectManager into your step definition:
new AddPatientStepDefinition(new PageObjectManager())

Cucumber Scenario Starts
         ↓
PicoContainer creates PageObjectManager (via zero-arg constructor)
         ↓
PicoContainer creates AddPatientStepDefinition(PageObjectManager)
         ↓
Your test runs with pom already injected
Why It Fails When You Remove cucumber-picocontainer
Without the PicoContainer dependency:

Cucumber uses the default ObjectFactory (DefaultObjectFactory)

The default factory ONLY supports zero-argument constructors

Your constructor has 1 parameter →doesnt work
     */
    public AddPatientStepDefinition(PageObjectManager pom) {
        this.pom = pom;
        //pom = new PageObjectManager();
       // driver = DriverFactory.getDriver();
      //  addPatientPage = pom.getNewPatientPage();
        //loginPage = pom.getLoginPage();
        //dashboardPage = pom.getDashboardPage();
    }


    @When("User clicks on New Patient in the header section")
    public void user_clicks_on_new_patient_in_the_header_section() {
        logger.info("Clicking New Patient header link...");
        //dashboardPage.clicknavigationLink("NewPatient");
        pom.getDashboardPage().clicknavigationLink("NewPatient");
    }

    @Then("User should see Add Patient Details on the dialog box")
    public void user_should_see_add_patient_details_on_the_dialog_box() {

        logger.info("Validating Add Patient Details dialog...");
        boolean dialogIsValid =
                pom.getNewPatientPage().isDialogDisplayed() &&
                        pom.getNewPatientPage().getDialogTitle().equals("Add Patient Details");
        Assert.assertTrue(dialogIsValid,
                "Dialog is not displayed OR dialog title is incorrect");
    }


    @Then("User should see 9 input boxes in the Add Patient Details dialog box")
    public void user_should_see_9_input_boxes_in_the_add_patient_details_dialog_box() {

        //int actualCount = addPatientPage.getInputFieldCount();
        int actualCount = pom.getNewPatientPage().getInputFieldCount();
        Assert.assertEquals(actualCount, 9, "Input field count mismatch");

    }

    @Then("User should see 3 dropdowns in the Add Patient Details dialog box")
    public void user_should_see_3_dropdowns_in_the_add_patient_details_dialog_box() {

        //int actualCount = addPatientPage.getDropdownCount();
        int actualCount =  pom.getNewPatientPage().getDropdownCount();
        Assert.assertEquals(actualCount, 3, "Dropdown count mismatch");

    }


    @Then("User should see exactly 1 file upload option in Add Patient Details dialog box")
    public void user_should_see_exactly_1_file_upload_option_in_add_patient_details_dialog_box() {

        //int actualCount = addPatientPage.getFileUploadCount();
        int actualCount = pom.getNewPatientPage().getFileUploadCount();
        Assert.assertEquals(actualCount, 1, "File upload option count mismatch");

    }

    @Then("User should see one Submit button")
    public void user_should_see_one_submit_button() {

        //int actualCount = addPatientPage.getSubmitButtonCount();
        int actualCount = pom.getNewPatientPage().getSubmitButtonCount();
        Assert.assertEquals(actualCount, 1, "Submit button count mismatch");

    }

    @Then("User should see one Submit button in disabled state")
    public void user_should_see_one_submit_button_in_disabled_state() {

        logger.info("Validating disabled state of Submit button...");
        Assert.assertTrue(pom.getNewPatientPage().isSubmitButtonDisabled(), "Submit button is NOT disabled"
        );


    }

    @Then("User should see one Close button")
    public void user_should_see_one_close_button() {

        int actualCount = pom.getNewPatientPage().getCloseButtonCount();
        Assert.assertEquals(actualCount, 1, "Close button count mismatch");

    }

    @Then("User should see one Close button in enabled state")
    public void user_should_see_one_close_button_in_enabled_state() {

        logger.info("Validating enabled state of Close button...");

        Assert.assertTrue(
                pom.getNewPatientPage().isCloseButtonEnabled(),
                "Close button is NOT enabled"
        );

    }

    @Then("User should see mandatory field error for First name")
    public void user_should_see_mandatory_field_error_for_first_name() {

        logger.info("Validating mandatory error message for First Name...");

        pom.getNewPatientPage().clickFirstNameAndBlur();

        Assert.assertTrue(
                pom.getNewPatientPage().isFirstNameErrorDisplayed(),
                "Expected 'First name is required' error message was NOT displayed"
        );

    }

    @Then("User should see mandatory field with placeholder {string} for last name")
    public void user_should_see_mandatory_field_with_placeholder_for_last_name(String expectedPlaceholder) {

        logger.info("Validating placeholder and mandatory state for Last Name field...");

        String actualPlaceholder = pom.getNewPatientPage().getLastNamePlaceholder();
        boolean isMandatory = pom.getNewPatientPage().isLastNameMandatory();

        boolean isValid =
                actualPlaceholder.equals(expectedPlaceholder) &&
                        isMandatory;

        Assert.assertTrue(
                isValid,
                "Last Name validation failed. " +
                        "placeholder=" + actualPlaceholder +
                        ", mandatory=" + isMandatory
        );

    }

    @Then("User should see mandatory field with placeholder {string} for email")
    public void user_should_see_mandatory_field_with_placeholder_for_email(String expectedPlaceholder) {

        logger.info("Validating placeholder and mandatory state for Email field...");

        String actualPlaceholder = pom.getNewPatientPage().getEmailPlaceholder();
        boolean isMandatory = pom.getNewPatientPage().isEmailMandatory();

        boolean isValid =
                actualPlaceholder.equals(expectedPlaceholder) &&
                        isMandatory;

        Assert.assertTrue(
                isValid,
                "Email field validation failed. " +
                        "placeholder=" + actualPlaceholder +
                        ", mandatory=" + isMandatory
        );


    }

    @Then("User should see mandatory field with placeholder {string} for contact number")
    public void user_should_see_mandatory_field_with_placeholder_for_contact_number(String expectedPlaceholder) {

        logger.info("Validating placeholder and mandatory state for Contact Number field...");

        String actualPlaceholder = pom.getNewPatientPage().getContactNumberPlaceholder();
        boolean isMandatory = pom.getNewPatientPage().isContactNumberMandatory();

        boolean isValid =
                actualPlaceholder.equals(expectedPlaceholder) &&
                        isMandatory;

        Assert.assertTrue(
                isValid,
                "Contact Number field validation failed. " +
                        "placeholder=" + actualPlaceholder +
                        ", mandatory=" + isMandatory
        );


    }

    @Then("User should see mandatory dropdown with placeholder {string} for allergies")
    public void user_should_see_mandatory_dropdown_with_placeholder_for_allergies(String expectedPlaceholder) {
        logger.info("Validating placeholder and mandatory state for Allergies dropdown...");

        String actualText = pom.getNewPatientPage().getAllergiesSelectedText();
        boolean isMandatory = pom.getNewPatientPage().isAllergiesMandatory();

        boolean isValid =
                actualText.equals(expectedPlaceholder) &&
                        isMandatory;

        Assert.assertTrue(
                isValid,
                "Allergies dropdown validation failed. " +
                        "placeholder=" + actualText +
                        ", mandatory=" + isMandatory
        );


    }

    @Then("User should see mandatory dropdown with placeholder {string} for food preference")
    public void user_should_see_mandatory_dropdown_with_placeholder_for_food_preference(String expectedPlaceholder) {

        logger.info("Validating placeholder and mandatory state for Food Preference dropdown...");

        String actualText = pom.getNewPatientPage().getFoodPreferencePlaceholder();
        boolean isMandatory = pom.getNewPatientPage().isFoodPreferenceMandatory();

        boolean isValid =
                actualText.equals(expectedPlaceholder) &&
                        isMandatory;

        Assert.assertTrue(
                isValid,
                "Food Preference dropdown validation failed. " +
                        "placeholder=" + actualText +
                        ", mandatory=" + isMandatory
        );


    }

    @Then("User should see mandatory dropdown with placeholder {string} for cuisine category")
    public void user_should_see_mandatory_dropdown_with_placeholder_for_cuisine_category(String expectedPlaceholder) {

        logger.info("Validating placeholder and mandatory state for Cuisine Category dropdown...");

        String actualText = pom.getNewPatientPage().getCuisineCategoryPlaceholder();
        boolean isMandatory = pom.getNewPatientPage().isCuisineCategoryMandatory();

        boolean isValid =
                actualText.equals(expectedPlaceholder) &&
                        isMandatory;

        Assert.assertTrue(
                isValid,
                "Cuisine Category dropdown validation failed. " +
                        "placeholder=" + actualText +
                        ", mandatory=" + isMandatory
        );


    }

    @Then("User should see mandatory DOB with placeholder {string}")
    public void user_should_see_mandatory_dob_with_placeholder(String expectedPlaceholder) {

        logger.info("Validating placeholder and mandatory state for DOB field...");

        String actualPlaceholder = pom.getNewPatientPage().getDobPlaceholder();
        boolean isMandatory = pom.getNewPatientPage().isDobMandatory();

        boolean isValid =
                actualPlaceholder.equals(expectedPlaceholder) &&
                        isMandatory;

        Assert.assertTrue(
                isValid,
                "DOB field validation failed. " +
                        "placeholder=" + actualPlaceholder +
                        ", mandatory=" + isMandatory
        );


    }

    @Then("User should see non-mandatory field placeholder with {string} for weight")
    public void user_should_see_non_mandatory_field_placeholder_with_for_weight(String expectedPlaceholder) {

        logger.info("Validating placeholder and non-mandatory state for Weight field...");

        String actualPlaceholder = pom.getNewPatientPage().getWeightPlaceholder();
        boolean isMandatory = pom.getNewPatientPage().isWeightMandatory();

        boolean isValid =
                actualPlaceholder.equals(expectedPlaceholder) &&
                        !isMandatory;

        Assert.assertTrue(
                isValid,
                "Weight field validation failed. " +
                        "placeholder=" + actualPlaceholder +
                        ", mandatory=" + isMandatory
        );


    }

    @Then("User should see non-mandatory field placeholder with {string} for height")
    public void user_should_see_non_mandatory_field_placeholder_with_for_height(String expectedPlaceholder) {

        logger.info("Validating placeholder and non-mandatory state for Height field...");

        String actualPlaceholder = pom.getNewPatientPage().getHeightPlaceholder();
        boolean isMandatory = pom.getNewPatientPage().isHeightMandatory();

        boolean isValid =
                actualPlaceholder.equals(expectedPlaceholder) &&
                        !isMandatory;

        Assert.assertTrue(
                isValid,
                "Height field validation failed. " +
                        "placeholder=" + actualPlaceholder +
                        ", mandatory=" + isMandatory
        );


    }

    @Then("User should see non-mandatory field placeholder with {string} for temperature")
    public void user_should_see_non_mandatory_field_placeholder_with_for_temperature(String expectedPlaceholder) {

        logger.info("Validating placeholder and non-mandatory state for Temperature field...");

        String actualPlaceholder = pom.getNewPatientPage().getTemperaturePlaceholder();
        boolean isMandatory = pom.getNewPatientPage().isTemperatureMandatory();

        boolean isValid =
                actualPlaceholder.equals(expectedPlaceholder) &&
                        !isMandatory;

        Assert.assertTrue(
                isValid,
                "Temperature field validation failed. " +
                        "placeholder=" + actualPlaceholder +
                        ", mandatory=" + isMandatory
        );


    }

    @Then("User should see non-mandatory field placeholder with {string} for sp")
    public void user_should_see_non_mandatory_field_placeholder_with_for_sp(String expectedPlaceholder) {

        logger.info("Validating placeholder and non-mandatory state for SP field...");

        String actualPlaceholder = pom.getNewPatientPage().getSpPlaceholder();
        boolean isMandatory = pom.getNewPatientPage().isSpMandatory();

        boolean isValid =
                actualPlaceholder.equals(expectedPlaceholder) &&
                        !isMandatory;

        Assert.assertTrue(
                isValid,
                "SP field validation failed. " +
                        "placeholder=" + actualPlaceholder +
                        ", mandatory=" + isMandatory
        );

    }

    @Then("User should see non-mandatory field placeholder with {string} for dp")
    public void user_should_see_non_mandatory_field_placeholder_with_for_dp(String expectedPlaceholder) {

        logger.info("Validating placeholder and non-mandatory state for DP field...");

        String actualPlaceholder = pom.getNewPatientPage().getDpPlaceholder();
        boolean isMandatory = pom.getNewPatientPage().isDpMandatory();

        boolean isValid =
                actualPlaceholder.equals(expectedPlaceholder) &&
                        !isMandatory;

        Assert.assertTrue(
                isValid,
                "DP field validation failed. " +
                        "placeholder=" + actualPlaceholder +
                        ", mandatory=" + isMandatory
        );


    }

    @Then("User should see text Upload Health Report")
    public void user_should_see_text_upload_health_report() {

        logger.info("Validating presence of Upload Health Report text...");

        boolean isVisible = pom.getNewPatientPage().isUploadHealthReportVisible();

        Assert.assertTrue(
                isVisible,
                "Upload Health Report text is NOT visible"
        );


    }

    @Then("User should see text No file Chosen")
    public void user_should_see_text_no_file_chosen() {

        logger.info("Validating presence of 'No file Chosen' text...");

        boolean isVisible = pom.getNewPatientPage().isNoFileChosenVisible();

        Assert.assertTrue(
                isVisible,
                "'No file Chosen' text is NOT visible"
        );


    }

    @Then("User should see a scroll bar at the right side of dialog box")
    public void user_should_see_a_scroll_bar_at_the_right_side_of_dialog_box() {

        logger.info("Validating presence of scroll bar on dialog box...");

        boolean isScrollable = pom.getNewPatientPage().isDialogScrollable();

        Assert.assertTrue(
                isScrollable,
                "Scroll bar is NOT present on the dialog box"
        );


    }

    @When("User clicks on Allergy dropdown")
    public void user_clicks_on_allergy_dropdown() {

        logger.info("Clicking Allergy dropdown...");
        pom.getNewPatientPage().clickAllergyDropdown();

    }

    @Then("Values should be present inside Allergy dropdown")
    public void values_should_be_present_inside_allergy_dropdown() {

        logger.info("Validating Allergy dropdown values...");


        List<String> actualValues = pom.getNewPatientPage().getAllergyDropdownValues();


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

    }


    @Then("Dropdown should contain {int} values")
    public void dropdown_should_contain_values(Integer expectedCount) {

        logger.info("Validating number of values in Allergy dropdown...");

        List<String> actualValues = pom.getNewPatientPage().getAllergyDropdownValues();

        int actualCount = actualValues.size();

        Assert.assertEquals(
                actualCount,
                expectedCount,
                "Mismatch in number of Allergy dropdown values. Actual: " + actualCount
        );


    }

    @Then("Dropdown should contain specific allergy values")
    public void dropdown_should_contain_specific_allergy_values() {

        logger.info("Validating specific Allergy dropdown values from Excel...");


        List<String> actualValues = pom.getNewPatientPage().getAllergyDropdownValues();


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


    }

    @When("User clicks on Food Preference dropdown")
    public void user_clicks_on_food_preference_dropdown() {

        logger.info("Clicking Food Preference dropdown...");
        pom.getNewPatientPage().clickFoodPreferenceDropdown();

    }

    @Then("Values should be present inside Food preference dropdown")
    public void values_should_be_present_inside_food_preference_dropdown() {

        logger.info("Validating Food Preference dropdown values from Excel...");


        List<String> actualValues = pom.getNewPatientPage().getFoodPreferenceDropdownValues();


        List<Map<String, String>> excelData =
                ExcelReader.readDataFromExcel("foodPreference");

        List<String> expectedValues = excelData.stream()
                .map(row -> row.get("Values"))
                .toList();

        boolean isValid = actualValues.containsAll(expectedValues);

        Assert.assertTrue(
                isValid,
                "Food Preference dropdown values mismatch.Expected: " + expectedValues +
                        "Actual: " + actualValues
        );


    }


    @Then("Dropdown should contain {int} values in Food Preference dropdown")
    public void dropdown_should_contain_values_in_food_preference_dropdown(Integer expectedCount) {

        logger.info("Validating number of values in Food Preference dropdown...");

        List<String> actualValues = pom.getNewPatientPage().getFoodPreferenceDropdownValues();
        int actualCount = actualValues.size();

        Assert.assertEquals(
                actualCount,
                expectedCount,
                "Mismatch in number of Food Preference dropdown values. Actual: " + actualCount
        );


    }


    @Then("Dropdown should contain specific Food Preference values")
    public void dropdown_should_contain_specific_food_preference_values() {

        logger.info("Validating Food Preference dropdown values from Excel...");


        List<String> actualValues =  pom.getNewPatientPage().getFoodPreferenceDropdownValues();


        List<Map<String, String>> excelData =
                ExcelReader.readDataFromExcel("foodPreference");

        List<String> expectedValues = excelData.stream()
                .map(row -> row.get("Values"))
                .toList();

        boolean isValid = actualValues.containsAll(expectedValues);

        Assert.assertTrue(
                isValid,
                "Food Preference dropdown values mismatch.Expected: " + expectedValues +
                        "Actual: " + actualValues
        );


    }

    @When("User clicks on Cuisine dropdown")
    public void user_clicks_on_cuisine_dropdown() {

        logger.info("Clicking Cuisine dropdown...");
        pom.getNewPatientPage().clickCuisineDropdown();

    }

    @Then("Values should be present inside Cuisine dropdown")
    public void values_should_be_present_inside_cuisine_dropdown() {

        logger.info("Validating Cuisine dropdown values from Excel...");
        List<String> actualValues = pom.getNewPatientPage().getCuisineDropdownValues();

        List<Map<String, String>> excelData =
                ExcelReader.readDataFromExcel("cuisine");

        List<String> expectedValues = excelData.stream()
                .map(row -> row.get("Values"))
                .toList();
        boolean isValid = actualValues.containsAll(expectedValues);
        Assert.assertTrue(
                isValid,
                "Cuisine dropdown values mismatch.Expected: " + expectedValues +
                        "Actual: " + actualValues
        );


    }


    @Then("Cuisine dropdown should contain {int} values")
    public void cuisine_dropdown_should_contain_values(Integer expectedCount) {

        logger.info("Validating number of values in Cuisine dropdown...");
        List<String> actualValues = pom.getNewPatientPage().getCuisineDropdownValues();
        int actualCount = actualValues.size();
        Assert.assertEquals(
                actualCount,
                expectedCount,
                "Mismatch in number of Cuisine dropdown values. Actual: " + actualCount
        );


    }

    @Then("Dropdown should contain specific Cuisine values")
    public void dropdown_should_contain_specific_cuisine_values() {

        logger.info("Validating Cuisine dropdown values from Excel...");
        List<String> actualValues = pom.getNewPatientPage().getCuisineDropdownValues();
        List<Map<String, String>> excelData =
                ExcelReader.readDataFromExcel("cuisine");
        List<String> expectedValues = excelData.stream()
                .map(row -> row.get("Values"))
                .toList();
        boolean isValid = actualValues.containsAll(expectedValues);
        Assert.assertTrue(isValid, "Cuisine dropdown values mismatch.Expected: " + expectedValues + "Actual: " + actualValues
        );

    }


    @When("User enters valid values in all required fields")
    public void user_enters_valid_values_in_all_required_fields() {

        logger.info("Reading required fields from Excel...");
        List<Map<String, String>> excelData = ExcelReader.readDataFromExcel("requiredFields");
        pom.getNewPatientPage().fillRequiredFieldsFromExcel(excelData);

    }

    @Then("Submit button should be enabled")
    public void submit_button_should_be_enabled() {

        boolean enabled = pom.getNewPatientPage().isSubmitButtonEnabled();

        Assert.assertTrue(enabled, "Submit button is NOT enabled even after filling all required fields."
        );


    }

    @When("User clicks Submit after entering valid data in all mandatory fields")
    public void user_clicks_submit_after_entering_valid_data() {

        logger.info("Clicking Submit button after filling mandatory fields...");
        List<Map<String, String>> excelData =
                ExcelReader.readDataFromExcel("requiredFields");
        pom.getNewPatientPage().fillRequiredFieldsFromExcel(excelData);
        pom.getNewPatientPage().clickSubmitButton();

    }

    @Then("User should see patient successfully created toast message")
    public void user_should_see_patient_successfully_created_toast_message() {

        logger.info("Validating success toast message...");

        String actualToast = pom.getNewPatientPage().getToastMessageText();

        Assert.assertEquals(actualToast, "Patient successfully created", "Toast message mismatch"
        );


    }


    @Then("User is directed to My Patient Page with New Patient Details created")
    public void user_is_directed_to_my_patient_page_with_new_patient_details_created() {


        pom.getNewPatientPage().goToMyPatients();
        List<Map<String, String>> excelData = ExcelReader.readDataFromExcel("requiredFields");
        String firstName = excelData.get(0).get("firstName");
        String lastName = excelData.get(0).get("lastName");
        boolean isPresent = pom.getNewPatientPage().isPatientPresent(firstName, lastName);
        Assert.assertTrue(isPresent, "User was NOT directed to My Patient Page with the new patient details created"
        );

    }

    @When("User selects {string} from Allergy dropdown")
    public void user_selects_from_allergy_dropdown(String allergy) {

        pom.getNewPatientPage().selectAllergy(allergy);

    }

    @Then("{string} should be selected in the Allergy field")
    public void should_be_selected_in_the_allergy_field(String expected) {


        String actual = pom.getNewPatientPage().getSelectedAllergy();

        Assert.assertEquals(actual, expected, "Allergy field does not show the expected selected value"
        );

    }

    @When("User selects {string} and {string} from Allergy dropdown")
    public void user_selects_and_from_allergy_dropdown(String first, String second) {


        pom.getNewPatientPage().selectAllergy(first);
        pom.getNewPatientPage().selectAllergy(second);


    }

    @When("User tries to select {string} from Allergy dropdown")
    public void user_tries_to_select_from_allergy_dropdown(String allergy) {

        selectionAttempt = pom.getNewPatientPage().trySelectAllergy(allergy);

    }


    @Then("No selection should occur in the Allergy field")
    public void no_selection_should_occur_in_the_allergy_field() {


        String actual = pom.getNewPatientPage().getSelectedAllergy();
        Assert.assertEquals(actual, "Allergies", "Allergy field changed unexpectedly — no selection should have occurred"
        );

    }


    @When("User selects {string} from Food Preference dropdown")
    public void user_selects_from_food_preference_dropdown(String preference) {
        pom.getNewPatientPage().selectFoodPreference(preference);
    }

    @Then("{string} should be selected in the Food Preference field")
    public void should_be_selected_in_the_food_preference_field(String expected) {

        String actual = pom.getNewPatientPage().getSelectedFoodPreference();
        Assert.assertEquals(actual, expected, "Food Preference field does not show the expected selected value"
        );

    }

    @When("User selects {string} and {string} from Food Preference dropdown")
    public void user_selects_and_from_food_preference_dropdown(String first, String second) {

        pom.getNewPatientPage().selectFoodPreference(first);
        pom.getNewPatientPage().selectFoodPreference(second);

    }

    @When("User tries to select {string} from Food Preference dropdown")
    public void user_tries_to_select_from_food_preference_dropdown(String preference) {

        selectionAttempt = pom.getNewPatientPage().trySelectFoodPreference(preference);

    }

    @Then("No selection should occur in the Food Preference field")
    public void no_selection_should_occur_in_the_food_preference_field() {

        String actual = pom.getNewPatientPage().getSelectedFoodPreference();
        Assert.assertEquals(actual, "Food Preference", "Food Preference field changed unexpectedly — no selection should have occurred"
        );

    }


    @When("User selects {string} from Cuisine Category dropdown")
    public void user_selects_from_cuisine_category_dropdown(String category) {

        pom.getNewPatientPage().selectCuisineCategory(category);

    }


    @Then("{string} should be selected in the Cuisine Category field")
    public void should_be_selected_in_the_cuisine_category_field(String expected) {

        String actual = pom.getNewPatientPage().getCuisineCategoryPlaceholder();
        Assert.assertEquals(actual, expected, "Cuisine Category field does not show the expected selected value"
        );

    }

    @When("User selects {string} and {string} from Cuisine Category dropdown")
    public void user_selects_and_from_cuisine_category_dropdown(String first, String second) {

        pom.getNewPatientPage().selectCuisineCategory(first);
        pom.getNewPatientPage().selectCuisineCategory(second);

    }

    @When("User tries to select {string} from Cuisine Category dropdown")
    public void user_tries_to_select_from_cuisine_category_dropdown(String category) {

        selectionAttempt = pom.getNewPatientPage().trySelectCuisineCategory(category);

    }


    @Then("No selection should occur in the Cuisine Category field")
    public void no_selection_should_occur_in_the_cuisine_category_field() {


        String actual = pom.getNewPatientPage().getCuisineCategoryPlaceholder();
        Assert.assertTrue(!selectionAttempt && actual.equals("Cuisine Category"), "Cuisine Category field changed unexpectedly or invalid selection was allowed"
        );

    }

    @When("User clicks Date of Birth field")
    public void user_clicks_date_of_birth_field() {

        pom.getNewPatientPage().clickDOBField();


    }

    @Then("User should see calender date picker displayed with Month,Day,Year")
    public void user_should_see_calendar_date_picker_displayed_with_month_day_year() {


        boolean visible = pom.getNewPatientPage().isCalendarVisible();
        boolean hasMonth = pom.getNewPatientPage().hasMonthDropdown();
        boolean hasYear = pom.getNewPatientPage().hasYearInput();
        boolean hasDay = pom.getNewPatientPage().hasDayCells();

        Assert.assertTrue(
                visible && hasMonth && hasYear && hasDay,
                "DOB date picker is missing Month/Day/Year or did not appear"
        );


    }

    }

