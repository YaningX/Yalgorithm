package round2;

import java.util.Stack;

/**
 * https://leetcode.com/problems/maximal-rectangle/
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int max = 0;
        int[] heights = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j]++;
                }
            }
            max = Math.max(max, largestRectangle(heights));
        }
        return max;
    }

    private int largestRectangle(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }

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
