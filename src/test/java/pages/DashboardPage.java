package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DriverManager.DriverFactory;

public class DashboardPage {
	private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

	private WebDriver driver;
	
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement loginLink;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutLink;

	@FindBy(xpath = "//a[text()='MyPatients']")
	private WebElement myPatientsLink;

	@FindBy(xpath = "//a[text()='NewPatient']")
	private WebElement newPatientLink;

	@FindBy(xpath = "//img[@alt='Home']")//*
    private WebElement homeIcon;
	
	public DashboardPage() {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);;
		logger.info("DashboardPage initialized successfully.");
	}
	
	public List<String> getNavigationLinkText() {
		List<String> linkTexts = new ArrayList<>();
		if (loginLink.isDisplayed()) {
			linkTexts.add(loginLink.getText());
		}
		if (logoutLink.isDisplayed()) {
			linkTexts.add(logoutLink.getText());
		}
		if (myPatientsLink.isDisplayed()) {
			linkTexts.add(myPatientsLink.getText());
		}
		if (newPatientLink.isDisplayed()) {
			linkTexts.add(newPatientLink.getText());
		}
		return linkTexts;
	}
	
	public void clickhomeIcon() {
		homeIcon.click();
		logger.info("Clicked on Home icon.");
	}	
	
	public void clicknavigationLink(String linkText) {
		switch (linkText.toLowerCase()) {
			case "Login":
				loginLink.click();
				logger.info("Clicked on Login link.");
				break;
			case "Logout":
				logoutLink.click();
				logger.info("Clicked on Logout link.");
				break;
			case "MyPatients":
				myPatientsLink.click();
				logger.info("Clicked on MyPatients link.");
				break;
			case "NewPatient":
				newPatientLink.click();
				logger.info("Clicked on NewPatient link.");
				break;
			default:
				logger.warn("No matching navigation link found for text: {}", linkText);
		}
	}
}