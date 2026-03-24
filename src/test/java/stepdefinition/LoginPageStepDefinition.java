package stepdefinition;

import java.io.IOException;
import java.util.List;

import DriverManager.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.PageObjectManager;
import utils.ConfigReader;
import utils.ElementUtil;
import utils.TestContext;

public class LoginPageStepDefinition {

	private final PageObjectManager pom;
	private static final Logger logger = LoggerFactory.getLogger(LoginPageStepDefinition.class);
	WebDriver driver;
	private LoginPage loginPage;

	public LoginPageStepDefinition() {
        pom = new PageObjectManager(driver);
		driver = DriverFactory.getDriver();
		loginPage = pom.getLoginPage();
	}
	/*
	 * // Background step
	 * 
	 * @Given("the registered user has navigated to the home page") public void
	 * the_registered_user_has_navigated_to_the_home_page() {
	 * DriverFactory.getDriver().get(ConfigReader.getProperty("baseURL")); }
	 * 
	 * @When("the user clicks sign in link") public void
	 * the_user_clicks_sign_in_link() { // Write code here that turns the phrase
	 * above into concrete actions //throw new io.cucumber.java.PendingException();
	 * }
	 * 
	 * @Then("User must see {int} input fields in Login UI") public void
	 * user_must_see_input_fields_in_login_ui(Integer int1) { // Write code here
	 * that turns the phrase above into concrete actions //throw new
	 * io.cucumber.java.PendingException(); }
	 */

    @Then("User should see the text {string} on the left side of navigation bar")
    public void user_should_see_the_text_on_the_left_side_of_navigation_bar(String pageHeading) {
        try {
            String actualHeading = pom.getLoginPage().getPageHeadingText();
            Assert.assertEquals(actualHeading, pageHeading,
                    "Page heading text does not match expected value.");
        } catch (Exception e) {
            Assert.fail("Failed to validate page heading text ", e);
        }
    }


    @Then("User should see the home icon on the left side of navigation bar")
	public void user_should_see_the_home_icon_on_the_left_side_of_navigation_bar() {
		Assert.assertTrue(pom.getLoginPage().isHomeIconVisible(),
				"Home icon is not visible on the left side of the navigation bar.");
	}

	@Then("Navigation bar background should have a blue-purple color")
	public void navigation_bar_background_should_have_a_blue_purple_color() {
		Assert.assertEquals(pom.getLoginPage().getNavbarBackgroundColor(), "rgba(75, 0, 130, 1)",
				"Navigation bar background color does not match expected blue-purple color.");
	}

	@Then("Heading {string} should be visible inside the login card")
	public void heading_should_be_visible_inside_the_login_card(String loginboxheading) {
		Assert.assertEquals(pom.getLoginPage().getapploginHeadingText(), loginboxheading,
				"Login card heading text does not match expected value.");
	}

	@Then("User should see label with text in Login UI")
	public void user_should_see_label_with_text_in_login_ui(io.cucumber.datatable.DataTable dataTable) {

		List<String> expectedLabels = dataTable.asList();
		List<String> actualLabels = pom.getLoginPage().getLabeltext();
		Assert.assertEquals(actualLabels, expectedLabels, "Label texts do not match expected values.");
	}

	@Then("input field should be visible in Login UI")
	public void input_field_should_be_visible_in_login_ui(io.cucumber.datatable.DataTable dataTable) {

		List<String> expectedFields = dataTable.asList();
		for (String field : expectedFields) {
			Assert.assertTrue(pom.getLoginPage().isFieldVisible(field),
					"Input field '" + field + "' is not visible in Login UI.");
		}
	}

	@Then("login button should be visible in Login UI")
	public void login_button_should_be_visible_in_login_ui() {
		Assert.assertTrue(pom.getLoginPage().isLoginButtonVisible(), "Login button is not visible in Login UI.");
	}

	@Then("Login button should be displayed with a blue-purple background and white text")
	public void login_button_should_be_displayed_with_a_blue_purple_background_and_white_text() {
	Assert.assertTrue(pom.getLoginPage().isLoginButtonStyledCorrectly(),
				"Login button does not have the expected blue-purple background and white text.");
	}
	
	@Then("Username and Password labels should be left-aligned above their respective input fields")
	public void username_and_password_labels_should_be_left_aligned_above_their_respective_input_fields() {
		Assert.assertTrue(pom.getLoginPage().isLebelsleftalignedaboveInputField(), "Labels are not left-aligned above their respective input fields.");
	}
	
	@Then("User should see exactly two input field")
	public void user_should_see_exactly_two_input_field() {
	Assert.assertEquals(pom.getLoginPage().getLabelCount(), 2, "The number of input fields does not match the expected count of 2.");	
	}

	@Then("User should see login button enabled")
	public void user_should_see_login_button_enabled() {
	Assert.assertTrue(pom.getLoginPage().isLoginButtonEnabled(), "Login button is not enabled.");
	}

	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
		logger.info("User is on" + ElementUtil.getURL() + " page.");
	}

	@When("the user {string} with {string}")
	public void the_user_with(String submissionMethod, String scenarioType) {
		logger.info("Submitting login form using {} for scenario: {}", submissionMethod, scenarioType);
		pom.getLoginPage().login(submissionMethod, scenarioType);
		
	}

	@Then("the appropriate error messages should be displayed in {string}")
	public void the_appropriate_error_messages_should_be_displayed_in(String expectedErrorMessage) {
		String actualErrorMessage = pom.getLoginPage().getErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
				"Actual error message does not match expected error message.");
	}
	
	
	@Then("the user should be redirected to the Dashboard Page")
	public void the_user_should_be_redirected_to_the_dashboard_page() {
	
		Assert.assertTrue(ElementUtil.getURL().contains("dashboard"), "User is not redirected to the Dashboard Page.");
	}
}