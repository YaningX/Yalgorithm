import org.junit.Test;

import java.util.Arrays;

public class BubbleSortTest {
    @Test
    public void simpleBubbleSortTest() {
        int[] array = new int[] {1, 5, 3, 10, 3, 5, 0};
        System.out.println(Arrays.toString(BubbleSort.simplyBubbleSort(array)));
    }

    @Test
    public void optimizedBubbleSortTest() {
        int[] array = new int[] {1, 5, 3, 10, 3, 5, 0, -1};
        System.out.println(Arrays.toString(BubbleSort.optimizedBubbleSort(array)));
    }
}
