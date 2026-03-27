package stepdefinition;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.PageObjectManager;
import utils.ElementUtil;

public class DashboardPageStepDefinition {
	private final PageObjectManager pom;
	private static final Logger logger = LoggerFactory.getLogger(DashboardPageStepDefinition.class);

	public DashboardPageStepDefinition(PageObjectManager pom) {
		this.pom = pom;
	}

	@Given("the user is on the dashboard page")
	public void the_user_is_on_the_dashboard_page() {
		logger.info("User is on" + ElementUtil.getURL() + "page");
	}

	@Then("User should see the exact four links in the navigation bar")
	public void user_should_see_the_exact_four_links_in_the_navigation_bar(io.cucumber.datatable.DataTable dataTable) {
		try {
			List<String> expectedLinks = dataTable.asList();
			List<String> actualLinks = pom.getDashboardPage().getNavigationLinkText();
			logger.info("Actual navigation links: " + actualLinks);
			Assert.assertEquals(actualLinks, expectedLinks, "Navigation links do not match expected values.");
		} catch (Exception e) {
			Assert.fail("Failed to validate no of links ", e);
		}
	}

	@Then("User should be able to click on {string}  and navigate to the respective {string}")
	public void user_should_be_able_to_click_on_and_navigate_to_the_respective(String link, String expectedPage) {
		try {
			pom.getDashboardPage().clicknavigationLink(link);
			Assert.assertTrue(ElementUtil.getURL().contains(expectedPage),
					"User is not navigated to the expected page after clicking " + link + " link.");
		} catch (Exception e) {
			Assert.fail("Failed to redirect to respective page", e);
		}
	}

	@Then("User should be able to click on home icon and navigate to the dashboard page")
	public void user_should_be_able_to_click_on_home_icon_and_navigate_to_the_dashboard_page() {
			pom.getDashboardPage().clickhomeIcon();
			Assert.assertEquals(ElementUtil.getURL().contains("dashboard"),
					"User is not navigated to the dashboard page after clicking home icon.");
		}
}