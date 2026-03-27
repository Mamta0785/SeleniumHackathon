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

    @FindBy(xpath = "//a[text()='New Patient']")
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

    @FindBy(css = ".flatpickr-calendar")
    private WebElement dobCalendar;

    @FindBy(css = ".flatpickr-monthDropdown-months")
    private WebElement monthDropdown;
    @FindBy(css = ".flatpickr-monthDropdown-months .flatpickr-monthDropdown-month")
    private List<WebElement> monthOptions;

    @FindBy(css = ".numInput.cur-year")
    private WebElement yearInput;

    @FindBy(css = ".flatpickr-day")
    private List<WebElement> dayCells;

    public AddPatientPage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(this.driver, this);
    }

    public boolean isDialogDisplayed() {
        try {
            return dialogTitle.isDisplayed();
        } catch (Exception e) {
            throw new AssertionError("Failed to verify if 'Add Patient Details' dialog is displayed: " + e.getMessage(), e);
        }
    }


    public String getDialogTitle() {
        try {
            return dialogTitle.getText().trim();
        } catch (Exception e) {
            throw new AssertionError("Failed to retrieve dialog title: " + e.getMessage(), e);
        }
    }


    public int getInputFieldCount() {
        try {
            return inputFields.size();
        } catch (Exception e) {
            throw new AssertionError("Failed to retrieve input field count: " + e.getMessage(), e);
        }
    }


    public int getDropdownCount() {
        try {
            return dropdowns.size();
        } catch (Exception e) {
            throw new AssertionError("Failed to retrieve dropdown count: " + e.getMessage(), e);
        }
    }


    public boolean isDobDatePicker() {
        try {
            return "date".equalsIgnoreCase(dobField.getAttribute("type"));
        } catch (Exception e) {
            throw new AssertionError("Failed to verify if DOB field is a date picker: " + e.getMessage(), e);
        }
    }


    public String getDobPlaceholder() {
        try {
            return dobField.getAttribute("placeholder");
        } catch (Exception e) {
            throw new AssertionError("Failed to retrieve DOB placeholder: " + e.getMessage(), e);
        }
    }


    public int getFileUploadCount() {
        try {
            return fileUploadInputs.size();
        } catch (Exception e) {
            throw new AssertionError("Failed to retrieve file upload input count: " + e.getMessage(), e);
        }
    }


    public int getSubmitButtonCount() {
        try {
            return submitButtons.size();
        } catch (Exception e) {
            throw new AssertionError("Failed to retrieve submit button count: " + e.getMessage(), e);
        }
    }


    public boolean isSubmitButtonDisabled() {
        try {
            String disabled = submitButton.getAttribute("disabled");
            return disabled != null;
        } catch (Exception e) {
            throw new AssertionError("Failed to verify if Submit button is disabled: " + e.getMessage(), e);
        }
    }


    public int getCloseButtonCount() {
        try {
            return closeButtons.size();
        } catch (Exception e) {
            throw new AssertionError("Failed to retrieve close button count: " + e.getMessage(), e);
        }
    }


    public boolean isCloseButtonEnabled() {
        try {
            return closeButton.isEnabled();
        } catch (Exception e) {
            throw new AssertionError("Failed to verify if Close button is enabled: " + e.getMessage(), e);
        }
    }


    public void clickFirstNameAndBlur() {
        try {
            firstNameField.click();
            firstNameField.sendKeys("");
            firstNameField.sendKeys(Keys.TAB);
        } catch (Exception e) {
            throw new AssertionError("Failed to click and blur the First Name field: " + e.getMessage(), e);
        }
    }


    public boolean isFirstNameErrorDisplayed() {
        try {
            return firstNameErrorMessage.isDisplayed();
        } catch (Exception e) {
            throw new AssertionError("Failed to verify if First Name error message is displayed: "
                    + e.getMessage(), e);
        }
    }


    public String getLastNamePlaceholder() {
        try {
            return lastNameField.getAttribute("placeholder");
        } catch (Exception e) {
            throw new AssertionError("Failed to retrieve Last Name placeholder: " + e.getMessage(), e);
        }
    }


    public boolean isLastNameMandatory() {
        try {
            return lastNameField.getAttribute("required") != null;
        } catch (Exception e) {
            throw new AssertionError("Failed to verify if Last Name field is mandatory: " + e.getMessage(), e);
        }
    }


    public String getEmailPlaceholder() {
        try {
            return emailField.getAttribute("placeholder");
        } catch (Exception e) {
            throw new AssertionError("Failed to retrieve Email placeholder: " + e.getMessage(), e);
        }
    }


    public boolean isEmailMandatory() {
        try {
            return emailField.getAttribute("required") != null;
        } catch (Exception e) {
            throw new AssertionError("Failed to verify if Email field is mandatory: " + e.getMessage(), e);
        }
    }


    public String getContactNumberPlaceholder() {
        try {
            return contactNumberField.getAttribute("placeholder");
        } catch (Exception e) {
            throw new AssertionError("Failed to retrieve Contact Number placeholder: " + e.getMessage(), e);
        }
    }


    public boolean isContactNumberMandatory() {
        try {
            return contactNumberField.getAttribute("required") != null;
        } catch (Exception e) {
            throw new AssertionError("Failed to verify if Contact Number field is mandatory: " + e.getMessage(), e);
        }
    }


    public boolean isAllergiesMandatory() {
        try {
            return allergiesDropdown.getAttribute("required") != null;
        } catch (Exception e) {
            throw new AssertionError("Failed to verify if Allergies dropdown is mandatory: "
                    + e.getMessage(), e);
        }
    }


    public String getAllergiesSelectedText() {
        try {
            Select select = new Select(allergiesDropdown);
            return select.getFirstSelectedOption().getText();
        } catch (Exception e) {
            throw new AssertionError("Failed to retrieve selected Allergies text: "
                    + e.getMessage(), e);
        }
    }


    public String getFoodPreferencePlaceholder() {
        try {
            Select select = new Select(foodPreferenceDropdown);
            return select.getFirstSelectedOption().getText();
        } catch (Exception e) {
            throw new AssertionError("Failed to retrieve Food Preference placeholder: "
                    + e.getMessage(), e);
        }
    }


    public boolean isFoodPreferenceMandatory() {
        try {
            return foodPreferenceDropdown.getAttribute("required") != null;
        } catch (Exception e) {
            throw new AssertionError("Failed to verify if Food Preference dropdown is mandatory: "
                    + e.getMessage(), e);
        }
    }

    public String getCuisineCategoryPlaceholder() {
        try {
            Select select = new Select(cuisineCategoryDropdown);
            return select.getFirstSelectedOption().getText();
        } catch (Exception e) {
            throw new AssertionError("Failed to retrieve Cuisine Category placeholder: "
                    + e.getMessage(), e);
        }
    }


    public boolean isCuisineCategoryMandatory() {
        try {
            return cuisineCategoryDropdown.getAttribute("required") != null;
        } catch (Exception e) {
            throw new AssertionError("Failed to verify if Cuisine Category is mandatory: "
                    + e.getMessage(), e);
        }
    }

    public boolean isDobMandatory() {
        try {
            return dobField.getAttribute("required") != null;
        } catch (Exception e) {
            throw new AssertionError("Failed to verify if DOB field is mandatory: "
                    + e.getMessage(), e);
        }
    }

    public String getWeightPlaceholder() {
        try {
            return weightField.getAttribute("placeholder");
        } catch (Exception e) {
            throw new AssertionError("Failed to retrieve Weight placeholder: "
                    + e.getMessage(), e);
        }
    }

    public boolean isWeightMandatory() {
        try {
            return weightField.getAttribute("required") != null;
        } catch (Exception e) {
            throw new AssertionError("Failed to verify if Weight field is mandatory: "
                    + e.getMessage(), e);
        }
    }

    public String getHeightPlaceholder() {
        try {
            return heightField.getAttribute("placeholder");
        } catch (Exception e) {
            throw new AssertionError("Failed to retrieve Height placeholder: "
                    + e.getMessage(), e);
        }
    }

    public boolean isHeightMandatory() {
        try {
            return heightField.getAttribute("required") != null;
        } catch (Exception e) {
            throw new AssertionError("Failed to verify if Height field is mandatory: "
                    + e.getMessage(), e);
        }
    }

    public String getTemperaturePlaceholder() {
        try {
            return temperatureField.getAttribute("placeholder");
        } catch (Exception e) {
            throw new AssertionError("Failed to retrieve Temperature placeholder: "
                    + e.getMessage(), e);
        }
    }

    public boolean isTemperatureMandatory() {
        try {
            return temperatureField.getAttribute("required") != null;
        } catch (Exception e) {
            throw new AssertionError("Failed to verify if Temperature field is mandatory: "
                    + e.getMessage(), e);
        }
    }

    public String getSpPlaceholder() {
        try {
            return spField.getAttribute("placeholder");
        } catch (Exception e) {
            throw new AssertionError("Failed to retrieve SP placeholder: "
                    + e.getMessage(), e);
        }
    }

    public boolean isSpMandatory() {
        try {
            return spField.getAttribute("required") != null;
        } catch (Exception e) {
            throw new AssertionError("Failed to verify if SP field is mandatory: "
                    + e.getMessage(), e);
        }
    }

    public String getDpPlaceholder() {
        try {
            return dpField.getAttribute("placeholder");
        } catch (Exception e) {
            throw new AssertionError("Failed to retrieve DP placeholder: "
                    + e.getMessage(), e);
        }
    }

    public boolean isDpMandatory() {
        try {
            return dpField.getAttribute("required") != null;
        } catch (Exception e) {
            throw new AssertionError("Failed to verify if DP field is mandatory: "
                    + e.getMessage(), e);
        }
    }

    public boolean isUploadHealthReportVisible() {
        try {
            return uploadHealthReportText.isDisplayed();
        } catch (Exception e) {
            throw new AssertionError("Failed to verify visibility of 'Upload Health Report' text: "
                    + e.getMessage(), e);
        }
    }

    public boolean isNoFileChosenVisible() {
        try {
            return noFileChosenText.isDisplayed();
        } catch (Exception e) {
            throw new AssertionError("Failed to verify visibility of 'No file chosen' text: "
                    + e.getMessage(), e);
        }
    }

    public boolean isDialogScrollable() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Object scrollHeightObj = js.executeScript(
                    "return arguments[0].scrollHeight;", dialogScroll);
            Object clientHeightObj = js.executeScript(
                    "return arguments[0].clientHeight;", dialogScroll);
            if (scrollHeightObj == null || clientHeightObj == null) {
                throw new AssertionError("JavaScript returned null for scrollHeight or clientHeight.");
            }

            long scrollHeight = ((Number) scrollHeightObj).longValue();
            long clientHeight = ((Number) clientHeightObj).longValue();

            return scrollHeight > clientHeight;

        } catch (Exception e) {
            throw new AssertionError("Failed to determine if dialog is scrollable: "
                    + e.getMessage(), e);
        }
    }


    public void clickAllergyDropdown() {
        try {
            allergies.click();
        } catch (Exception e) {
            throw new AssertionError("Failed to click the Allergy dropdown: "
                    + e.getMessage(), e);
        }
    }

    public List<String> getAllergyDropdownValues() {
        try {
            Select select = new Select(allergiesDropdown);
            return select.getOptions()
                    .stream()
                    .map(WebElement::getText)
                    .toList();
        } catch (Exception e) {
            throw new AssertionError("Failed to retrieve Allergy dropdown values: "
                    + e.getMessage(), e);
        }
    }

    public void clickFoodPreferenceDropdown() {
        try {
            foodPreference.click();
        } catch (Exception e) {
            throw new AssertionError("Failed to click the Food Preference dropdown: "
                    + e.getMessage(), e);
        }
    }


    public List<String> getFoodPreferenceDropdownValues() {
        try {
            Select select = new Select(foodPreferenceDropdown);
            return select.getOptions()
                    .stream()
                    .map(WebElement::getText)
                    .toList();
        } catch (Exception e) {
            throw new AssertionError("Failed to retrieve Food Preference dropdown values: "
                    + e.getMessage(), e);
        }
    }

    public void clickCuisineDropdown() {
        try {
            cuisine.click();
        } catch (Exception e) {
            throw new AssertionError("Failed to click the Cuisine dropdown: "
                    + e.getMessage(), e);
        }
    }

    public List<String> getCuisineDropdownValues() {
        try {
            Select select = new Select(cuisine);
            return select.getOptions()
                    .stream()
                    .map(WebElement::getText)
                    .toList();
        } catch (Exception e) {
            throw new AssertionError("Failed to retrieve Cuisine dropdown values: "
                    + e.getMessage(), e);
        }
    }


    public void fillRequiredFieldsFromExcel(List<Map<String, String>> excelData) {
        try {
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
                        throw new AssertionError("Unknown field in Excel: " + field);
                }
            }
        } catch (Exception e) {
            throw new AssertionError("Failed to fill required fields from Excel: "
                    + e.getMessage(), e);
        }
    }


    public boolean isSubmitButtonEnabled() {
        try {
            return submitButton.isEnabled();
        } catch (Exception e) {
            throw new AssertionError("Failed to verify if Submit button is enabled: "
                    + e.getMessage(), e);
        }
    }

    public String getToastMessageText() {
        try {
            return toastMessage.getText().trim();
        } catch (Exception e) {
            throw new AssertionError("Failed to retrieve toast message text: "
                    + e.getMessage(), e);
        }
    }


    public void clickSubmitButton() {
        try {
            submitButton.click();
        } catch (Exception e) {
            throw new AssertionError("Failed to click the Submit button: "
                    + e.getMessage(), e);
        }
    }

    public void enterDateOfBirth(String date) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value = arguments[1];", dobField, date);
        } catch (Exception e) {
            throw new AssertionError("Failed to enter Date of Birth: "
                    + e.getMessage(), e);
        }
    }

    public boolean isPatientPresent(String firstName, String lastName) {
        try {
            String first = firstName.toLowerCase();
            String last = lastName.toLowerCase();

            for (WebElement row : patientRows) {
                String rowText = row.getText().toLowerCase();
                if (rowText.contains(first) && rowText.contains(last)) {
                    return true;
                }
            }
            return false;

        } catch (Exception e) {
            throw new AssertionError("Failed to verify if patient is present: "
                    + e.getMessage(), e);
        }
    }

    public void goToMyPatients() {
        try {
            myPatientsLink.click();
        } catch (Exception e) {
            throw new AssertionError("Failed to navigate to My Patients: "
                    + e.getMessage(), e);
        }
    }

    public void selectAllergy(String allergy) {
        try {
            Select select = new Select(allergiesDropdown);
            select.selectByVisibleText(allergy);
        } catch (Exception e) {
            throw new AssertionError("Failed to select allergy: " + allergy + " — "
                    + e.getMessage(), e);
        }
    }

    public String getSelectedAllergy() {
        try {
            Select select = new Select(allergiesDropdown);
            return select.getFirstSelectedOption().getText();
        } catch (Exception e) {
            throw new AssertionError("Failed to retrieve selected allergy: "
                    + e.getMessage(), e);
        }
    }

    public boolean trySelectAllergy(String allergy) {
        try {
            Select select = new Select(allergiesDropdown);
            select.selectByVisibleText(allergy);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } catch (Exception e) {
            throw new AssertionError("Unexpected failure while trying to select allergy: "
                    + allergy + " — " + e.getMessage(), e);
        }
    }


    public void selectFoodPreference(String preference) {
        try {
            Select select = new Select(foodPreferenceDropdown);
            select.selectByVisibleText(preference);
        } catch (Exception e) {
            throw new AssertionError("Failed to select Food Preference: " + preference + " — "
                    + e.getMessage(), e);
        }
    }

    public String getSelectedFoodPreference() {
        try {
            Select select = new Select(foodPreferenceDropdown);
            return select.getFirstSelectedOption().getText();
        } catch (Exception e) {
            throw new AssertionError("Failed to retrieve selected Food Preference: "
                    + e.getMessage(), e);
        }
    }

    public boolean trySelectFoodPreference(String preference) {
        try {
            Select select = new Select(foodPreferenceDropdown);
            select.selectByVisibleText(preference);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } catch (Exception e) {
            throw new AssertionError("Unexpected failure while trying to select Food Preference: "
                    + preference + " — " + e.getMessage(), e);
        }
    }


    public void selectCuisineCategory(String category) {
        try {
            Select select = new Select(cuisineCategoryDropdown);
            select.selectByVisibleText(category);
        } catch (Exception e) {
            throw new AssertionError("Failed to select Cuisine Category: " + category + " — "
                    + e.getMessage(), e);
        }
    }

    public boolean trySelectCuisineCategory(String category) {
        try {
            Select select = new Select(cuisineCategoryDropdown);
            select.selectByVisibleText(category);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } catch (Exception e) {
            throw new AssertionError("Unexpected failure while trying to select Cuisine Category: "
                    + category + " — " + e.getMessage(), e);
        }
    }

    public void clickDOBField() {
        try {
            dobField.click();
        } catch (Exception e) {
            throw new AssertionError("Failed to click the DOB field: "
                    + e.getMessage(), e);
        }
    }

    public boolean isCalendarVisible() {
        try {
            return dobCalendar.isDisplayed();
        } catch (Exception e) {
            throw new AssertionError("Failed to verify if the calendar is visible: "
                    + e.getMessage(), e);
        }
    }


    public boolean hasMonthDropdown() {
        try {
            return monthDropdown.isDisplayed();
        } catch (Exception e) {
            throw new AssertionError("Failed to verify visibility of Month dropdown: "
                    + e.getMessage(), e);
        }
    }

    public boolean hasYearInput() {
        try {
            return yearInput.isDisplayed();
        } catch (Exception e) {
            throw new AssertionError("Failed to verify visibility of Year input: "
                    + e.getMessage(), e);
        }
    }

    public boolean hasDayCells() {
        try {
            return !dayCells.isEmpty();
        } catch (Exception e) {
            throw new AssertionError("Failed to verify presence of day cells: "
                    + e.getMessage(), e);
        }
    }

    public void selectMonth(String monthName) {
        try {
            monthDropdown.click();
            for (WebElement m : monthOptions) {
                if (m.getText().equalsIgnoreCase(monthName)) {
                    m.click();
                    return;
                }
            }
            throw new AssertionError("Month option not found: " + monthName);
        } catch (Exception e) {
            throw new AssertionError("Failed to select month: " + monthName + " — "
                    + e.getMessage(), e);
        }
    }


    public void selectYear(String year) {
        try {
            yearInput.clear();
            yearInput.sendKeys(year);
        } catch (Exception e) {
            throw new AssertionError("Failed to select year: " + year + " — "
                    + e.getMessage(), e);
        }
    }

    public void selectDay(String day) {
        try {
            for (WebElement d : dayCells) {
                if (d.getText().equals(day)) {
                    d.click();
                    return;
                }
            }
            throw new AssertionError("Day not found in calendar: " + day);
        } catch (Exception e) {
            throw new AssertionError("Failed to select day: " + day + " — "
                    + e.getMessage(), e);
        }
    }

    public String getDOBValue() {
        try {
            return dobField.getAttribute("value");
        } catch (Exception e) {
            throw new AssertionError("Failed to retrieve DOB value: "
                    + e.getMessage(), e);
        }
    }


}

