package math;

import java.util.*;

/**
 * Created by xuyaning on 17/2/16.
 */
public class Leet15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            twoSum(nums, i, result);
        }
        return new ArrayList<List<Integer>>(result);
    }

    private void twoSum(int[] nums, int start, Set<List<Integer>> result) {
        int target = -nums[start];
        Set<Integer> set = new HashSet<Integer>();
        for (int i = start + 1; i < nums.length; i++) {
            if (set.contains(target - nums[i])) {
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(nums[start]);
                tmp.add(target - nums[i]);
                tmp.add(nums[i]);
                result.add(tmp);
            } else {
                set.add(nums[i]);
            }
        }
    }
}
