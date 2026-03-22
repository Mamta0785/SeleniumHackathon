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
        pom = new PageObjectManager();
        driver = DriverFactory.getDriver();
        loginPage = pom.getLoginPage();
	}

	// Background step
    @Given("the registered user has navigated to the home page")
    public void the_registered_user_has_navigated_to_the_home_page() {
        DriverFactory.getDriver().get(ConfigReader.getProperty("baseURL"));
    }
    @When("the user clicks sign in link")
    public void the_user_clicks_sign_in_link() {
        // Write code here that turns the phrase above into concrete actions
       //throw new io.cucumber.java.PendingException();
    }
    @Then("User must see {int} input fields in Login UI")
    public void user_must_see_input_fields_in_login_ui(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
       //throw new io.cucumber.java.PendingException();
    }

}