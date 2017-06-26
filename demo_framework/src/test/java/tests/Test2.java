package tests;

import org.testng.annotations.Test;
import page.objects.GmailPage;

public class Test2 extends BaseTest{
    @Test
    public void Test2() throws InterruptedException {
        LOG.info("1. Open gmail & login");
        //new GmailPage().login("00cvent", "ForTests");
    }
}
