package pointer;

/**
 * Created by xuyaning on 18/2/16.
 */
public class Leet26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int left = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[left++] = nums[i];
            }
        }
        return left;
    }
}
