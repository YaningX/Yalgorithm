package math;

/**
 * Created by xuyaning on 11/2/16.
 */
public class Leet268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        int sum1 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += nums[i];
        }
        return sum - sum1;
    }
}
