package stack;

import java.util.Stack;

/**
 * Created by xuyaning on 27/1/16.
 */
public class Leet150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                stack.push(Integer.valueOf(stack.pop()) + Integer.valueOf(stack.pop()));
            } else if (tokens[i].equals("-")) {
                stack.push(-1 * Integer.valueOf(stack.pop()) + Integer.valueOf(stack.pop()));
            } else if (tokens[i].equals("*")) {
                stack.push(Integer.valueOf(stack.pop()) * Integer.valueOf(stack.pop()));
            } else if (tokens[i].equals("/")) {
                int divisor = Integer.valueOf(stack.pop());
                stack.push(Integer.valueOf(stack.pop()) / divisor);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
