package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import tools.BrowserDriver;

public class BaseTest {
    public static final Logger LOG = Logger.getLogger(BaseTest.class);
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = BrowserDriver.getInstance();
        driver.get("http://gmail.com");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
