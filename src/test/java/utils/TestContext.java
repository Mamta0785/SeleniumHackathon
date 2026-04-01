package utils;

import java.util.Map;

public class TestContext {
    private static ThreadLocal<String> browserFromTestNG = new ThreadLocal<>();
	// For single-row usage
	public static Map<String, String> testData;

    public String getBrowserFromTestNG() {
        return browserFromTestNG.get();
    }
    public void setBrowserFromTestNG(String browser) {
        browserFromTestNG.set(browser);
    }
}
