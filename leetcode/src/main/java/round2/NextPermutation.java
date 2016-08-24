package round2;

/**
 * https://leetcode.com/problems/next-permutation/.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int p = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                p = i;
                break;
            }
        }
        int q = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[p]) {
                q = i;
                break;
            }
        }
        if (p == 0 && q == 0) {
            reverse(nums, 0, nums.length - 1);
        } else {
            int tmp = nums[p];
            nums[p] = nums[q];
            nums[q] = tmp;
            reverse(nums, p + 1, nums.length - 1);
        }
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}
