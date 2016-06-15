package round2;


import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char chr = stack.pop();
                if (ch == ')' && chr != '(') {
                    return false;
                }
                if (ch == ']' && chr != '[') {
                    return false;
                }
                if (ch == '}' && chr != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
