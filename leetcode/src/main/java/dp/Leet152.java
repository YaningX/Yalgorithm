package dp;

/**
 * Created by xuyaning on 27/1/16.
 */
public class Leet152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int localMax = nums[0];
        int localMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int localMaxCopy = localMax;
            localMax = Math.max(Math.max(nums[i], nums[i] * localMax), nums[i] * localMin);
            localMin = Math.min(Math.min(nums[i], nums[i] * localMaxCopy), nums[i] * localMin);
            max = Math.max(max, localMax);
        }
        return max;
    }
}
