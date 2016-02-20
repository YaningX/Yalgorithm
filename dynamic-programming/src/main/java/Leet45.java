/**
 * Created by xuyaning on 24/12/15.
 */
public class Leet45 {
    public int jump(int[] nums) {
        int currentMax = 0;
        int result = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (currentMax < i) {
                result++;
                currentMax = max;
            }
            max = Math.max(max, nums[i] + i);
        }
        return result;
    }
}
