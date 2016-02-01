package map;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xuyaning on 1/2/16.
 */
public class Leet217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                return true;
            }
        }
        return false;
    }
}
