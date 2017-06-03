import java.util.Arrays;
import java.util.stream.IntStream;

public class MyArrayClass {
    int[] array;
    int arraySum;
    double arrayAverage;

    public MyArrayClass(int[] array) {
        this.array = array;
    }

    public int arraySum() {return arraySum = IntStream.of(array).sum();}
    public double arrayAverage() {return arrayAverage = Arrays.stream(array).average().getAsDouble();}
    public int[] arrayIncreaser() {
        for (int i=0; i<array.length; i++) {
            array[i] = array[i] * 2;}
        return array;
        //return log.toArray(new String[0]);
    }
}
