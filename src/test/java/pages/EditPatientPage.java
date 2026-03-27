package pages;

import DriverManager.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

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

    // private By foodPreference = By.xpath("//div[contains(text(),'Food Preference')]/following::input[1]");
    // private By cuisineCategory = By.xpath("//div[contains(text(),'Cuisine Category')]/following::input[1]");
    //private By dob = By.xpath("//input[@type='date']");

    // private By errorMsg = By.xpath("//span[contains(@class,'error')]"); confirm this xpath

    List<WebElement> fileInputs = driver.findElements(By.xpath("//input[@type='file']"));

    // Constructor

    public EditPatientPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(this.driver, this);
        logger.info("EditPatientPage initialized successfully.");
    }

    public void clearFirstNameField() {
        firstnameField.click();
        firstnameField.sendKeys(Keys.CONTROL + "a");
        firstnameField.sendKeys(Keys.CONTROL + "a");
        firstnameField.sendKeys(Keys.DELETE);
    }


    public void ClickmyPatientHeader() {
        myPatientHeader.click();
    }


    public boolean isSubmitButtonDisplayed() {
        try {
            return submitButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSubmitButtonEnabled() {
        try {
            return submitButton.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean iscloseButtonDisplayed() {
        try {
            return closeButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean iscloseButtonEnabled() {
        try {
            return closeButton.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDialogDisplayed() {
        try {
            return dialogTitle.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public int getInputFieldCount() {
        return inputFields.size();
    }

    public int getDropdownCount() {
        return dropdowns.size();
    }


    public List<WebElement> getFileUploadFields() {
        return driver.findElements(By.xpath("//input[@type='file']"));
    }


    public String getFirstNamePlaceholder() {
        return firstnameField.getAttribute("placeholder");
    }

    public String getFirstNamefield() {
        return firstnameField.getAttribute("value");
    }

    public String getLastNamefield() {
        return lastnameField.getAttribute("value");
    }

    public String getWeightPlaceholder() {
        return weightField.getAttribute("placeholder");


    }

    public String getLastNamePlaceholder() {
        return lastnameField.getAttribute("placeholder");


    }

    public boolean iseDialogDisplayed() {
        try {
            return edialogTitle.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getFirstRowName() {
        List<String> DetailsrowText = new ArrayList<>();

        List<WebElement> rows = tableRows.subList(1, tableRows.size()); // Skip header row
        int columnIndex = tableHeaders.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .toList()
                .indexOf("Name");

        for (int i = 0; i < rows.size(); i++) {

            WebElement detailsCell = rows.get(i)
                    .findElements(By.xpath("td"))
                    .get(columnIndex);

            String cellText = detailsCell.getText().trim();
            DetailsrowText.add(cellText);
        }
        return DetailsrowText.getFirst().split(" ")[0];
    }

    public String getFirstRowLastName() {
        List<String> DetailsrowText = new ArrayList<>();

        List<WebElement> rows = tableRows.subList(1, tableRows.size()); // Skip header row
        int columnIndex = tableHeaders.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .toList()
                .indexOf("Name");

        for (int i = 0; i < rows.size(); i++) {

            WebElement detailsCell = rows.get(i)
                    .findElements(By.xpath("td"))
                    .get(columnIndex);

            String cellText = detailsCell.getText().trim();
            DetailsrowText.add(cellText);
        }
        return DetailsrowText.getFirst().split(" ")[1];
    }


}



