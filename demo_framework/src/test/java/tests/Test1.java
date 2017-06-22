package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.GmailPage;
import page.objects.GoogleStartPage;
import webelements.Button;
import webelements.Input;

public class Test1 extends BaseTest {
    /* We have onle tests and test elements that relate to the specific bunch of tests in one Test Class.
    BaseTest class provides methods that are used for each of the test and keeps WebDriver init on that level. */

    @Test
    public void testLogin() throws InterruptedException {
        String recipient = "oleh_kolodii@epam.com";
        String subject = "Test subject";
        String message = "Test message";

        LOG.info("1. Open gmail & login");
        new GmailPage().login("00cvent", "ForTests");

        LOG.info("2. Click “Compose” button");
        LOG.info("3. Fill “To”, “Subject” & “message” fields");
        LOG.info("4. Click “send” button");
        new GmailPage().sentEmail(recipient, subject, message);

        LOG.info("5. Verify that message is in “sent” folder");
        //new GmailPage().verifyMessageInSent(recipient, subject, message);

        //LOG.info("6. Remove message from the “sent” folder");
    }
}
