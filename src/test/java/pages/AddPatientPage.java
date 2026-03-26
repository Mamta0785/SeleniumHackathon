package pages;

import DriverManager.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class AddPatientPage {

    private WebDriver driver;

    @FindBy(css = "a#newPatientLink")
    private WebElement newPatientHeader;

    @FindBy(xpath = "//h2[text()='Add Patient Details']")
    private WebElement dialogTitle;

    @FindBy(css = "div.dialog-container input[type='text']")
    private List<WebElement> inputFields;

    @FindBy(css = "div.dialog-container select")
    private List<WebElement> dropdowns;

    @FindBy(id = "dob")
    private WebElement dobField;

    @FindBy(css = "div.dialog-container input[type='file']")
    private List<WebElement> fileUploadInputs;

    @FindBy(css = "#submitBtn")
    private List<WebElement> submitButtons;

    @FindBy(css = "#submitBtn")
    private WebElement submitButton;

    @FindBy(css = "#closeBtn")
    private List<WebElement> closeButtons;

    @FindBy(css = "#closeBtn")
    private WebElement closeButton;

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(xpath = "//p[contains(text(),'First name is required')]")
    private WebElement firstNameErrorMessage;
    @FindBy(id = "lastName")
    private WebElement lastNameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "contactNumber")
    private WebElement contactNumberField;

    @FindBy(id = "allergies")
    private WebElement allergiesDropdown;

    @FindBy(id = "height")
    private WebElement heightField;


    @FindBy(id = "foodPreference")
    private WebElement foodPreferenceDropdown;
    @FindBy(id = "cuisineCategory")
    private WebElement cuisineCategoryDropdown;
    @FindBy(id = "weight")
    private WebElement weightField;

    @FindBy(id = "temperature")
    private WebElement temperatureField;

    @FindBy(id = "sp")
    private WebElement spField;

    @FindBy(id = "dp")
    private WebElement dpField;
    @FindBy(xpath = "//label[text()='Upload Health Report']")
    private WebElement uploadHealthReportText;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement healthReportInput;

    @FindBy(xpath = "//label[contains(text(),'No file Chosen')]")
    private WebElement noFileChosenText;

    @FindBy(css = ".dialog-container")
    private WebElement dialogContainer;

    @FindBy(css = ".dialog-scroll")
    private WebElement dialogScroll;

    @FindBy(id = "allergies")
    private WebElement allergies;

    @FindBy(id = "foodPreference")
    private WebElement foodPreference;

    @FindBy(id = "cuisineCategory")
    private WebElement cuisine;

    @FindBy(id = "patientName")
    private WebElement patientName;

    @FindBy(id = "age")
    private WebElement age;

    @FindBy(id = "gender")
    private WebElement gender;

    @FindBy(id = "allergy")
    private WebElement allergy;

    @FindBy(css = ".toast-message")
    private WebElement toastMessage;


    @FindBy(css = "#patientsTable tbody tr")
    private List<WebElement> patientRows;

    @FindBy(xpath = "//a[text()='My Patients']")
    private WebElement myPatientsLink;


    public AddPatientPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(this.driver, this);
    }

    public void clickNewPatientHeader() {
        newPatientHeader.click();
    }

    public boolean isDialogDisplayed() {
        try {
            return dialogTitle.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getDialogTitle() {
        return dialogTitle.getText().trim();
    }

    public int getInputFieldCount() {
        return inputFields.size();
    }

    public int getDropdownCount() {
        return dropdowns.size();
    }

    public boolean isDobDatePicker() {

        return dobField.getAttribute("type").equals("date");
    }

    public String getDobPlaceholder() {

        return dobField.getAttribute("placeholder");
    }

    public int getFileUploadCount() {
        return fileUploadInputs.size();
    }

    public int getSubmitButtonCount() {
        return submitButtons.size();
    }

    public boolean isSubmitButtonDisabled() {
        String disabled = submitButton.getAttribute("disabled");
        return disabled != null;
    }

    public int getCloseButtonCount() {
        return closeButtons.size();
    }

    public boolean isCloseButtonEnabled() {
        return closeButton.isEnabled();
    }

    public void clickFirstNameAndBlur() {
        firstNameField.click();
        firstNameField.sendKeys("");
        firstNameField.sendKeys(Keys.TAB);
    }

    public boolean isFirstNameErrorDisplayed() {
        try {
            return firstNameErrorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getLastNamePlaceholder() {
        return lastNameField.getAttribute("placeholder");
    }

    public boolean isLastNameMandatory() {
        return lastNameField.getAttribute("required") != null;
    }

    public String getEmailPlaceholder() {
        return emailField.getAttribute("placeholder");
    }

    public boolean isEmailMandatory() {
        return emailField.getAttribute("required") != null;
    }

    public String getContactNumberPlaceholder() {
        return contactNumberField.getAttribute("placeholder");
    }

    public boolean isContactNumberMandatory() {
        return contactNumberField.getAttribute("required") != null;
    }

    public String getAllergiesPlaceholder() {
        return allergiesDropdown.getAttribute("value");
    }

    public boolean isAllergiesMandatory() {
        return allergiesDropdown.getAttribute("required") != null;
    }

    public String getAllergiesSelectedText() {
        Select select = new Select(allergiesDropdown);
        return select.getFirstSelectedOption().getText();
    }

    public String getFoodPreferencePlaceholder() {
        Select select = new Select(foodPreferenceDropdown);
        return select.getFirstSelectedOption().getText();
    }

    public boolean isFoodPreferenceMandatory() {
        return foodPreferenceDropdown.getAttribute("required") != null;
    }

    public String getCuisineCategoryPlaceholder() {
        Select select = new Select(cuisineCategoryDropdown);
        return select.getFirstSelectedOption().getText();
    }

    public boolean isCuisineCategoryMandatory() {
        return cuisineCategoryDropdown.getAttribute("required") != null;
    }

    public boolean isDobMandatory() {
        return dobField.getAttribute("required") != null;
    }

    public String getWeightPlaceholder() {
        return weightField.getAttribute("placeholder");
    }

    public boolean isWeightMandatory() {
        return weightField.getAttribute("required") != null;
    }

    public String getHeightPlaceholder() {
        return heightField.getAttribute("placeholder");
    }

    public boolean isHeightMandatory() {
        return heightField.getAttribute("required") != null;
    }

    public String getTemperaturePlaceholder() {
        return temperatureField.getAttribute("placeholder");
    }

    public boolean isTemperatureMandatory() {
        return temperatureField.getAttribute("required") != null;
    }

    public String getSpPlaceholder() {
        return spField.getAttribute("placeholder");
    }

    public boolean isSpMandatory() {
        return spField.getAttribute("required") != null;
    }

    public String getDpPlaceholder() {
        return dpField.getAttribute("placeholder");
    }

    public boolean isDpMandatory() {
        return dpField.getAttribute("required") != null;
    }

    public boolean isUploadHealthReportVisible() {
        try {
            return uploadHealthReportText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isNoFileChosenVisible() {
        try {
            return noFileChosenText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDialogScrollable() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        long scrollHeight = (long) js.executeScript(
                "return arguments[0].scrollHeight;", dialogScroll);

        long clientHeight = (long) js.executeScript(
                "return arguments[0].clientHeight;", dialogScroll);

        return scrollHeight > clientHeight;
    }

    public void clickAllergyDropdown() {
        allergies.click();
    }

    public List<String> getAllergyDropdownValues() {
        Select select = new Select(allergiesDropdown);
        return select.getOptions()
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public void clickFoodPreferenceDropdown() {
        foodPreference.click();
    }

    public List<String> getFoodPreferenceDropdownValues() {
        Select select = new Select(foodPreferenceDropdown);
        return select.getOptions()
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public void clickCuisineDropdown() {
        cuisine.click();
    }

    public List<String> getCuisineDropdownValues() {
        Select select = new Select(cuisine);
        return select.getOptions()
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public void fillRequiredFieldsFromExcel(List<Map<String, String>> excelData) {

        for (Map<String, String> row : excelData) {

            String field = row.get("Field");
            String value = row.get("Value");

            switch (field) {

                case "firstName":
                    firstNameField.sendKeys(value);
                    break;

                case "lastName":
                    lastNameField.sendKeys(value);
                    break;

                case "email":
                    emailField.sendKeys(value);
                    break;

                case "contactNumber":
                    contactNumberField.sendKeys(value);
                    break;

                case "allergies":
                    new Select(allergiesDropdown).selectByVisibleText(value);
                    break;

                case "foodPreference":
                    new Select(foodPreferenceDropdown).selectByVisibleText(value);
                    break;

                case "cuisineCategory":
                    new Select(cuisineCategoryDropdown).selectByVisibleText(value);
                    break;

                case "dob":
                    enterDateOfBirth(value);
                    break;

                default:
                    System.out.println("Unknown field in Excel: " + field);
            }
        }
    }

    public boolean isSubmitButtonEnabled() {
        return submitButton.isEnabled();
    }

    public String getToastMessageText() {
        try {
            return toastMessage.getText().trim();
        } catch (Exception e) {
            return null;
        }
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void enterDateOfBirth(String date) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1];", dobField, date);
    }

    public boolean isPatientPresent(String firstName, String lastName) {
        String first = firstName.toLowerCase();
        String last = lastName.toLowerCase();

        for (WebElement row : patientRows) {
            String rowText = row.getText().toLowerCase();
            if (rowText.contains(first) && rowText.contains(last)) {
                return true;
            }
        }
        return false;
    }

    public void goToMyPatients() {
        myPatientsLink.click();
    }

    public void selectAllergy(String allergy) {
        Select select = new Select(allergiesDropdown);
        select.selectByVisibleText(allergy);
    }

    public String getSelectedAllergy() {
        Select select = new Select(allergiesDropdown);
        return select.getFirstSelectedOption().getText();
    }

    public boolean trySelectAllergy(String allergy) {
        Select select = new Select(allergiesDropdown);
        try {
            select.selectByVisibleText(allergy);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void selectFoodPreference(String preference) {
        Select select = new Select(foodPreferenceDropdown);
        select.selectByVisibleText(preference);
    }

    public String getSelectedFoodPreference() {
        Select select = new Select(foodPreferenceDropdown);
        return select.getFirstSelectedOption().getText();
    }

    public boolean trySelectFoodPreference(String preference) {
        Select select = new Select(foodPreferenceDropdown);
        try {
            select.selectByVisibleText(preference);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public void selectCuisineCategory(String category) {
        Select select = new Select(cuisineCategoryDropdown);
        select.selectByVisibleText(category);
    }

    public boolean trySelectCuisineCategory(String category) {
        Select select = new Select(cuisineCategoryDropdown);
        try {
            select.selectByVisibleText(category);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}

