import org.junit.Test;

import java.util.Arrays;

public class SortTest {
    private int[] array = new int[] {1, 5, 3, 10, 3, 5, 0, 2, 9};

    private void process(Sort sort) {
        int[] resArray = sort.sort(array);
        System.out.println(Arrays.toString(resArray));
    }
    @Test
    public void heapSortTest() {
        Sort sort = new HeapSort();
        process(sort);
    }
}
