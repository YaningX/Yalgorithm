package math;

import java.util.Stack;

/**
 * Created by xuyaning on 8/1/16.
 */
public class Leet85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    height[j] = 0;
                } else {
                    height[j] += 1;
                }
            }
            maxArea = Math.max(largestRectangleArea(height), maxArea);
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] height) {
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        while (i < height.length) {
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i);
                i++;
            } else {
                int p = stack.pop();
                int h = height[p];
                int w = stack.isEmpty()? i: i - stack.peek() - 1;
                max = Math.max(h * w, max);
            }
        }

        while (!stack.isEmpty()) {
            int p = stack.pop();
            int h = height[p];
            int w = stack.isEmpty()? i: i - stack.peek() - 1;
            max = Math.max(h * w, max);
        }

        return max;
    }
}
