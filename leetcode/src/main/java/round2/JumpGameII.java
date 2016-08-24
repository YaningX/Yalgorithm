package round2;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGameII {

    public int jump(int[] nums) {
        int result = 0;
        int max = 0;
        int currentMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (currentMax < i) {
                currentMax = max;
                result++;
            }
            max = Math.max(max, i + nums[i]);
        }
        return result;
    }
}
