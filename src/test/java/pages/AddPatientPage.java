package pages;

import DriverManager.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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
}

