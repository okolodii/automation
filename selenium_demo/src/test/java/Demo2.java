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

public class Demo2 {
    private static final Logger LOG = Logger.getLogger(Demo1.class);
    WebDriver driver;
    WebElement elementLocator;

    @BeforeClass
    public static void precondition() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @Test
    public void Test1() throws InterruptedException {
        LOG.info("-----Creating a new instance of the Chrome-----");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        LOG.info("1. Open gmail & login");
        driver.get("http://www.gmail.com");
        driver.findElement(By.id("identifierId")).sendKeys("00cvent");
        driver.findElement(By.id("identifierNext")).click();
        driver.findElement(By.name("password")).sendKeys("ForTests");
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.id("passwordNext")));
        driver.findElement(By.id("passwordNext")).click();

        LOG.info("2. Click “Compose” button");
        driver.findElement(By.xpath("//div[@class='z0']/div")).click();

        LOG.info("3. Fill “To”, “Subject” & “message” fields");
        driver.findElement(By.name("to")).sendKeys("00cvent@gmail.com");
        driver.findElement(By.name("subjectbox")).sendKeys("Test subject");
        driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("Test message");

        LOG.info("4. Click “send” button");
        driver.findElement(By.xpath("//div[text()='Send']")).click();

        LOG.info("5. Verify that message is in “sent” folder");
        driver.findElement(By.xpath("//a[@title='Sent Mail']")).click();
        //new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("bog"))));
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.className("bog")).getText().contentEquals("Test subject"), "No subject");

        LOG.info("6. Remove message from the “sent” folder");
       // driver.findElement(By.xpath("//div[@class='Cp']//div[@role='checkbox']")).click();
       // driver.findElement(By.xpath("//div[@aria-label='Delete']")).click();

        // driver.quit();
    }

/* Task 2
1. Open gmail & login
2. Click “Compose” button
3. Fill “To”, “Subject” & “message” fields
4. Close “new message” window
5. Verify that message is saved as draft
6. Open message from the draft folder & send

Task 3
1. Open gmail & login
2. Mark 3 messages from inbox as important
3. Verify that messages are moved to “important” folder
4. Select those messages using checkboxes
5. Click on delete button
6. Verify that messages are deleted

Task 4
1. Open gmain & login
2. Select 3 messages from inbox using checkboxes
3. Click on “delete” button
4. Click on undo button
5. Verify that messages are not deleted

Task 5
1. Open gmail & login
2. Click on “compose” button
3. Fill the next fields: to, cc, bcc, subject & message
4. Click on “save & close” button
5. Go to the “draft” folder & open previously saved message
6. Verify that all fields are saved correctly
7. Press the “send” button

Task 6
1. Open gmail & login
2. Click on compose button
3. Enter incorrect email in “to” field, fill “subject”/”message” fields & press “send” button
4. Verify that warning message appears
5. Click “OK” & enter correct email address & click send
6. Verify that message is moved to “Sent mail” folder*/
}