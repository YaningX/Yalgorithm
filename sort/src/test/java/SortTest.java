import org.junit.Test;

import java.util.Arrays;

public class SortTest {
    private int[] array = new int[] {1, 5, 3, 10, 3, 5, 0, 2, 9, -1};

    private void process(Sort sort) {
        int[] resArray = sort.sort(array);
        System.out.println(Arrays.toString(resArray));
    }

    @Test
    public void heapSortTest() {
        Sort sort = new HeapSort();
        process(sort);
        int x = Integer.MIN_VALUE;
        System.out.println((long)8);
        int[][] array = new int[7][7];
        System.out.print(array.length);
    }

    @Test
    public void bubbleSortTest() {
        Sort sort = new BubbleSort();
        process(sort);
    }

    @Test
    public void countingSortTest() {
        Sort sort = new CountingSort();
        process(sort);
    }

    @Test
    public void mergeSortTest() {
        Sort sort = new MergeSort();
        process(sort);
    }

    @Test
    public void qSortTest() {
        Sort sort = new Qsort();
        process(sort);
    }
}
