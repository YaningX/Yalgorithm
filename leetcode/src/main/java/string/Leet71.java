package string;

import java.util.Stack;

/**
 * Created by xuyaning on 6/1/16.
 */
public class Leet71 {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<String>();
        String[] strings = path.split("/");
        for (String string: strings) {
            if (string.equals("") || string.equals(".")) {
                continue;
            } else if (string.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else{
                    continue;
                }
            } else {
                stack.push(string);
            }
        }

        Stack<String> strStack = new Stack<String>();
        if (!stack.isEmpty()) {
            strStack.push(stack.pop());
        }
        while(!stack.isEmpty()) {
            strStack.push("/");
            strStack.push(stack.pop());
        }
        strStack.push("/");
        while (!strStack.isEmpty()) {
            sb.append(strStack.pop());
        }

        return sb.toString();
    }
}
