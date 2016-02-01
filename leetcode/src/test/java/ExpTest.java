import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xuyaning on 1/2/16.
 */
public class ExpTest {
    @Test
    public void testMyComparator() {
        class MyComparator implements Comparator<Integer> {
            public int compare(Integer x, Integer y) {
                return y - x;
            }
        }
        Integer[] array = {1, 2, -3, 9};
        Arrays.sort(array, new MyComparator());
        System.out.println(Arrays.toString(array));
    }
}
