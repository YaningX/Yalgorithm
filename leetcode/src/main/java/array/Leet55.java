package array;

/**
 * Created by xuyaning on 29/12/15.
 */
public class Leet55 {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int max = nums[0];
        int i = 1;
        while (max >= i && i < nums.length) {
            max = Math.max(max, nums[i] + i);
            if (max >= nums.length - 1) {
                return true;
            }
            i++;
        }
        return false;
    }
}
