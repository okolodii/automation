package tests;

import org.testng.annotations.Test;
import page.objects.GoogleStartPage;

public class TestExample extends BaseTest {

    /* We have onle tests and test elements that relate to the specific bunch of tests in one Test Class.
     BaseTest class provides methods that are used for each of the test and keeps WebDriver init on that level. */

    @Test
    public void testLogin() throws InterruptedException {
        new GoogleStartPage().goToGmailLoginPage().login("00cvent", "ForTests");
    }

}
