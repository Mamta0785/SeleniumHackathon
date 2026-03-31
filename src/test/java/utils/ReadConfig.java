package utils;

public class ReadConfig {
    private static ThreadLocal<String> browserFromTestNG = new ThreadLocal<>();
    public String getBrowserFromTestNG() {
        return browserFromTestNG.get();
    }
    public void setBrowserFromTestNG(String browser) {
        browserFromTestNG.set(browser);
    }
}
