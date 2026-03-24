package pages;

import DriverManager.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPatientPage {

    private WebDriver driver;


    @FindBy(css = "a#newPatientLink")
    private WebElement newPatientHeader;

    @FindBy(xpath = "//h2[text()='Add Patient Details']")
    private WebElement dialogTitle;


    public AddPatientPage(WebDriver driver) {
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
}

