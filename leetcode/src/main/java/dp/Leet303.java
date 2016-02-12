package dp;

/**
 * Created by xuyaning on 12/2/16.
 */
public class Leet303 {
    public class NumArray {
        private int[] sum;
        public NumArray(int[] nums) {
            sum = new int[nums.length];
            for (int i = 0; i < sum.length; i++) {
                if (i == 0) {
                    sum[i] = nums[0];
                } else {
                    sum[i] = sum[i - 1] + nums[i];
                }
            }
        }

        public int sumRange(int i, int j) {
            if (i == 0) {
                return sum[j];
            } else {
                return sum[j] - sum[i - 1];
            }
        }
    }
}
