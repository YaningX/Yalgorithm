package round2;

import java.util.*;

/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 * 典型的BFS,最坏情况O(2^n)
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> queue = new LinkedList<String>();
        Set<String> set = new HashSet<String>();
        List<String> result = new LinkedList<String>();
        queue.offer(s);
        set.add(s);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (isValid(str)) {
                    result.add(str);
                } else if (result.isEmpty()) {
                    for (int j = 0; j < str.length(); j++) {
                        char ch = str.charAt(j);
                        if (ch == '(' || ch == ')') {
                            String st = str.substring(0, j) + str.substring(j + 1, str.length());
                            if (!set.contains(st)) {
                                queue.offer(st);
                                set.add(st);
                            }
                        }
                    }
                }
            }
            if (!result.isEmpty()) {
                break;
            }
        }
        return result;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                count++;
            }
            if (ch == ')' && count-- == 0) {
                return false;
            }
        }
        return count == 0;
    }
}
