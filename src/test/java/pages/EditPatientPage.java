package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DriverManager.DriverFactory;

public class EditPatientPage {

	private static final Logger logger = LoggerFactory.getLogger(EditPatientPage.class);

	private WebDriver driver;

	// Locators

	@FindBy(xpath = "//tr")
	private List<WebElement> tableRows;

	@FindBy(xpath = "//th")
	private List<WebElement> tableHeaders;

	@FindBy(xpath = "//input[placeholder='Full name']")
	private WebElement firstnameField;

	@FindBy(xpath = "//input[@placeholder='Last name']")
	private WebElement lastnameField;

	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement emailField;

	@FindBy(xpath = "//input[@placeholder='ContactNumber']")
	private WebElement contactNumberField;

	@FindBy(xpath = "//input[contains@class,'edit']")
	private WebElement editIcon;

	@FindBy(xpath = "//h2[text()='Edit Patient Details']")
	private WebElement edialogTitle;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitButton;

	@FindBy(xpath = "//input[@type='close']")
	private WebElement closeButton;

	@FindBy(css = "a#myPatientLink")
	private WebElement myPatientHeader;

	@FindBy(xpath = "//h2[text()='Edit Patient]")
	WebElement dialogTitle;

	@FindBy(css = "div.dialog-container input[type='text']")
	private List<WebElement> inputFields;

	@FindBy(css = "div.dialog-container select")
	private List<WebElement> dropdowns;

	@FindBy(id = "weight")
	private WebElement weightField;
	@FindBy(id = "foodPreference")
	private WebElement foodPreferenceDropdown;
	@FindBy(id = "cuisineCategory")
	private WebElement cuisineCategoryDropdown;
	@FindBy(id = "allergies")
	private WebElement allergiesDropdown;

	List<WebElement> fileInputs = driver.findElements(By.xpath("//input[@type='file']"));

	// Constructor

	public EditPatientPage() {
		try {
			this.driver = DriverFactory.getDriver();
			PageFactory.initElements(this.driver, this);
			logger.info("EditPatientPage initialized successfully.");
		} catch (Exception e) {
			logger.error("Failed to initialize EditPatientPage", e);
			throw e;
		}
	}

	public void clearFirstNameField() {
		try {
			firstnameField.click();
			firstnameField.sendKeys(Keys.CONTROL + "a");
			firstnameField.sendKeys(Keys.DELETE);
			logger.info("First name cleared ");
		} catch (Exception e) {
			logger.error("Failed to clear First Name field", e);
			throw e;
		}

	}

	public void clearLastNameField() {
		try {
			lastnameField.click();
			lastnameField.sendKeys(Keys.CONTROL + "a");
			lastnameField.sendKeys(Keys.DELETE);
			logger.info("Last name cleared ");
		} catch (Exception e) {
			logger.error("Failed to clear Last Name field", e);
			throw e;
		}

	}

	public void ClickmyPatientHeader() {
		try {
			myPatientHeader.click();
			logger.info("My patient header clicked successfully");
		} catch (Exception e) {
			logger.error("Failed to click My Patient", e);
			throw e;
		}
	}

	public boolean isSubmitButtonDisplayed() {

		try {
			boolean isDisplayed = submitButton.isDisplayed();
			logger.info("Submit button is displayed:" + isDisplayed);
			return submitButton.isDisplayed();
		} catch (Exception e) {
			logger.error("Failed to see the submitbutton", e);
			return false;
		}
	}

	public boolean isSubmitButtonEnabled() {
		try {
			boolean isEnabled = submitButton.isEnabled();
			logger.info("Submit button enabled:" + isEnabled);
			return submitButton.isEnabled();
		} catch (Exception e) {
			logger.error("Failed to check the state");
			return false;
		}
	}

	public boolean iscloseButtonDisplayed() {
		try {
			boolean isDisplayed = closeButton.isDisplayed();
			logger.info("close button is displayed:" + isDisplayed);
			return closeButton.isDisplayed();
		} catch (Exception e) {
			logger.error("Failed to see the close button", e);
			return false;
		}
	}

	public boolean iscloseButtonEnabled() {
		try {
			boolean isEnabled = closeButton.isEnabled();
			logger.info("Submit button enabled:" + isEnabled);
			return closeButton.isEnabled();
		} catch (Exception e) {
			logger.error("Failed to check the state of the button");
			return false;
		}
	}

