package utils;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebElement;

import DriverManager.DriverFactory;

public class ElementUtil {

	public static String getURL() {
		return DriverFactory.getDriver().getCurrentUrl();
	}

	public static String getTitle() {
		return DriverFactory.getDriver().getTitle();
	}

	public static String getAttributeValue(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}
}