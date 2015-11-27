package array;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].

Key idea: binary search
 */
public class Leet34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result[] = {-1, -1};
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                int low = mid;
                int high = mid;
                while (low >= 0 && nums[low] == target) {
                    low--;
                }
                low++;
                while (high <= nums.length - 1 && nums[high] == target) {
                    high++;
                }
                high--;
                result[0] = low;
                result[1] = high;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
