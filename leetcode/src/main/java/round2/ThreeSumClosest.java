package round2;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int d = nums[i] + nums[left] + nums[right] - target;
                if (d == 0) {
                    return target;
                } else if (d < 0) {
                    if (-d < diff) {
                        diff = -d;
                        result = d + target;
                    }
                    left++;
                } else {
                    if (d < diff) {
                        diff = d;
                        result = d + target;
                    }
                    right--;
                }
            }
        }
        return result;
    }

    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int d = nums[i] + nums[left] + nums[right] - target;
                if (d == 0) {
                    return target;
                } else if (d < 0) {
                    if (-d < Math.abs(diff)) {
                        diff = d;
                    }
                    left++;
                } else {
                    if (d < Math.abs(diff)) {
                        diff = d;
                    }
                    right--;
                }
            }
        }
        return diff + target;
    }
}
