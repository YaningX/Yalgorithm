package math;

import java.util.Stack;

/**
 * Largest Rectangle in Histogram
 */
public class Leet84 {
    public int largestRectangleArea(int[] height) {
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        while (i < height.length) {
            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int p = stack.pop();
                int h = height[p];
                int w = stack.isEmpty()? i: i - 1 - stack.peek();//栈里面所有的元素值都小于等于height[i - 1]
                max = Math.max(h * w, max);
            }
        }

        while (!stack.isEmpty()) {
            int p = stack.pop();
            int h = height[p];
            int w = stack.isEmpty()? i: i - 1 - stack.peek();
            max = Math.max(h * w, max);
        }
        return max;
    }
}
