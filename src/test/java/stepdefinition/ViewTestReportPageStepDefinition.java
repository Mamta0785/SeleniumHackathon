package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import DriverManager.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PageObjectManager;
import pages.ViewTestReportPage;


public class ViewTestReportPageStepDefinition {
	
	private final PageObjectManager pom;
	private static final Logger logger = LoggerFactory.getLogger(ViewTestReportPageStepDefinition.class);
	WebDriver driver;
	private ViewTestReportPage viewtestreportPage;
	
	public ViewTestReportPageStepDefinition() {
		pom = new PageObjectManager();
		driver = DriverFactory.getDriver();
		viewtestreportPage = pom.getViewTestReportPage();
	}
	
	
	/*@Given("User is on the {string} page")
	public void user_is_on_the_page(String link) {
		pom.getDashboardPage().clicknavigationLink(link);
		logger.info("Successfully clicked navigation link: {}", link);
	    //logger.info("User is on" + ElementUtil.getURL() + "page");
	}*/
	
	@When("User clicks the View Previous Test Reports button for a specific record")
	public void user_clicks_the_view_previous_test_reports_button_for_a_specific_record() {
		logger.info("Clicking View Previous Test Report button");
		viewtestreportPage.clickViewTestReportButton();
	}

	@Then("the corresponding report for that record should be opened")
	public void the_corresponding_report_for_that_record_should_be_opened() {
		Assert.assertTrue(
                viewtestreportPage.isReportOpenedForSelectedRecord(),
                "Report did not open for the selected record"
        );

	}

	@Then("the title {string} should be displayed")
	public void the_title_should_be_displayed(String expectedTitle) {
		logger.info("Verifying page title is: {}", expectedTitle);
        Assert.assertEquals(
                viewtestreportPage.getPageTitle(),
                expectedTitle,
                "Page title mismatch"
        );

	}

	@Then("the Close icon {string} should be displayed")
	public void the_close_icon_should_be_displayed(String string) {
		logger.info("Verifying Close Button is displayed");
        Assert.assertTrue(viewtestreportPage.isCloseButtonDisplayed(),
                "Close Button is not displayed");
	}

	@Then("the Patient Id corresponding to the selected record should be displayed")
	public void the_patient_id_corresponding_to_the_selected_record_should_be_displayed() {
		logger.info("Verifying Patient Id is displayed");
        Assert.assertTrue(viewtestreportPage.isPatientIdDisplayed(),
                "Patient Id is not displayed");

	}

	@Then("the Patient Name corresponding to the selected record should be displayed")
	public void the_patient_name_corresponding_to_the_selected_record_should_be_displayed() {
		logger.info("Verifying Patient Name is displayed");
        Assert.assertTrue(viewtestreportPage.isPatientNameDisplayed(),
                "Patient Name is not displayed");
	}

	@Then("the Patient Email corresponding to the selected record should be displayed")
	public void the_patient_email_corresponding_to_the_selected_record_should_be_displayed() {
		logger.info("Verifying Patient Email is displayed");
        Assert.assertTrue(viewtestreportPage.isPatientEmailDisplayed(),
                "Patient Email is not displayed");
	}

	@Then("the Contact Number corresponding to the selected record should be displayed")
	public void the_contact_number_corresponding_to_the_selected_record_should_be_displayed() {
		logger.info("Verifying Patient Contact Number is displayed");
        Assert.assertTrue(viewtestreportPage.isPatientContactNumberDisplayed(),
                "Patient Contact Number is not displayed");
	}

	@Then("the Reports table should be displayed")
	public void the_reports_table_should_be_displayed() {
		logger.info("Verifying Report table is displayed");
        Assert.assertTrue(viewtestreportPage.isReportTableDisplayed(),
                "Report table is not displayed");
	}

	@Then("the pagination controls First , Previous , Next , Last  arrows should be displayed")
	public void the_pagination_controls_first_previous_next_last_arrows_should_be_displayed() {
		logger.info("Verifying all pagination controls are displayed");
	    viewtestreportPage.isPaginationControlsDisplayed();
	}

