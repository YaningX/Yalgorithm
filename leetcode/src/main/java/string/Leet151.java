package string;

import java.util.Stack;

/**
 * Reverse Words in a String
 */
public class Leet151 {
    public String reverseWords(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return "";
        }
        String[] strs = s.split("\\s+");
        String result = strs[strs.length - 1];
        for (int i = strs.length - 2; i >= 0; i--) {
            result = result + " " + strs[i];
        }
        return result;
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

    public String reverseWords0(String s) {
        String[] strs = s.trim().split("\\s+");
        if (strs.length == 0) {
            return "";
        }
        String result = strs[strs.length - 1];
        for (int i = strs.length - 2; i >= 0; i--) {
            result += (" " + strs[i]);
        }
        return result;
    }
}
