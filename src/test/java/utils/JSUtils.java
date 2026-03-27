package utils;

import DriverManager.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSUtils extends DriverFactory {

    public static void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static String getPageInnerText() {
        return (String) ((JavascriptExecutor) DriverFactory.getDriver())
                .executeScript("return document.documentElement.innerText;");
    }

    public static void clickElement(WebElement element) {
        ((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].click();", element);
    }
}
