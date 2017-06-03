import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestJunit1 {
    private static MyStringClass myStringClass;
    private static final Logger LOG = Logger.getLogger(MyStringClass.class);

    @Before
    public void before() {
        LOG.info("String test started");
        myStringClass = new MyStringClass("one", "two", "three");
    }

    @Test
    public void test() {
        //Assert.assertTrue("str1 not equal one", myStringClass.s1() == "one");
        Assert.assertEquals("str1 equals one",myStringClass.s1(), "one");
        LOG.info("str1 = " + myStringClass.str1);

        Assert.assertTrue("str2 doesn't contain two", myStringClass.s2().contains("two"));
        LOG.info("str2 = " + myStringClass.str2);

        Assert.assertNotNull(myStringClass.s3());
        LOG.info("str3 = " + myStringClass.str3);
    }

    @After
    public void after(){
        LOG.info("String test finished");
    }
}
