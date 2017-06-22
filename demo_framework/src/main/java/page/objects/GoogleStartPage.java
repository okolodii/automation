package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tools.BrowserDriver;
import webelements.Button;

public class GoogleStartPage {

    public GoogleStartPage() {
        PageFactory.initElements(BrowserDriver.getInstance(), this);
    }

    @FindBy(linkText = "Gmail")
    private WebElement gmailButton;


    public GmailPage goToGmailLoginPage() {
        new Button(gmailButton).click();
        return new GmailPage();
    }
}
