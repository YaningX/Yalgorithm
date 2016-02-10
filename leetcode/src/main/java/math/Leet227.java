package math;

import java.util.Collections;
import java.util.Stack;

/**
 * Created by xuyaning on 10/2/16.
 */
public class Leet227 {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int cur = ch - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    cur = 10 * cur + s.charAt(i + 1) - '0';
                    i++;
                }
                stack.push(cur);
            } else if (ch == '+') {
                stack.push(0);
            } else if (ch == '-') {
                stack.push(1);
            } else if (ch == '*') {
                i++;
                ch = s.charAt(i);
                int cur = ch - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    cur = 10 * cur + s.charAt(i + 1) - '0';
                    i++;
                }
                stack.push(stack.pop() * cur);
            } else if (ch == '/') {
                i++;
                ch = s.charAt(i);
                int cur = ch - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    cur = 10 * cur + s.charAt(i + 1) - '0';
                    i++;
                }
                stack.push(stack.pop() / cur);
            }
        }
        Collections.reverse(stack);
        int result = stack.pop();
        while (!stack.isEmpty()) {
            if (stack.pop() == 0) {
                result += stack.pop();
            } else {
                result -= stack.pop();
            }
        }
        return result;
    }
}
