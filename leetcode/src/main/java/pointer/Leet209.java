package pointer;

/**
 * Created by xuyaning on 2/2/16.
 */
public class Leet209 {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while (left < nums.length && right < nums.length) {
            while (sum < s && right < nums.length) {
                sum += nums[right++];
            }
            while (sum >= s && left < nums.length) {
                min = Math.min(min, right - left);
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE? 0: min;
    }
}
