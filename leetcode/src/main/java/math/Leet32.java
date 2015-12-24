package math;


import java.util.Stack;

public class Leet32 {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int max = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[max]) {
                max = i;
            }
        }
        return leftTrap(height, max) + rightTrap(height, max);
    }

    private int leftTrap(int[] height, int max) {
        int leftResult = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        for (int i = 1; i < max; i++) {
            if (height[stack.peek()] < height[i]) {
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            int leftBound = stack.pop();
            for (int i = leftBound + 1; i < max; i++) {
                leftResult = leftResult + height[leftBound] - height[i];
            }
            max = leftBound;
        }

        return leftResult;
    }

    private int rightTrap(int[] height, int max) {
        int rightResult = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(height.length - 1);
        for (int i = height.length - 2; i > max; i--) {
            if (height[stack.peek()] < height[i]) {
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            int rightBound = stack.pop();
            for (int i = max + 1; i < rightBound; i++) {
                rightResult = rightResult + height[rightBound] - height[i];
            }
            max = rightBound;
        }
        return rightResult;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 0, 3, 2, 5};
        System.out.println(new Leet32().trap(nums));
    }
}
