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

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@onclick='goToDashboard()']")
    private WebElement loginButton;

    @FindBy(xpath = ("//div[@role='alert']"))
    private WebElement error;

    @FindBy(xpath = "//label")
    private List<WebElement> labelList;

    // Constructor

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logger.info("LoginPage initialized successfully.");
    }

    public List<String> getLabeltext() {
        try {
            List<String> labels = labelList.stream()
                    .map(WebElement::getText)
                    .map(String::trim)
                    .toList();

            logger.info("Label texts retrieved: {}", labels);
            return labels;

        } catch (Throwable t) {
            throw new AssertionError("Unable to retrieve label text — " + t.getMessage(), t);
        }
    }


    public int getLabelCount() {
        try {
            return labelList.size();

        } catch (Throwable t) {
            throw new AssertionError("Unable to get label count" + t.getMessage(), t);
        }
    }

    public String getPageHeadingText() {
        try {
            String heading = pageHeading.getText().trim();
            logger.info("Page heading retrieved: {}", heading);
            return heading;

        } catch (Throwable t) {
            throw new AssertionError("Failed to retrieve page heading text"
                    + t.getMessage(), t);
        }
    }


    public boolean isHomeIconVisible() {
        try {
            boolean visible = homeIcon.isDisplayed();
            logger.info("Home icon visibility: {}", visible);
            return visible;

        } catch (Throwable t) {
            throw new AssertionError("Failed to verify Home icon visibility"
                    + t.getMessage(), t);
        }
    }


    public String getNavbarBackgroundColor() {
        try {
            String bgColor = navbar.getCssValue("background-color");
            logger.info("Navbar background color retrieved: {}", bgColor);
            return bgColor;
        } catch (Throwable t) {
            throw new AssertionError("Failed to retrieve navbar background color — "
                    + t.getMessage(), t);
        }
    }


    public boolean isFieldVisible(String fieldName) {
        try {
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

        } catch (Throwable t) {
            throw new AssertionError("Failed to verify visibility for field '" + t.getMessage(), t);
        }
    }



    public boolean isLebelsleftalignedaboveInputField() {
        try {
            boolean allAligned = true;
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
                logger.info("Label: {}, Above: {}, Left Aligned: {}",
                        labelText, isAbove, isLeftAligned);

                if (!isAbove || !isLeftAligned) {
                    allAligned = false;
                    break;
                }
            }
            return allAligned;
        } catch (Throwable t) {
            throw new AssertionError(
                    "Failed to verify label alignment above input fields  " + t.getMessage(), t);
        }
    }


    public boolean isLoginButtonEnabled() {
        try {
            boolean enabled = loginButton.isEnabled();
            logger.info("Login button enabled: {}", enabled);
            return enabled;

        } catch (Throwable t) {
            throw new AssertionError("Failed to verify Login button enabled state — "
                    + t.getMessage(), t);
        }
    }

    public boolean isLoginButtonVisible() {
        try {
            boolean visible = loginButton.isDisplayed();
            logger.info("Login button visibility: {}", visible);
            return visible;

        } catch (Throwable t) {
            throw new AssertionError(" Failed to verify Login button visibility — "
                    + t.getMessage(), t);
        }
    }

    public boolean isLoginButtonStyledCorrectly() {
        try {
            String bgColor = loginButton.getCssValue("background-color");
            String textColor = loginButton.getCssValue("color");

            logger.info("Login button background color: {}, text color: {}", bgColor, textColor);

            return "rgba(75, 0, 130, 1)".equals(bgColor)
                    && "rgba(255, 255, 255, 1)".equals(textColor);

        } catch (Throwable t) {
            throw new AssertionError("Failed to verify Login button styling — "
                    + t.getMessage(), t);
        }
    }


    public String getapploginHeadingText() {
        try {
            String heading = apploginHeading.getText().trim();
            logger.info("Login card heading retrieved: {}", heading);
            return heading;

        } catch (Throwable t) {
            throw new AssertionError("Failed to retrieve login card heading — "
                    + t.getMessage(), t);
        }
    }

    public void enterUsername(String username) {
        try {
            logger.info("Entering username.");
            WebElement field = WaitUtils.waitForVisibility(driver, usernameField, 10);
            field.clear();
            field.sendKeys(username);

        } catch (Throwable t) {
            throw new AssertionError("Failed to enter username — "
                    + t.getMessage(), t);
        }
    }

    public void enterPassword(String password) {
        try {
            logger.info("Entering password.");

            if (password != null && !password.isEmpty()) {
                passwordField.clear();
                passwordField.sendKeys(password);
            } else {
                logger.warn("Password provided is null or empty.");
            }

        } catch (Throwable t) {
            throw new AssertionError("Failed to enter password — "
                    + t.getMessage(), t);
        }
    }


    // Submission
    public void clickLoginButton() {
        try {
            logger.info("Clicking Login button.");
            JSUtils.clickElement(loginButton);

        } catch (AssertionError ae) {

            throw ae;

        } catch (Exception e) {

            throw new AssertionError("Failed to click Login button — " + e.getMessage(), e);
        }
    }


    public void pressEnterToSubmit() {
        try {
            logger.info("Submitting login using ENTER key.");
            passwordField.sendKeys(Keys.ENTER);

        } catch (Throwable t) {
            throw new AssertionError("Failed to submit login using ENTER key  "
                    + t.getMessage(), t);
        }
    }



    public String getErrorMessage() {
        try {
            if (error.isDisplayed()) {
                String errorMsg = error.getText().trim();
                logger.info("Error message retrieved: {}", errorMsg);
                return errorMsg;
            } else {
                logger.info("No error message displayed.");
                return "";
            }

        } catch (Throwable t) {
            throw new AssertionError("Failed to retrieve error message — "
                    + t.getMessage(), t);
        }
    }


    // Reusable login helper
    public void login(String method, String scenarioType) {
        try {
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
                    throw new AssertionError(" Unknown login submission method: " + method);
            }
        } catch (AssertionError ae) {

            throw ae;
        } catch (Exception e) {
            throw new AssertionError("Failed during login flow — " + e.getMessage(), e);
        }
    }




}
