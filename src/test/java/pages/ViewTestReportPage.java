package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import DriverManager.DriverFactory;


public class ViewTestReportPage {
	
	private static final Logger logger = LoggerFactory.getLogger(ViewTestReportPage.class);

	private WebDriver driver;
	
	@FindBy(xpath = "//button[contains(text(),'View Previous Test Reports')]" ) 
	private WebElement ViewTestReportButton;
	
	@FindBy (xpath = "//div[@class='modal-content']")
	private WebElement modalContainer;
	
	@FindBy (xpath = "//div[@class='modal-title h4']")
	private WebElement pageTitle;
	
	@FindBy(xpath = "//div[contains(text(),'Patient ID:')]")
    private WebElement patientId;

	@FindBy(xpath = "//div[contains(text(),'Patient Name:')]")
    private WebElement patientName;
	
	@FindBy(xpath = "//div[contains(text(),'Patient Email:')]")
    private WebElement patientEmail;
	
	@FindBy(xpath = "//div[contains(text(),'Patient Contact Number:')]")
    private WebElement patientContactNumber;
	
	@FindBy(xpath = "//button[contains(text(),'Close')]")
    private WebElement CloseButton;
	
	@FindBy(xpath = "//table[@name='ReportTable']//tr")
    private WebElement ReportTable;
	
	@FindBy(xpath = "//button[contains(text(),'View PDF')]" ) 
	private WebElement ViewPDFButton;
	
	@FindBy(css = " table > tbody > tr:nth-child(1)")
	private List<WebElement> tableHeaders;
	
	@FindBy(xpath = "//td[contains(@class,'vitals')]")
	public List<WebElement> vitalsCells;
	
	@FindBy(xpath = "//button[normalize-space(text())='<<']")
	private WebElement firstPageArrow;
	
	@FindBy(xpath = "//button[normalize-space(text())='<']")
	private WebElement previousArrow;
	
	@FindBy(xpath = "//button[normalize-space(text())='>']")
	private WebElement nextArrow;
	
	@FindBy(xpath = "//button[normalize-space(text())='>>']")
	private WebElement lastPageArrow;
	
	public ViewTestReportPage() {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);;
		logger.info("ViewTestReportPage initialized successfully.");	
}
	
	public void clickViewTestReportButton() {
		logger.info("Clicking View Test Report button.");
		
		try {
	        ViewTestReportButton.click();
	        logger.info("View Test Report button clicked successfully");
	    } catch (Exception e) {
	        logger.error("Failed to click View Test Report button", e);
	        throw new AssertionError("Unable to click View Test Report button", e);
	    }
	}
	
	public boolean isReportOpenedForSelectedRecord() {
		try {
	        boolean opened = modalContainer.isDisplayed();
	        logger.info("Report modal opened for selected record: {}", opened);
	        return opened;
	    } catch (Exception e) {
	        logger.error("Error while checking report modal", e);
	        return false;
	    }
	}

	public String getPageTitle() {
		try {
	        String title = pageTitle.getText().trim();
	        logger.info("Page title retrieved: {}", title);
	        return title;
	    } catch (Exception e) {
	        logger.error("Error in page title display", e);
	        return "";  
	    }
	}

		
	public boolean isCloseButtonDisplayed() {
		try {
	        boolean visible = CloseButton.isDisplayed();
	        logger.info("Close Button visibility: {}", visible);
	        return visible;
	    } catch (Exception e) {
	        logger.error("Error checking Close Button is visible", e);
	        return false;
	    }
        
    }
	
	public boolean isPatientInfoFieldDisplayed(String fieldName) {
	    try {
	        switch (fieldName.trim().toLowerCase()) {

	            case "patient id":
	                return patientId.isDisplayed();

	            case "patient name":
	                return patientName.isDisplayed();

	            case "patient email":
	                return patientEmail.isDisplayed();

	            case "contact number":
	                return patientContactNumber.isDisplayed();

	            default:
	                logger.error("Invalid field name passed: {}", fieldName);
	                return false;
	        }

	    } catch (Exception e) {
	        logger.error("Error checking visibility for field: {}", fieldName, e);
	        return false;
	    }
	}

	public boolean isReportTableDisplayed() {
		try {
	        boolean visible = ReportTable.isDisplayed();
	        logger.info("Report Table visibility: {}", visible);
	        return visible;
	    } catch (Exception e) {
	        logger.error("Error checking Report Table is visible", e);
	        return false;
	    }
		
    }
		
	public boolean isViewPDFButtonVisible() {
		try {
	        boolean visible = ViewPDFButton.isDisplayed();
	        logger.info("View PDF button visibility: {}", visible);
	        return visible;
	    } catch (Exception e) {
	        logger.error(" View PDF button is not visible", e);
	        return false;
	    }
	}
	
	public boolean isTableHeaderDisplayed(String expectedHeader) {

		try {
	        for (WebElement header : tableHeaders) {
	            if (header.getText().trim().equalsIgnoreCase(expectedHeader)) {
	                logger.info("Header '{}' is displayed correctly", expectedHeader);
	                return true;
	            }
	        }
	        return false;
	    } catch (Exception e) {
	        logger.error("Error verifying table header: {}", expectedHeader, e);
	        return false;
	    }
	    
	}
	
	public void verifyVitalsOrder() {

		try {
	        String actualVitals = vitalsCells.get(0).getText().trim();
	        logger.info("Actual Vitals text : {}", actualVitals);

	        String[] expectedOrder = {"Weight", "Height", "Temperature", "SP", "DP"};
	        int lastIndex = -1;

	        for (String vital : expectedOrder) {
	            int currentIndex = actualVitals.indexOf(vital);

	            if (currentIndex == -1) {
	                throw new AssertionError("Vital not found in cell: " + vital);
	            }

	            if (currentIndex < lastIndex) {
	                throw new AssertionError(
	                        "Vital '" + vital + "' is out of order: " + actualVitals
	                );
	            }

	            lastIndex = currentIndex;
	        }

	        logger.info("Vitals are displayed in correct order: Weight → Height → Temperature → SP → DP");

	    } catch (Exception e) {
	        logger.error("Error in vitals order", e);
	        throw new AssertionError(
	                "Vitals order validation failed ", e
	        );
	    }
	}
	
	public boolean isPaginationControlsDisplayed() {
		try {
	        boolean first = firstPageArrow.isDisplayed();
	        boolean prev = previousArrow.isDisplayed();
	        boolean next = nextArrow.isDisplayed();
	        boolean last = lastPageArrow.isDisplayed();

	        logger.info("Pagination controls visibility: first={}, prev={}, next={}, last={}",
	                first, prev, next, last);

	        return first && prev && next && last;

	    } catch (Exception e) {
	        logger.error("Error while checking pagination controls", e);
	        return false;
	    }
	    }
	
}
		
