package round2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new LinkedList<String>();
        }
        String[] dict = new String[] {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> queue = new LinkedList<String>();
        queue.offer("");
        for (int i = 0; i < digits.length(); i++) {
            int ch = digits.charAt(i) - '0';
            if (ch == 1) {
                continue;
            }
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String s = queue.poll();
                for (int k = 0; k < dict[ch].length(); k++) {
                    queue.offer(s + dict[ch].charAt(k));
                }
            }
        }
        return new LinkedList<String>(queue);
    }

    public List<String> letterCombinations2(String digits) {
        return dfs(digits);
    }

    private List<String> dfs(String digits) {
        List<String> result = new LinkedList<String>();
        if (digits.length() == 0) {
            return result;
        }
        String[] dict = new String[] {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> post = dfs(digits.substring(1));
        String s = dict[digits.charAt(0) - '0'];
        if (s.length() == 0) {
            return post;
        }
        for (char ch: s.toCharArray()) {
            if (post.size() == 0) {
                result.add(ch + "");
            } else {
                for (String str: post) {
                    result.add(ch + str);
                }
            }
        }
        return result;
    }
}
