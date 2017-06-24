import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class New {
    private static final Logger LOG = Logger.getLogger(Demo1.class);
    WebDriver driver;
    WebElement el;

    @BeforeClass
    public static void precondition() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @Test
    public void Test2() throws InterruptedException {
        LOG.info("-----Creating a new instance of the Chrome-----");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        LOG.info("2.1 Login to gmail");
        driver.get("http://www.gmail.com");
        driver.findElement(By.id("identifierId")).sendKeys("00cvent");
        driver.findElement(By.id("identifierNext")).click();
        driver.findElement(By.name("password")).sendKeys("ForTests");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("passwordNext")));
        driver.findElement(By.id("passwordNext")).click();
/*
        LOG.info("2.2 Create new message");
        driver.findElement(By.xpath("//div[@class='z0']/div")).click();

        LOG.info("2.3 Fill all required fields");
        driver.findElement(By.name("to")).sendKeys("00cvent@gmail.com");
        driver.findElement(By.name("subjectbox")).sendKeys("Test");

        LOG.info("2.4 Send message");
        driver.findElement(By.xpath("//div[text()='Send']")).click();
*/
        LOG.info("Go to sent messages");
        driver.findElement(By.xpath("//a[@title='Sent Mail']")).click();
        Thread.sleep(5000);
        //String s = driver.findElement(By.className("bog")).getText();
        //String s = driver.findElement(By.className("y2")).getText();

        Assert.assertTrue(driver.getPageSource().contains("Test message1"), "errrrrrrrrrrrrrrrrrrrrr");



        // driver.quit();
    }
}