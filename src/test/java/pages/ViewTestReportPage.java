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
	
	@FindBy(xpath = "//button[contains(text(),'View Previous Test Reports" ) 
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
	
	@FindBy(xpath = "//button[contains(text(),'View PDF" ) 
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
		logger.info("Clicking Login button.");
		//JSUtils.clickElement(ViewTestReportButton);
		ViewTestReportButton.click();
	}
	
	public boolean isReportOpenedForSelectedRecord() {
	    boolean opened = modalContainer.isDisplayed();
	    logger.info("Report modal opened for selected record: {}", opened);
	    return opened;
	}

	public String getPageTitle() {
	    String title = pageTitle.getText().trim();
	    logger.info("Page title retrieved: {}", title);
	    return title;
	}

	public boolean isPatientIdDisplayed() {
        boolean visible = patientId.isDisplayed();
        logger.info("Patient ID visibility: {}", visible);
        return visible;
    }
	
	public boolean isPatientNameDisplayed() {
        boolean visible = patientName.isDisplayed();
        logger.info("Patient Name visibility: {}", visible);
        return visible;
    }
	
	public boolean isPatientEmailDisplayed() {
        boolean visible = patientEmail.isDisplayed();
        logger.info("Patient Email visibility: {}", visible);
        return visible;
    }

	public boolean isPatientContactNumberDisplayed() {
        boolean visible = patientContactNumber.isDisplayed();
        logger.info("Patient Contact Number visibility: {}", visible);
        return visible;
    }
	
	public boolean isCloseButtonDisplayed() {
        boolean visible = CloseButton.isDisplayed();
        logger.info("Close Button: {}", visible);
        return visible;
    }

	public boolean isReportTableDisplayed() {
        boolean visible = ReportTable.isDisplayed();
        logger.info("Report Table: {}", visible);
        return visible;
    }
		
	public boolean isViewPDFButtonVisible() {
		boolean visible = ViewPDFButton.isDisplayed();
		logger.info("View PDF button visibility: {}", visible);
		return visible;
	}
	
	public void isTableHeaderDisplayed(String expectedHeader) {

	    boolean found = false;

	    for (WebElement header : tableHeaders) {
	        String actualText = header.getText();

	        if (actualText.equalsIgnoreCase(expectedHeader)) {
	            found = true;
	            break;}
	    }

	    if (!found) {
	        throw new AssertionError("Header not found: " + expectedHeader);
	    }
	}
	
	public void verifyVitalsOrder() {

	     String actualVitals = vitalsCells.get(0).getText().trim();
	    logger.info("Actual Vitals text retrieved: " + actualVitals);
	    String[] expectedOrder = {"Weight", "Height", "Temperature", "SP", "DP"};

	    int lastIndex = -1;      
	    for (int i = 0; i < expectedOrder.length; i++) {

	        String vital = expectedOrder[i];
		int currentIndex = actualVitals.indexOf(vital);

	        
	        if (currentIndex == -1) {
	            throw new AssertionError("Vital not found in cell: " + vital);
	        }


	        if (currentIndex < lastIndex) {
	            throw new AssertionError("Vital '" + vital + "' is out of order in: " + actualVitals);
	        }

		 lastIndex = currentIndex;
	    }

	    logger.info("Vitals are displayed in correct order: Weight → Height → Temperature → SP → DP");
	}
	
	public void isPaginationControlsDisplayed() {
	    Assert.assertTrue(firstPageArrow.isDisplayed(),
	            "First page arrow is not displayed");
	    Assert.assertTrue(previousArrow.isDisplayed(),
	            "Previous arrow is not displayed");
	    Assert.assertTrue(nextArrow.isDisplayed(),
	            "Next arrow is not displayed");
	    Assert.assertTrue(lastPageArrow.isDisplayed(),
	            "Last page arrow is not displayed");
	    logger.info("All pagination controls are displayed: <<, <, >, >>");
	}
	
}