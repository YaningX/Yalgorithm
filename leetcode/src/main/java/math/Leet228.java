package math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuyaning on 10/2/16.
 */
public class Leet228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums.length == 0) {
            return result;
        }
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != end +1) {
                if (start == end) {
                    result.add("" + start);
                } else {
                    result.add("" + start + "->" + end);
                }
                start = nums[i];
            }
            end = nums[i];
        }
        if (start == end) {
            result.add("" + start);
        } else {
            result.add("" + start + "->" + end);
        }
        return result;
    }
}
