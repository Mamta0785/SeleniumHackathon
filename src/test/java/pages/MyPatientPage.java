package pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DriverManager.DriverFactory;

public class MyPatientPage {
	private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
	private WebDriver driver;

	    @FindBy(xpath = "//h2[text()='My Patients']")
	    private WebElement pageHeading;

	    //Search Box
	    @FindBy(xpath = "id='searchBox']")
	    private WebElement searchBox;
	    
	    @FindBy(xpath = "//input[@placeholder='Search...']")
	    private WebElement searchBoxText;
	    

		@FindBy(xpath = "//img[@alt='search']")//*
	    private WebElement searchIcon;

	 //Table Headers
		
		@FindBy(xpath = "//th")
		private List<WebElement> tableHeaders;
		
		@FindBy(xpath = "//tr")
		private List<WebElement> tableRows;
		
	    @FindBy(xpath = "//th[contains(text(),'Patient Id')]")
	    private WebElement patientIdHeader;

	    @FindBy(xpath = "//th[contains(text(),'Name')]")
	    private WebElement nameHeader;

	    @FindBy(xpath = "//th[contains(text(),'Details')]")
	    private WebElement detailsHeader;

	    @FindBy(xpath = "//th[contains(text(),'Last Visit Date')]")
	    private WebElement lastVisitDateHeader;

	    @FindBy(xpath = "//th[contains(text(),'Actions')]")
	    private WebElement actionsHeader;

	    @FindBy(xpath = "//th[contains(text(),'Edit/Delete')]")
	    private WebElement editDeleteHeader;

	    @FindBy(xpath = "//th[contains(text(),'Patient Id')]//span")
	    private WebElement patientIdSortIcon;

	    @FindBy(xpath = "//th[contains(text(),'Name')]//span")
	    private WebElement nameSortIcon;

	    @FindBy(xpath = "//table//tbody//tr//td[2]")
	    private List<WebElement> patientNames;

	    @FindBy(xpath = "//button[contains(text(),'View Previous Test Reports')]")
	    private List<WebElement> viewTestReportsButtons;

	    @FindBy(xpath = "//button[contains(text(),'View Previous Diet Plans')]")
	    private List<WebElement> viewDietPlansButtons;

	    @FindBy(xpath = "//button[contains(text(),'Create New Report/Plan')]")
	    private List<WebElement> createReportButtons;

	    @FindBy(xpath = "//button[contains(@class,'edit')]")
	    private List<WebElement> editIcon;

	    @FindBy(xpath = "//button[contains(@class,'delete')]")
	    private List<WebElement> deleteIcon;

	    @FindBy(className = "asc")
	    private WebElement upArrow;
	    
	    @FindBy(className = "desc")
	    private WebElement downArrow;
	    
	    @FindBy(xpath = "//a[text()='My Patients']")
	    private WebElement myPatientsTab;

	    @FindBy(xpath = "//a[text()='New Patient']")
	    private WebElement newPatientTab;

	    @FindBy(xpath = "//a[text()='Logout']")
	    private WebElement logoutButton;

	
	public MyPatientPage() {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(this.driver, this);
		logger.info("MyPatientPage initialized successfully.");
	}
	
	public String getPageHeadingText() {
		String heading = pageHeading.getText().trim();
		logger.info("Page heading retrieved: {}", heading);
		return heading;
	}
	
	public boolean isSearchBoxVisible() {
		boolean isVisible = searchBox.isDisplayed();
		logger.info("Search box visibility: {}", isVisible);
		return isVisible;
	}
	
	public boolean isSearchIconVisible() {
		boolean isVisible = searchIcon.isDisplayed();
		logger.info("Search icon visibility: {}", isVisible);
		return isVisible;
	}
	
	public String getSearchBoxPlaceholderText() {
		String placeholder = searchBoxText.getAttribute("placeholder").trim();
		logger.info("Search box placeholder text retrieved: {}", placeholder);
		return placeholder;
	}
	
	public List<String> getTableHeaderTexts() {
		List<String> headers = List.of(patientIdHeader.getText().trim(), nameHeader.getText().trim(), detailsHeader.getText().trim(),	lastVisitDateHeader.getText().trim(), actionsHeader.getText().trim(), editDeleteHeader.getText().trim());
		logger.info("Table header texts retrieved: {}", headers);
		return headers;
	}
	
	
	public List<String> getDetailsrowText(){
		List<String> DetailsrowText = new ArrayList<>();
		
		List<WebElement> rows = tableRows.subList(1, tableRows.size()); // Skip header row
	    int columnIndex = tableHeaders.stream()
	                                  .map(WebElement::getText)
	                                  .map(String::trim)
	                                  .toList()
	                                  .indexOf("Details");

	        for (int i = 0; i < rows.size(); i++) {

	            WebElement detailsCell = rows.get(i)
	                                         .findElements(By.xpath("td"))
	                                         .get(columnIndex);

	            String cellText = detailsCell.getText().trim();  
	            DetailsrowText.add(cellText);
	        }		
	        return DetailsrowText;
	}
	
	public boolean isdetailsDisplayednextline() {
		int columnIndex = tableHeaders.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .toList()
                .indexOf("Details");

		    return tableRows.stream().allMatch(row -> {

		        String text = row.findElements(By.xpath("td"))
		                         .get(columnIndex)
		                         .getText()
		                         .toLowerCase();

		        return text.contains("\n") &&
		               text.contains("phone") &&
		               text.contains("email") &&
		               (text.contains("dob") || text.contains("date"));
		    });
		}
	
