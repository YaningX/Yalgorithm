package sort;

/**
 * Created by xuyaning on 3/2/16.
 */
public class Leet215 {
    public int findKthLargest(int[] nums, int k) {
        return findKthMin(nums, nums.length - k, 0, nums.length - 1);
    }

    //k starts from 0, 1, 2,...
    private int findKthMin(int[] nums, int k, int left, int right) {
        int i = partition(nums, left, right);
        if (i == k) {
            return nums[i];
        } else if (i > k) {
            return findKthMin(nums, k, left, i - 1);
        } else {
            return findKthMin(nums, k, i + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int low = left;
        for (int i = left; i < right; i ++) {
            if (nums[i] <= nums[right]) {
                int tmp = nums[i];
                nums[i] = nums[low];
                nums[low++] = tmp;
            }
        }
        int tmp = nums[low];
        nums[low] = nums[right];
        nums[right] = tmp;
        return low;
    }
}
