package stack;

import java.util.Stack;

/**
 */
public class Leet32 {
    public int longestValidParentheses(String s) {
        int result = 0;
        if (s == null || s.length() == 0) {
            return result;
        }

        Stack<int[]> stack = new Stack<int[]>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                int[] a = new int[]{i, 0};
                stack.push(a);
            } else {
                if (stack.isEmpty() || stack.peek()[1] == 1) {
                    int[] a = new int[] {i, 1};
                    stack.push(a);
                } else {
                    stack.pop();
                    int currentLen;
                    if (stack.isEmpty()) {
                        currentLen = i + 1;
                    } else {
                        currentLen = i - stack.peek()[0];
                    }
                    result = Math.max(result, currentLen);
                }
            }
        }
        return result;
    }
}
