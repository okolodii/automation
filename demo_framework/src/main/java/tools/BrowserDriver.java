package tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserDriver {
    /* The example of Singleton implementation for Chrome WebDriver */

    private static ChromeDriver driver;

    private BrowserDriver() {
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            synchronized (BrowserDriver.class) {
                if (driver == null) {
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                    driver = new ChromeDriver();
                }
            }
        }
        return driver;
    }
}
