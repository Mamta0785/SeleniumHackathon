package pages;

import DriverManager.DriverFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ExcelReader;
import utils.JSUtils;
import utils.TestContext;
import utils.WaitUtils;

import java.util.List;

public class LoginPage {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

	private WebDriver driver;

	// Locators
   
	@FindBy(xpath = "//div[@class='navbar']")
	private WebElement navbar;
	
    @FindBy(xpath = "//*[text()='Dietician Project']")//*
    private WebElement pageHeading;
    
    @FindBy(xpath = "//img[@alt='Home']")//*
    private WebElement homeIcon;
    
    @FindBy(xpath = "//*[(text()='Dietician Application']")
    private WebElement apploginHeading;

	@FindBy(id = "id_username")
	private WebElement usernameField;
	
	@FindBy(id = "id_password")
	private WebElement passwordField;

	@FindBy(xpath = "//button[@onclick='login()']")
	private WebElement loginButton;

	@FindBy(xpath = ("//div[@role='alert']"))
	private WebElement error;

	@FindBy(xpath = "//label")
	private List<WebElement> labelList;

	// Constructor

    public LoginPage(WebDriver driver) {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(this.driver, this);
        logger.info("LoginPage initialized successfully.");
    }

	public List<String> getLabeltext() {
		List<String> labels = labelList.stream()
				.map(WebElement::getText)
				.map(String::trim)
				.toList();
		logger.info("Label texts retrieved: {}", labels);
		return labels;
		}
	
	public int getLabelCount() {
	    return labelList.size();
	}
	
	public String getPageHeadingText() {
		String heading = pageHeading.getText().trim();
		logger.info("Page heading retrieved: {}", heading);
		return heading;
	}
	
	public boolean isHomeIconVisible() {
		boolean visible = homeIcon.isDisplayed();
		logger.info("Home icon visibility: {}", visible);
		return visible;
	}
	
	public String getNavbarBackgroundColor() {
		String bgColor = navbar.getCssValue("background-color");
		logger.info("Navbar background color retrieved: {}", bgColor);
		return bgColor;
	}
	
	public boolean isApploginHeadingVisible() {
		boolean visible = apploginHeading.isDisplayed();
		logger.info("Login card heading visibility: {}", visible);
		return visible;
	}
	
	public boolean isFieldVisible(String fieldName) {
		WebElement field = null;
		switch (fieldName.toLowerCase().trim()) {
			case "username field":
				field = usernameField;
				break;

			case "password field":
				field = passwordField;
				break;

			default:
				logger.warn("Unknown field name: {}", fieldName);
				return false;
		}
		boolean visible = field.isDisplayed();
		logger.info("{} visibility: {}", fieldName, visible);
		return visible;
		}

	
	public boolean isLebelsleftalignedaboveInputField() {
		boolean allAligned = false; 
		for (WebElement label : labelList) {
			String labelText = label.getText().trim();
			WebElement field = null;
			if (labelText.equalsIgnoreCase("Username")) {
				field = usernameField;
			} else if (labelText.equalsIgnoreCase("Password")) {
				field = passwordField;
			} else {
				logger.warn("Unknown label text: {}", labelText);
				continue;
			}
			int labelX = label.getLocation().getX();
			int fieldX = field.getLocation().getX();
			int fieldY = field.getLocation().getY();
			int labelY = label.getLocation().getY();
			boolean isAbove = labelY < fieldY;
			boolean isLeftAligned = Math.abs(labelX - fieldX) < 5;
			logger.info("Label: {}, Above: {}, Left Aligned: {}", labelText, isAbove, isLeftAligned);
			if (!isAbove || !isLeftAligned) {
				allAligned = false;
				break;
			}
		}
		return allAligned;
	}

	public boolean isLoginButtonEnabled() {
		boolean enabled = loginButton.isEnabled();
		logger.info("Login button enabled: {}", enabled);
		return enabled;
	}
	
	public boolean isLoginButtonVisible() {
		boolean visible = loginButton.isDisplayed();
		logger.info("Login button visibility: {}", visible);
		return visible;
	}
	
	public boolean isLoginButtonStyledCorrectly() {
		String bgColor = loginButton.getCssValue("background-color");
		String textColor = loginButton.getCssValue("color");
		logger.info("Login button background color: {}, text color: {}", bgColor, textColor);
		return "rgba(75, 0, 130, 1)".equals(bgColor) && "rgba(255, 255, 255, 1)".equals(textColor);
	}
	
	public String getapploginHeadingText() {
		String heading = apploginHeading.getText().trim();
		logger.info("Login card heading retrieved: {}", heading);
		return heading;
	}
	
	public void enterUsername(String username) {
		logger.info("Entering username.");
		WebElement field = WaitUtils.waitForVisibility(driver, usernameField, 10);
		field.clear();
		field.sendKeys(username);
	}

	public void enterPassword(String password) {
		logger.info("Entering password.");
		if (password != null && !password.isEmpty()) {
			passwordField.clear();
			passwordField.sendKeys(password);
		} else {
			logger.warn("Password provided is null or empty.");
		}
	}

	// Submission
	public void clickLoginButton() {
		logger.info("Clicking Login button.");
		JSUtils.clickElement(loginButton);
	}

	public void pressEnterToSubmit() {
		logger.info("Submitting login using ENTER key.");
		passwordField.sendKeys(Keys.ENTER);
	}

	// Helpers

	public boolean isLoginPageVisible() {
		boolean visible = usernameField.isDisplayed() && passwordField.isDisplayed();
		logger.info("Login page fields visible: {}", visible);
		return visible;
	}

public String getErrorMessage() {
		if (error.isDisplayed()) {
			String errorMsg = error.getText().trim();
			logger.info("Error message retrieved: {}", errorMsg);
			return errorMsg;
		} else {
			logger.info("No error message displayed.");
			return "";
		}
	}

	// Reusable login helper
	public void login(String method, String scenarioType) {

		logger.info("Executing login with method: {} and scenario: {}", method, scenarioType);

		TestContext.testData = ExcelReader.getTestData(scenarioType);

		enterUsername(TestContext.testData.get("username"));
		enterPassword(TestContext.testData.get("password"));

		switch (method.toLowerCase().trim()) {
			case "submits the login form":
			case "initiates login":
			case "submits the login form with mouse click":
				clickLoginButton();
				break;

			case "presses enter":
			case "confirms login using enter":
				pressEnterToSubmit();
				break;

			default:
				logger.error("Unknown submission method: {}", method);
				throw new IllegalArgumentException("Unknown submission method: " + method);
		}
	}

	public void waitForHomeRedirect() {
		logger.info("Waiting for redirect to Home page.");
		WaitUtils.waitForUrlContains(driver, "/home", 10);
	}

	public int getInputFieldCount() {
		int count = labelList.size();
		logger.info("Total input fields (labels) found: {}", count);
		return count;
	}

	
	public List<String> getLoginLabelNames() {
		logger.info("Fetching login page label names.");

		return labelList.stream()
				.map(WebElement::getText)
				.map(String::trim)
				.toList();
	}


}