	public boolean isDialogDisplayed() {
		try {
			boolean isEnabled = dialogTitle.isDisplayed();
			logger.info("Dialog is displayed:" + isEnabled);
			return dialogTitle.isDisplayed();
		} catch (Exception e) {
			logger.error("Failed to check the state of Dialog");
			return false;
		}
	}

	public int getInputFieldCount() {
		try {
			int size = inputFields.size();
			logger.info("No. of input fields:" + size);
			return size;
		} catch (Exception e) {
			logger.error("Failed to check the state of Dialog");
			return 0;
		}

	}

	public int getDropdownCount() {
		try {
			int size = dropdowns.size();
			logger.info("No. of dropdowns:" + size);
			return size;
		} catch (Exception e) {
			logger.error("Failed to check the state of Dialog");
			return 0;
		}

	}

	public List<WebElement> getFileUploadFields() {
		try {

			List<WebElement> fileInputs = driver.findElements(By.xpath("//input[@type='file']"));
			logger.info("No. of file Inputs elements found:" + fileInputs.size());
			return fileInputs;
		} catch (Exception e) {
			logger.error("Failed to locate file input elements", e);
			return new ArrayList<>();
		}
	}

	public String getFirstNamePlaceholder() {
		try {
			String placeholder = firstnameField.getAttribute("placeholder");
			logger.info("FirstName Placeholder:" + placeholder);
			return placeholder;
		} catch (Exception e) {
			logger.error("Failed to get First Name placeholder", e);
			return null;

		}
	}

	public String getFirstNamefield() {
		try {
			String value = firstnameField.getAttribute("value");
			logger.info("First name field value:" + value);
			return value;
		} catch (Exception e) {
			logger.info("Failed to get First name field value:" + e);
			return null;
		}

	}

	public String getLastNamefield() {
		try {
			String value = lastnameField.getAttribute("value");
			logger.info("last name field value:" + value);
			return value;
		} catch (Exception e) {
			logger.info("Failed to get last name field value:" + e);
			return null;
		}
	}

	public String getWeightPlaceholder() {
		try {
			String placeholder = weightField.getAttribute("placeholder");
			logger.info("Weght Placeholder:" + placeholder);
			return placeholder;
		} catch (Exception e) {
			logger.error("Failed to get Weight Placeholder", e);
			return null;
		}

	}

	public String getLastNamePlaceholder() {
		try {
			String placeholder = lastnameField.getAttribute("placeholder");
			logger.info("LastName Placeholder:" + placeholder);
			return placeholder;
		} catch (Exception e) {
			logger.error("Failed to get LastName Placeholder", e);
			return null;
		}

	}

	public boolean iseDialogDisplayed() {
		try {
			boolean isEnabled = edialogTitle.isDisplayed();
			logger.info("Dialog is displayed:" + isEnabled);
			return edialogTitle.isDisplayed();
		} catch (Exception e) {
			logger.error("Failed to check the state of eDialog");
			return false;
		}
	}

	public String getFirstRowName() {
		try {
			List<String> DetailsrowText = new ArrayList<>();

			List<WebElement> rows = tableRows.subList(1, tableRows.size()); // Skip header row
			int columnIndex = tableHeaders.stream().map(WebElement::getText).map(String::trim).toList().indexOf("Name");

			for (int i = 0; i < rows.size(); i++) {

				WebElement detailsCell = rows.get(i).findElements(By.xpath("td")).get(columnIndex);

				String cellText = detailsCell.getText().trim();
				DetailsrowText.add(cellText);
			}
			return DetailsrowText.getFirst().split(" ")[0];
		} catch (Exception e) {
			logger.error("Failed to get the first row first name");
			return null;
		}
	}

	public String getFirstRowLastName() {
		List<String> detailsRowText = new ArrayList<>();
		try {

			List<WebElement> rows = tableRows.subList(1, tableRows.size());

			int columnIndex = tableHeaders.stream().map(WebElement::getText).map(String::trim).toList().indexOf("Name");

			for (WebElement row : rows) {
				WebElement detailsCell = row.findElements(By.tagName("td")).get(columnIndex);
				String cellText = detailsCell.getText().trim();
				detailsRowText.add(cellText);
			}

			if (!detailsRowText.isEmpty()) {
				String[] nameParts = detailsRowText.get(0).split(" ");
				if (nameParts.length > 1) {
					return nameParts[1]; // last name
				} else {
					logger.warn("Name in first row does not have a last name: " + detailsRowText.get(0));
					return "";
				}
			} else {
				logger.warn("No names found in the table rows");
				return null;
			}

		} catch (Exception e) {
			logger.error("Failed to get last name from the first row", e);
			return null;
		}
	}
}
