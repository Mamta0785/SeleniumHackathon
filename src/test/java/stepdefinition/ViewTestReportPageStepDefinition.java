package stepdefinition;

import DriverManager.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pages.PageObjectManager;
import pages.ViewTestReportPage;


public class ViewTestReportPageStepDefinition {

    private final PageObjectManager pom;
    private static final Logger logger = LoggerFactory.getLogger(ViewTestReportPageStepDefinition.class);
    WebDriver driver;
    private ViewTestReportPage viewtestreportPage;

    public ViewTestReportPageStepDefinition(PageObjectManager pom) {
        this.pom=pom;
       // pom = new PageObjectManager();
        driver = DriverFactory.getDriver();
        viewtestreportPage = pom.getViewTestReportPage();
    }


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

    @Then("Vitals should be displayed in the order: Weight → Height → Temperature → SP → DP")
    public void vitals_should_be_displayed_in_the_order_weight_height_temperature_sp_dp() {
        logger.info("Verifying Vitals are displayed in correct order");
        viewtestreportPage.verifyVitalsOrder();
    }


}
