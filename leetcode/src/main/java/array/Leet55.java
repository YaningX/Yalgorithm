package array;

/**
 * Created by xuyaning on 29/12/15.
 */
public class Leet55 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }

        int maxReach = nums[0];
        int index = 0;
        while (index <= maxReach) {
            if (index + nums[index] > maxReach) {
                maxReach = index + nums[index];
            }
            index++;
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
