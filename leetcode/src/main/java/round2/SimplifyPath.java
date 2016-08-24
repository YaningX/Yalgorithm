package round2;

import java.util.Stack;

/**
 * https://leetcode.com/problems/simplify-path/
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (String str: strs) {
            if (str.equals(".") || str.length() == 0) {
                continue;
            } else if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }
        if (sb.length() == 0) {
            sb.append("/");
        }
        return sb.toString();
    }
}
