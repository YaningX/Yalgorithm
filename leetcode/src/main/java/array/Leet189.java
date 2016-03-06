package array;

/**
 * Created by xuyaning on 1/2/16.
 */
public class Leet189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (nums.length < 2 || k == 0) {
            return;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        for (int i = start; i <= (start + end) / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[start + end - i];
            nums[start + end - i] = tmp;
        }
    }
}
