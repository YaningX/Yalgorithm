import org.junit.Test;

import java.util.Arrays;

public class MergeSortTest {
    @Test
    public void mergeSortTest() {
        int[] array = new int[] {1, 5, 3, 10, 3, 5, -1, 2};
        System.out.println(Arrays.toString(MergeSort.mergeSort(array)));
    }
}
