package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {

    private static final String EXECUTABLE_DRIVER_FILENAME = "c:\\soft\\maven\\bin\\chromedriver.exe";

    private static WebDriver webDriver;

    public static void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", EXECUTABLE_DRIVER_FILENAME);
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    public static WebDriver getWebDriver() {
        if (webDriver != null) {
            return webDriver;
        } else {
            throw new IllegalStateException("Driver has not been initialized. " +
                    "Please call WebDriverManager.initWebDriver() before use this method");
        }
    }

    public static boolean isOpen() { return getWebDriver() != null; }

    public static void finish() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
