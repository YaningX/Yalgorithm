import org.junit.Test;

import java.util.Arrays;

public class CountingSortTest {
    @Test
    public void countingSortTest() {
        int[] array = new int[] {1, 5, 3, 10, 3, 5};
        System.out.println(Arrays.toString(CountingSort.countingSort(array)));
    }
}
