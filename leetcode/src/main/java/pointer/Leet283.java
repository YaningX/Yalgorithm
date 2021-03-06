package pointer;

/**
 * Created by xuyaning on 11/2/16.
 */
public class Leet283 {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        while (slow < nums.length) {
            nums[slow++] = 0;
        }
    }
}
