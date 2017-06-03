import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class TestNG2 {
    private static MyArrayClass myArrayClass;
    private static final Logger LOG = Logger.getLogger(MyArrayClass.class);

    @BeforeClass
    public void before() {
        LOG.info("Array test started");
        myArrayClass = new MyArrayClass(new int[]{-3, 5, 10, 0, -2});
    }

    @DataProvider(name = "data2")
    public static Object[][] dataArray() {return new Object[][]{
            {0,1,2,3,4,5}, {5,4,3,2,1,0}, {-3, 5, 10, 0, -2}};
    }

    @Test(dataProvider = "data2")
    public void sumBigger0(int[] array) {
        myArrayClass = new MyArrayClass(array);
        Assert.assertTrue(myArrayClass.arraySum() > 0, "arraySum < 0");
        LOG.info("arraySum = " + myArrayClass.arraySum());


       /* Assert.assertNotNull(myArrayClass.arraySum(), "arraySum is null");
        Assert.assertTrue(myArrayClass.arraySum() > 0, "arraySum < 0");
        LOG.info("arraySum = " + myArrayClass.arraySum());

        Assert.assertTrue(myArrayClass.arrayAverage() > 1, "arrayAverage");
        LOG.info("arrayAverage = " + myArrayClass.arrayAverage());

        LOG.info("array befor increaser = " + Arrays.toString(myArrayClass.array));
        myArrayClass.arrayIncreaser();
        LOG.info("array befor increaser = " + Arrays.toString(myArrayClass.array));*/
    }

    @AfterClass
    public void after(){
        LOG.info("Array test finished");
    }
}
