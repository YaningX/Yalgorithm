package round2;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                result += Math.max(leftMax - height[left], 0);
                leftMax = Math.max(leftMax, height[left]);
                left++;
            } else {
                result += Math.max(rightMax - height[right], 0);
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        return result;
    }
}
