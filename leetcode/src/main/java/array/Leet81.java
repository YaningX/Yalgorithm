package array;

/**
 * Created by xuyaning on 7/1/16.
 */
public class Leet81 {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        int left = 0, right = nums.length - 1;
        while (left + 1 < nums.length && nums[left] == nums[left + 1]) {
            left++;
        }
        while (right > left && right > 0 && nums[right] == nums[right - 1]) {
            right--;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] >= nums[left]) {
                if (nums[mid] >= target && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
