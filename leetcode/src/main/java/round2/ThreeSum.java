package round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(nums, i, result);
        }
        return result;
    }

    private void twoSum(int[] nums, int start, List<List<Integer>> result) {
        int left = start + 1;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[start] + nums[left] + nums[right];
            if (sum == 0) {
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(nums[start]);
                tmp.add(nums[left]);
                tmp.add(nums[right]);
                result.add(tmp);
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }
}
