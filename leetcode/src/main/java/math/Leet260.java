package math;

/**
 * Created by xuyaning on 11/2/16.
 */
public class Leet260 {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }
        int k = 1;
        for (int i = 0; i < 32; i++) {
            if ((xor & k) != 0) {
                break;
            }
            k <<= 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if ((k & nums[i]) == 0) {
                result[0] ^= nums[i];
            } else {
                result[1] ^= nums[i];
            }
        }
        return result;
    }
}
