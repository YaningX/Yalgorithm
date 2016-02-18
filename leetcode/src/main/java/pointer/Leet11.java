package pointer;

/**
 * Created by xuyaning on 17/2/16.
 */
public class Leet11 {
    public int maxArea(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[right], height[left]) * (right - left);
            result = Math.max(result, area);
            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
