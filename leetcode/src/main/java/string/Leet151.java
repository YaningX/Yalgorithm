package string;

import java.util.Stack;

/**
 * Created by xuyaning on 2/1/16.
 */
public class Leet151 {
    public String reverseWords(String s) {
        if(s.length() == 0) {
            return s;
        }
        s = s.trim();
        String[] strings = s.split("\\s+");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < strings.length; i++) {
            stack.push(strings[i]);
        }
        if (stack.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(stack.pop());
        while (!stack.isEmpty()) {
            sb.append(" ");
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public String recReverseWords(String s) {
        s = s.trim();
        return helper(s, 0).toString();
    }

    private StringBuilder helper(String s, int index) {
        StringBuilder cur = new StringBuilder();
        if (index >= s.length()) {
            return cur;
        }

        int lastIndex = index;
        while (index < s.length() && s.charAt(index) != ' ') {
            cur.append(s.charAt(index++));
        }

        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        if (lastIndex == 0) {
            return helper(s, index).append(cur);
        } else {
            return helper(s, index).append(cur).append(' ');
        }
    }
}
