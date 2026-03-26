package stepdefinition;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import DriverManager.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MyPatientPage;
import pages.PageObjectManager;

public class MyPatientPageStepdefinition {
	private final PageObjectManager pom;
	private static final Logger logger = LoggerFactory.getLogger(LoginPageStepDefinition.class);
	WebDriver driver;
	private MyPatientPage myPatientPage;

	public MyPatientPageStepdefinition() {
		pom = new PageObjectManager();
		driver = DriverFactory.getDriver();
		myPatientPage = pom.getMyPatientPage();
	}

	@Then("Page header {string} should be displayed")
	public void page_header_should_be_displayed(String pageHeader) {
		Assert.assertEquals(pom.getMyPatientPage().getPageHeadingText(), pageHeader,
				"Page header text does not match expected value.");
	}

	@Then("Search bar should be displayed")
	public void search_bar_should_be_displayed() {
		Assert.assertTrue(pom.getMyPatientPage().isSearchBoxVisible(),
				"Search bar is not visible on My Patients page.");
	}

	@Then("Search icon should be displayed inside the search bar")
	public void search_icon_should_be_displayed_inside_the_search_bar() {
		Assert.assertTrue(pom.getMyPatientPage().isSearchIconVisible(),
				"Search icon is not visible inside the search bar on My Patients page.");
	}

	@Then("Placeholder text {string} should be displayed")
	public void placeholder_text_should_be_displayed(String string) {
		Assert.assertEquals(pom.getMyPatientPage().getSearchBoxPlaceholderText(), string,
				"Search box placeholder text does not match expected value.");
	}

	@Then("Table should have column headers with text")
	public void table_should_have_column_headers_with_text(DataTable dataTable) {
		List<String> expectedHeaders = dataTable.asList();
		List<String> actualHeaders = pom.getMyPatientPage().getTableHeaderTexts();
		Assert.assertEquals(actualHeaders, expectedHeaders, "Table column headers do not match expected values.");
	}

	@Then("Up and down arrow icons should be displayed in the {string} header")
	public void up_and_down_arrow_icons_should_be_displayed_in_the_header(String columnname) {
		Assert.assertTrue(pom.getMyPatientPage().isSortIconVisible(columnname),
				"Up and down arrow icons are not visible in the " + columnname + " column header.");
	}

	@Then("user should see the values in all coulmns of the table for each patient record")
	public void user_should_see_the_values_in_all_coulmns_of_the_table_for_each_patient_record() {
		Assert.assertTrue(pom.getMyPatientPage().isPatientListDisplayed(),
				"Patient records are not displayed in the table.");
	}

	@Then("{string} values should be displayed for each patient record")
	public void values_should_be_displayed_for_each_patient_record(String columnHeader) {
		Assert.assertTrue(pom.getMyPatientPage().iscolumnheadervaluePresent(columnHeader),
				"Values not present for" + columnHeader);

	}

	@Then("Patient Id values should be displayed for each patient record")
	public void patient_id_values_should_be_displayed_for_each_patient_record() {

	}

	@Then("Name values should be displayed for each patient record")
	public void name_values_should_be_displayed_for_each_patient_record() {

	}

	@Then("Last Visit Date values should be displayed for each patient record")
	public void last_visit_date_values_should_be_displayed_for_each_patient_record() {

	}

	@Then("Details column should display below details for each patient record")
	public void details_column_should_display_below_details_for_each_patient_record(DataTable dataTable) {
		List<String> expecteddetails = dataTable.asList();
		List<String> actualdetails = pom.getMyPatientPage().getDetailsrowText();
		Assert.assertEquals(actualdetails, expecteddetails, "Details displayed do not match expected details");

	}

	@Then("Phone number, email , date of birth should be displayed on separate lines for each patient record")
	public void phone_number_email_date_of_birth_should_be_displayed_on_separate_lines_for_each_patient_record() {
		Assert.assertTrue(pom.getMyPatientPage().isdetailsDisplayednextline(),
				"Details not displayed on seperate lines");

	}

	@Then("{string} in details column should be displayed in correct {string} for each patient record")
	public void in_details_column_should_be_displayed_in_correct_for_each_patient_record(String detailsColumn,
			String format) {
		Assert.assertTrue(pom.getMyPatientPage().isDetailFormatValid(detailsColumn),
				"details are not matching with " + format);
	}

