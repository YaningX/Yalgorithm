package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xuyaning on 1/2/16.
 */
public class Leet179 {
    class MyComparator implements Comparator<Integer> {
        public int compare(Integer x, Integer y) {
            long xy = Long.valueOf("" + x + y);
            long yx = Long.valueOf("" + y + x);
            if (xy > yx) {
                return 1;
            } else if (xy < yx) {
                return -1;
            }
            return 0;
        }
    }

    public String largestNumber(int[] nums) {
        String result = "";
        if (nums.length == 0) {
            return result;
        }
        Integer[] array = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i];
        }
        Arrays.sort(array, new MyComparator());
        for (int i = array.length - 1; i >= 0; i--) {
            result += array[i];
        }
        while (result.length() > 1 && result.charAt(0) == '0') {
            result = result.substring(1, result.length());
        }
        return result;
    }
}
