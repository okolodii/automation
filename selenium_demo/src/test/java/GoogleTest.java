import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleTest {
    private static final Logger LOG = Logger.getLogger(Page.class);

    @BeforeClass
    public static void precondition() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        LOG.info("Initialization");
    }

    @Test
    public void testGoogle() throws InterruptedException {
        LOG.info("Creating a new instance of the Chrome");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        LOG.info("Open URL");
        driver.get("http://www.google.com");

        WebElement element = driver.findElement(By.xpath("//*[@name='q']"));
        element.sendKeys("Lviv");
        element.submit();

        //Thread.sleep(3000);
        new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("Lviv"));

        Assert.assertTrue("Title doesn't contain Lviv", driver.getTitle().contains("Lviv"));
        driver.quit();
    }

    @Test
    public void testGmail() throws InterruptedException {
        LOG.info("Creating a new instance of the Chrome");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        LOG.info("Open URL");
        driver.get("http://www.gmail.com");

        WebElement element = driver.findElement(By.xpath("//*[@name='identifier']"));
        element.sendKeys("00cvent");
        element = driver.findElement(By.xpath("//*[@id='identifierNext']"));
        element.click();
       // Thread.sleep(3000);
        element = driver.findElement(By.xpath("//*[@name='password']"));
        element.sendKeys("ForTests");
        element = driver.findElement(By.xpath("//*[@id='passwordNext']"));
        element.click();
      //  Thread.sleep(3000);

        driver.quit();
    }
}