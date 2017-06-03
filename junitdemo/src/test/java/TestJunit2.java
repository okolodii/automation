import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class TestJunit2 {
    private static MyArrayClass myArrayClass;
    private static final Logger LOG = Logger.getLogger(MyArrayClass.class);

    @Before
    public void before() {
        LOG.info("Array test started");
        myArrayClass = new MyArrayClass(new int[]{-3, 5, 10, 0, -2});
    }

    @Test
    public void test() {
        Assert.assertNotNull("arraySum is null", myArrayClass.arraySum());
        Assert.assertTrue("arraySum < 0", myArrayClass.arraySum() > 0);
        LOG.info("arraySum = " + myArrayClass.arraySum());

        Assert.assertTrue("arrayAverage", myArrayClass.arrayAverage() > 1);
        LOG.info("arrayAverage = " + myArrayClass.arrayAverage());

        LOG.info("array befor increaser = " + Arrays.toString(myArrayClass.array));
        myArrayClass.arrayIncreaser();
        LOG.info("array befor increaser = " + Arrays.toString(myArrayClass.array));
    }

    @After
    public void after(){
        LOG.info("Array test finished");
    }
}