	@Then("the table header {string} should be displayed")
	public void the_table_header_should_be_displayed(String header) {
		logger.info("Verifying Table Header is displayed");
        viewtestreportPage.isTableHeaderDisplayed(header);
                
	}

	@Then("the headers should appear in the exact order: Record Number → File → Uploaded Time → File\\/Report Name → Vitals → Identified Health Conditions")
	public void the_headers_should_appear_in_the_exact_order_record_number_file_uploaded_time_file_report_name_vitals_identified_health_conditions() {
	    
	}

	@Then("each report row should display {string}")
	public void each_report_row_should_display(String string) {
	    
	}
	
	@Then("Vitals should be displayed in the order: Weight → Height → Temperature → SP → DP")
	public void vitals_should_be_displayed_in_the_order_weight_height_temperature_sp_dp() {
		 logger.info("Verifying Vitals are displayed in correct order");
		    viewtestreportPage.verifyVitalsOrder();
	}

	@Then("Vitals should be displayed in multiline format")
	public void vitals_should_be_displayed_in_multiline_format() {
	    
	}

	@Then("Identified Health Conditions should be displayed in multiline format")
	public void identified_health_conditions_should_be_displayed_in_multiline_format() {
	    
	}

	@Given("User is on the View Patient Test Reports page")
	public void user_is_on_the_view_patient_test_reports_page() {
	
	}

	@When("User clicks the View PDF button for a particular record")
	public void user_clicks_the_view_pdf_button_for_a_particular_record() {
	    
	}

	@Then("the corresponding PDF report for that record should be opened")
	public void the_corresponding_pdf_report_for_that_record_should_be_opened() {
	   
	}

	@When("User clicks any page navigation arrow")
	public void user_clicks_any_page_navigation_arrow() {
	   
	}

	@Then("the pagination text should display the correct range and total number of records")
	public void the_pagination_text_should_display_the_correct_range_and_total_number_of_records() {
	    
	}

	@When("User navigates to any page")
	public void user_navigates_to_any_page() {
	    
	}

	@Then("the pagination controls should be displayed")
	public void the_pagination_controls_should_be_displayed() {
		
	}
	
	@When("User clicks the {string} arrow")
	public void user_clicks_the_arrow(String string) {
	    
	}
	
	@Then("{string}")
	public void string(String string) {
	    
	}
	
	@When("User navigates to the first page")
	public void user_navigates_to_the_first_page() {
	    
	}
	
	@Then("the {string} should be {string}")
	public void the_should_be(String string, String string2) {
	    
	}

	@When("User navigates to any page after the first page")
	public void user_navigates_to_any_page_after_the_first_page() {
	    
	}

	@Then("the Previous \\(<) should be enabled")
	public void the_previous_should_be_enabled() {
	 
	}

	@Then("the First page \\(<<) should be enabled")
	public void the_first_page_should_be_enabled() {
	    
	}

	@When("User navigates to any page except the last page")
	public void user_navigates_to_any_page_except_the_last_page() {
	    
	}

	@When("User navigates to the last page")
	public void user_navigates_to_the_last_page() {
	   
	}

	@Then("the Next \\(>) should be disabled")
	public void the_next_should_be_disabled() {
	    
	}

	@Then("the Last page \\(>>) should be disabled")
	public void the_last_page_should_be_disabled() {
	    
	}

	@When("User views any page of the Reports table")
	public void user_views_any_page_of_the_reports_table() {
	    
	}

	@Then("only {int} records should be visible on that page")
	public void only_records_should_be_visible_on_that_page(Integer int1) {
	    
	}

	@When("User views the pagination controls")
	public void user_views_the_pagination_controls() {
	   
	}

	@Then("the {string} should be disabled")
	public void the_should_be_disabled(String string) {
	    
	}
	
	@Then("{string} should be displayed")
	public void should_be_displayed(String string) {
	   
	}

}
