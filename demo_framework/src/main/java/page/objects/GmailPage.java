package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tools.BrowserDriver;
import webelements.Button;
import webelements.Input;

public class GmailPage {

    public GmailPage() {
        PageFactory.initElements(BrowserDriver.getInstance(), this);
    }

    @FindBy(id = "identifierId")
    private WebElement emailInput;

    @FindBy(id = "identifierNext")
    private WebElement nextButton;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "passwordNext")
    private WebElement passwordNextButton;

    @FindBy(xpath = "//div[@class='z0']/div")
    private WebElement composeButton;

    @FindBy(name = "to")
    private WebElement toInput;

    @FindBy(name = "subjectbox")
    private WebElement subjectInput;

    @FindBy(xpath = "//div[@aria-label='Message Body']")
    private WebElement mesageInput;

    @FindBy(xpath = "//div[text()='Send']")
    private WebElement sendButton;

    @FindBy(xpath = "//a[@title='Sent Mail']")
    private WebElement sentButton;

    @FindBy(xpath = "//div[@role='checkbox']/div")
    private WebElement checkBox;

    /* We initialize WebElement and pass it into Wrapper(Input, Button) constructor
     where we implement common bunch of methods used with the specific type of element */

    public void login(String userName, String password) throws InterruptedException {
        new Input(emailInput).typeText(userName);
        new Button(nextButton).click();
        waitForElementToAppear(passwordInput);
        new Input(passwordInput).typeText(password);

        /* We should use the approach below in case of using one element for several times within the method */
        Button passwordNext = new Button(passwordNextButton);
        passwordNext.click();
    }

    public void sentEmail(String email, String subject, String message) throws InterruptedException {
        waitForElementToAppear(composeButton);
        composeButton.click();

        new Input(toInput).typeText(email);
        new Input(mesageInput).typeText(message);
        new Input(subjectInput).typeText(subject);
        new Button(sendButton).click();
    }

    public void verifyMessageInSent(String email, String subject, String message) throws InterruptedException {
        waitForElementToAppear(sentButton);
        sentButton.click();
        Thread.sleep(3000);

        Assert.assertTrue(BrowserDriver.getInstance().getPageSource().contains(email), "Sent box doesn't contain such email: "+email);
        Assert.assertTrue(BrowserDriver.getInstance().getPageSource().contains(subject), "Sent box doesn't contain such subject: "+subject);
        Assert.assertTrue(BrowserDriver.getInstance().getPageSource().contains(message), "Sent box doesn't contain such message: "+message);
    }

    public void removeLastSentEmail() {
        new Button(checkBox).click();
    }

    private void waitForElementToAppear(WebElement element) throws InterruptedException {
        new WebDriverWait(BrowserDriver.getInstance(), 30).until(ExpectedConditions.elementToBeClickable(element)); //until(ExpectedConditions.visibilityOf(element));
    }
}
