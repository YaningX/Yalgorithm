package dp;

/**
 * Created by xuyaning on 7/3/16.
 */
public class Leet334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3){
            return false;
        }
        int one = nums[0];
        int two = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < one) {
                one = nums[i];
            } else if (nums[i] > one && nums[i] < two) {
                two = nums[i];
            } else if (nums[i] > two) {
                return true;
            }
        }
        return false;
    }
}
