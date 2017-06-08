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

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
/*
1. Write simple test with TesNG/Junit and selenium with following steps:
        1.1 Go to www.google.com
        1.2 Find something
        1.3 Collect and print all results titles
        1.4 Collect and print all results links
        1.5 Verify that all titles contain searched text
        1.6 Open second search result page
        1.7 Repeat 1.3, 1.4, 1.5 (Try to avoid code dublication)

        2. Write simple test with TesNG/Junit and selenium with following steps:
        2.1 Login to gmail
        2.2 Create new message
        2.3 Fill all required fields
        2.4 Send message

        zorianatest@gmail.com strange15        */

public class GoogleTest {
    private static final Logger LOG = Logger.getLogger(GoogleTest.class);

    @BeforeClass
    public static void precondition() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        LOG.info("Initialization");
    }

    @Test
    public void testGoogle() throws InterruptedException {
        LOG.info("Creating a new instance of the Chrome");
        WebDriver driver = new ChromeDriver();
        String searchedWord = "Lviv";

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        LOG.info("Open URL");
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.id("lst-ib"));
        element.sendKeys(searchedWord);
        element.submit();

        LOG.info("Verify that page title contains " + searchedWord);
        new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains(searchedWord));
        Assert.assertTrue("Title doesn't contain " + searchedWord, driver.getTitle().contains(searchedWord));

        LOG.info("Collect, print and verify all titles");
        List<WebElement> titleList = driver.findElements(By.xpath("//h3[@class='r']/a"));

        for (WebElement ele : titleList) {
            LOG.info(ele.getText());

            if (ele.getText().contains(searchedWord)) {
                    LOG.info("^^^This element CONTAINS searched word " + searchedWord);
                }
                else {
                LOG.info("^^^This element DOES NOT contain searched word " + searchedWord);
            }
        }
        //titles.forEach(System.out::println);

        LOG.info("Collect and print all links");
        List<WebElement> linkList = driver.findElements(By.xpath("//h3[@class='r']/a"));
        for(WebElement ele : linkList) {System.out.println(ele.getAttribute("href"));}

        //LOG.info(driver.findElements(By.xpath("//h3[@class='r']/a")).forEach(el->););

        LOG.info("Go to page 2");
        Thread.sleep(3000);
        element = driver.findElement(By.xpath("//*[@id='nav']//td[3]"));
        element.click();

        driver.quit();
    }

    @Test
    public void testGmail() throws AWTException, InterruptedException {
        LOG.info("Creating a new instance of the Chrome");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        LOG.info("Open Gmail");
        driver.get("http://www.gmail.com");

        LOG.info("Login to Gmail");
        WebElement element = driver.findElement(By.id("identifierId"));
        element.sendKeys("zorianatest");
        element = driver.findElement(By.id("identifierNext"));
        element.click();
        element = driver.findElement(By.name("password"));
        element.sendKeys("strange15");
        element = driver.findElement(By.id("passwordNext"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("passwordNext")));
        element.click();

        LOG.info("Create new message");
        element = driver.findElement(By.xpath("//div[@class='z0']/div"));
        element.click();
        element = driver.findElement(By.name("to"));
        element.sendKeys("00cvent@gmail.com");
        element = driver.findElement(By.name("subjectbox"));
        element.sendKeys("Test");

        LOG.info("Send message");
        Robot r = new Robot();
        Thread.sleep(2000);

        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_CONTROL);

        LOG.info("Close browser");
        driver.quit();
    }
}