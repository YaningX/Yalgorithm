package bsearch;

/**
 * Created by xuyaning on 27/1/16.
 */
public class Leet154 {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right && nums[left] == nums[right]) {
            right--;
        }
        if (left == right) {
            return nums[left];
        }
        while (nums[left] > nums[right]) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
