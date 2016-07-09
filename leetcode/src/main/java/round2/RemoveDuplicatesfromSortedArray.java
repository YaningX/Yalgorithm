package round2;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int end = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[end] < nums[i]) {
                nums[++end] = nums[i];
            }
        }
        return end + 1;
    }
}
