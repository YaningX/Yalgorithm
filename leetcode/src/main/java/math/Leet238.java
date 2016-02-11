package math;

/**
 * Created by xuyaning on 11/2/16.
 */
public class Leet238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        if (result.length == 0) {
            return result;
        }
        result[0] = 1;
        int product = 1;
        for (int i = 1; i < nums.length; i++) {
            product *= nums[i - 1];
            result[i] = product;
        }
        product = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            product *= nums[i];
            result[i - 1] *= product;
        }
        return result;
    }
}