	@Then("Last visit date should be displayed in correct format MM\\/DD\\/YYYY for each patient record")
	public void last_visit_date_should_be_displayed_in_correct_format_mm_dd_yyyy_for_each_patient_record() {
		Assert.assertTrue(pom.getMyPatientPage().isLastDateFormatValid("LastVisitDate"), "Last Date format mismatch");
	}

	@Then("button should be displayed under action column for each patient record")
	public void button_should_be_displayed_under_action_column_for_each_patient_record(DataTable dataTable) {
		List<String> buttons = dataTable.asList();
		Assert.assertTrue(pom.getMyPatientPage().areActionBtnDisplayed(buttons), "Button is not displayed");
	}

	@Then("{string} icon should be displayed for each patient record")
	public void icon_should_be_displayed_for_each_patient_record(String icon) {
		Assert.assertTrue(pom.getMyPatientPage().isIconVisible(icon), "Icon is not displayed");
	}

	@When("User clicks {string} arrow in {string} column")
	public void user_clicks_arrow_in_column(String arrow, String column) {
	pom.getMyPatientPage().clicksortarrow(column, arrow);
	}

	@Then("Patient records should be sorted in {string} order for {string}")
	public void patient_records_should_be_sorted_in_order_for(String string, String string2) {
		
	}

	@When("User clicks up arrow in Patient Id column")
	public void user_clicks_up_arrow_in_patient_id_column() {

	}

	@Then("Patient records should be sorted in ascending order for Patient Id")
	public void patient_records_should_be_sorted_in_ascending_order_for_patient_id() {

	}

	@When("User clicks down arrow in Patient Id column")
	public void user_clicks_down_arrow_in_patient_id_column() {

	}

	@Then("Patient records should be sorted in descending order for Patient Id")
	public void patient_records_should_be_sorted_in_descending_order_for_patient_id() {

	}

	@When("User clicks up arrow in Name column")
	public void user_clicks_up_arrow_in_name_column() {

	}

	@Then("Patient records should be sorted in ascending order for Name")
	public void patient_records_should_be_sorted_in_ascending_order_for_name() {

	}

	@When("User clicks down arrow in Name column")
	public void user_clicks_down_arrow_in_name_column() {

	}

	@Then("Patient records should be sorted in descending order for Name")
	public void patient_records_should_be_sorted_in_descending_order_for_name() {

	}

	@When("User searches using <input>")
	public void user_searches_using_input() {

	}

	@Then("Matching patient details should be displayed")
	public void matching_patient_details_should_be_displayed() {

	}

	@When("user enters text in search bar and then clears the search input")
	public void user_enters_text_in_search_bar_and_then_clears_the_search_input() {

	}

	@Then("All patient records should be displayed again in the table")
	public void all_patient_records_should_be_displayed_again_in_the_table() {

	}

	@When("User clicks {string} from pagination arrow")
	public void user_clicks_from_pagination_arrow(String string) {

	}

	@Then("{string} page of patient records should be displayed")
	public void page_of_patient_records_should_be_displayed(String string) {

	}

	@Given("the user is on any page of {string}")
	public void the_user_is_on_any_page_of(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user navigates using pagination")
	public void the_user_navigates_using_pagination() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("pagination text should display correct range and total number of patients")
	public void pagination_text_should_display_correct_range_and_total_number_of_patients() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user is on {string} of My Patients page with multiple pages of patient records")
	public void the_user_is_on_of_my_patients_page_with_multiple_pages_of_patient_records(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("{string} arrow should be {string}")
	public void arrow_should_be(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("First, previous, next, last arrows should be disabled")
	public void first_previous_next_last_arrows_should_be_disabled() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("{string} text should be displayed")
	public void text_should_be_displayed(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("User should see only {int} records in each page")
	public void user_should_see_only_records_in_each_page(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("User adds 6th record")
	public void user_adds_6th_record() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("User should see the newly added record in the next page")
	public void user_should_see_the_newly_added_record_in_the_next_page() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("User should be navigated to {string} page")
	public void user_should_be_navigated_to_page(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("My Patients page should display with empty table")
	public void my_patients_page_should_display_with_empty_table() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("User is on the {string} page")
	public void user_is_on_the_page(String link) {
		pom.getDashboardPage().clicknavigationLink(link);
	}

	@When("User searches using {string}")
	public void user_searches_using(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


}
