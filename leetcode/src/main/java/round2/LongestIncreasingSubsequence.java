package round2;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (tails[right] < nums[i]) {
                tails[++right] = nums[i];
            } else {
                tails[find(tails, right, nums[i])] = nums[i];
            }
        }
        return right + 1;
    }

    private int find(int[] tails, int right, int target) {
        int left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (tails[mid] == target) {
                return mid;
            } else if (target < tails[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
