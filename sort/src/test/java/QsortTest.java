import org.junit.Test;

import java.util.Arrays;

/**
 *
 *
 */
public class QsortTest {

    @Test
    public void qsortTest() {
        int[] array = new int[] {3, 2, 1, 5, 7, 6};
        int[] sortedArray = Qsort.recQsort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
