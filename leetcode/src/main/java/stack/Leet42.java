package stack;

import java.util.Stack;

/**
 * Created by xuyaning on 20/2/16.
 */
public class Leet42 {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[max]) {
                max = i;
            }
        }
        int result = leftTrap(height, max) + rightTrap(height, max);
        return result;
    }

    private int leftTrap(int[] height, int max) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        for (int i = 1; i < max; i++) {
            if (height[stack.peek()] < height[i]) {
                stack.push(i);
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            int left = stack.pop();
            for (int i = left + 1; i < max; i++) {
                result += (height[left] - height[i]);
            }
            max = left;
        }
        return result;
    }

    private int rightTrap(int[] height, int max) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(height.length - 1);
        for (int i = height.length - 2; i > max; i--) {
            if (height[stack.peek()] < height[i]) {
                stack.push(i);
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            int right = stack.pop();
            for (int i = right - 1; i > max; i--) {
                result += (height[right] - height[i]);
            }
            max = right;
        }
        return result;
    }
}
