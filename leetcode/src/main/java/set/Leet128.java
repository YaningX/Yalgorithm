package set;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xuyaning on 24/1/16.
 */
public class Leet128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        for(int num: nums) {
            int count = 1;
            int left = num - 1;
            int right = num + 1;
            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }
            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
