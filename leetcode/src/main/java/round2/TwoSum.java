package round2;

import java.util.HashMap;
import java.util.Map;

/**
 * time O(n), space O(n)
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[] {map.get(diff), nums[i]};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
