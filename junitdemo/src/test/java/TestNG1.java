import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG1 {
    private static MyStringClass myStringClass;
    private static final Logger LOG = Logger.getLogger(MyStringClass.class);

    @BeforeClass
    public void before() {
        LOG.info("String test started");
        myStringClass = new MyStringClass("one", "two", "three");
    }

    @DataProvider(name = "data1")
    public static Object[][] dataString() {return new Object[][]{
            {"one", "two", "three"}, {"one*", "two*", "three*"}, {"one**", "two**", "three**"}};
    }

    @Test(dataProvider = "data1")
    public void stringNotNull(String str1, String str2, String str3) {
        myStringClass = new MyStringClass(str1, str2, str3);
        Assert.assertNotNull(myStringClass.str1, "string1 is null");
        Assert.assertNotNull(myStringClass.str2, "string2 is null");
        Assert.assertNotNull(myStringClass.str3, "string3 is null");
    }

    @AfterClass
    public void after(){
        LOG.info("String test finished");
    }
}