	public boolean isDetailFormatValid(String detail) {

		int columnIndex = tableHeaders.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .toList()
                .indexOf("Details");

	    return tableRows.stream().allMatch(row -> {
	        String text = row.findElements(By.xpath("td"))
	                         .get(columnIndex)
	                         .getText();

	        return switch (detail.toLowerCase()) {
	            case "phone number" -> text.matches(".*\\b\\d{10}\\b.*");
	            case "email" -> text.matches(".*[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+.*");
	            case "date of birth" -> text.matches(".*\\b\\d{2}/\\d{2}/\\d{4}\\b.*");

	            default -> false;
	        };
	    });
	}

	public boolean isLastDateFormatValid(String LastVisitDate) {
		
		int columnIndex = tableHeaders.stream().map(WebElement::getText).map(String::trim).toList().indexOf("Last Visit Date");
		DateTimeFormatter format = DateTimeFormatter.ofPattern("mm/dd/yyyy");

		    return tableRows.stream().allMatch(row -> {
		        try {
		            String date = row.findElements(By.xpath("td")).get(columnIndex).getText().trim();

		            LocalDate.parse(date, format); // throws error if invalid
		            return true;

		        } catch (Exception e) {
		            return false;
		        }
		    });		
	}
	
	public boolean isSortIconVisible(String columnName) {
		boolean isVisible = false;
		switch (columnName.toLowerCase()) {
			case "patient id":
				isVisible = patientIdSortIcon.isDisplayed();
				logger.info("Patient ID sort icon visibility: {}", isVisible);
				break;
			case "name":
				isVisible = nameSortIcon.isDisplayed();
				logger.info("Name sort icon visibility: {}", isVisible);
				break;
			default:
				logger.warn("Invalid column name provided for sort icon visibility check: {}", columnName);
		}
		return isVisible;
	}
	
	public boolean iscolumnheadervaluePresent(String columnName) {
		    List<WebElement> rows = tableRows.subList(1, tableRows.size()); // Skip header row
		    int columnIndex = tableHeaders.stream()
		                                  .map(WebElement::getText)
		                                  .map(String::trim)
		                                  .toList()
		                                  .indexOf(columnName);
		        for (int i = 0; i < rows.size(); i++) {

		            String value = rows.get(i)
		                               .findElements(By.xpath("td"))
		                               .get(columnIndex)
		                               .getText()
		                               .trim();

		            switch (columnName.toLowerCase()) {
		                case "patient id":
		                    if (!value.matches("\\d+")) return false;
		                    break;
		                case "name":
		                    if (!value.matches("[A-Za-z ]+")) return false;
		                    break;
		                case "last visit date":
		                    if (!value.matches("\\d{2}-\\d{2}-\\d{4}")) return false;
		                    break;
		                default:
		                    return false;
		            }
		        }
		        return true;
		   		        }
		    
	
	public boolean isPatientListDisplayed() {
		if (tableRows.size() > 1) { // Assuming the first row is the header
			logger.info("Patient list is displayed with {} rows.", tableRows.size() - 1);
			return true;
		} else {
			logger.warn("Patient list is not displayed or contains no patient data.");
			return false;
		}
	}
	
	public boolean areActionBtnDisplayed(List<String> buttons) {
	    for (int i = 0; i < tableRows.size(); i++) {
	    	        for (String btn : buttons) {
	    	            try {
	    	                WebElement button = null;
	    	                switch (btn.toLowerCase()) {
	    	                    case "view previous test reports":
	    	                        button = viewTestReportsButtons.get(i);
	    	                        break;
	    	                    case "view previous diet plans":
	    	                        button = viewDietPlansButtons.get(i);
	    	                        break;
	    	                    case "create new report/plan":
	    	                        button = createReportButtons.get(i);
	    	                        break;
	    	                    default:
	    	                        return false;
	    	                }
	    	                if (button == null || !button.isDisplayed()) {
	    	                    return false;
	    	                }
	    	            } catch (Exception e) {
	    	                return false;
	    	            }
	    	        }
	    	    }
	    	    return true;
	    	}

	public boolean isIconVisible(String icon) {
	        for (int i = 0; i < tableRows.size(); i++) {
	            try {
	                WebElement iconElement = null;
	                switch (icon.toLowerCase()) {
	                    case "edit":
	                        iconElement = editIcon.get(i);
	                        break;
	                    case "delete":
	                        iconElement = deleteIcon.get(i);
	                        break;
	                    default:
	                        return false;
	                }
	                if (iconElement == null || !iconElement.isDisplayed()) {
	                    return false;
	                }
	            } catch (Exception e) {
	                return false;
	            }
	        }
	        return true;
	    }
		
	public void clicksortarrow(String column, String arrow) {
		int columnIndex = tableHeaders.stream().map(WebElement::getText).map(String::trim).toList().indexOf(column);
			
		if (arrow.equalsIgnoreCase("up")) {
			upArrow.click();
		}
			else if (arrow.equalsIgnoreCase("down")) {
				downArrow.click();		
			}
	}
	
	public boolean isColumnSorted(String column, String order) {

		int columnIndex = tableHeaders.stream().map(WebElement::getText).map(String::trim).toList().indexOf(column);
	    List<String> actual = new ArrayList<>();

	    for (WebElement row : tableRows) {
	        String text = row.findElements(By.tagName("td")).get(columnIndex).getText().trim();
	        actual.add(text);
	    }
	    List<String> expected = new ArrayList<>(actual);

	    Collections.sort(expected);

	    if (order.equalsIgnoreCase("descending")) {
	        Collections.reverse(expected);
	    }

	    return actual.equals(expected);
	}
}
