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

public class Test1 {
    private static final Logger LOG = Logger.getLogger(Test1.class);
    WebDriver driver;
    WebElement elementLocator;

    @BeforeClass
    public static void precondition() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @Test
    public void Test1() {
        LOG.info("-----Creating a new instance of the Chrome-----");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        LOG.info("1.1 Go to www.google.com");
        driver.get("http://www.google.com");

        LOG.info("1.2 Find something");
        String searchedWord = "1984";
        elementLocator = driver.findElement(By.id("lst-ib"));
        elementLocator.sendKeys(searchedWord);
        elementLocator.submit();

        LOG.info("1.3 Collect and print all results titles");
        List<WebElement> titleList = driver.findElements(By.xpath("//h3[@class='r']/a"));
        for (WebElement ele : titleList) {
            LOG.info(ele.getText());
        }

        LOG.info("1.4 Collect and print all results links");
        List<WebElement> linkList = driver.findElements(By.xpath("//h3[@class='r']/a"));
        for(WebElement ele : linkList) {
            LOG.info(ele.getAttribute("href"));
        }

        LOG.info("1.5 Verify that all titles contain searched text");
        for (WebElement ele : titleList) {
            Assert.assertTrue(ele.getText().contains(searchedWord), "Title doesn't contain searched word " + searchedWord);
        }

        LOG.info("1.6 Open second search result page");
        elementLocator = driver.findElement(By.xpath("//*[@id='nav']//td[3]"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(elementLocator));
        elementLocator.click();

        LOG.info("1.7 Repeat 1.3, 1.4, 1.5 (Try to avoid code dublication)");



        // driver.quit();

    }


}