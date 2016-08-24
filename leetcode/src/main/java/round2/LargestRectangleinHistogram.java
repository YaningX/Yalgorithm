package round2;

import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        while (i < heights.length) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
                i++;
            } else {
                int p = stack.pop();
                int h = heights[p];
                int w = stack.isEmpty()? i: i - 1 - stack.peek();
                max = Math.max(max, w * h);
            }
        }

        while (!stack.isEmpty()) {
            int p = stack.pop();
            int h = heights[p];
            int w = stack.isEmpty()? i: i - 1 - stack.peek();
            max = Math.max(max, w * h);
        }
        return max;
    }
}
