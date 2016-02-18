package dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xuyaning on 17/2/16.
 */
public class Leet17 {
    public class Solution {
        String[] dict = {
                " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        public List<String> letterCombinations(String digits) {
            List<String> result = new LinkedList<String>();
            if (digits.length() == 0) {
                return result;
            }
            dfs(digits, 0, "", result);
            return result;
        }

        private void dfs(String digits, int start, String cur, List<String> result) {
            if (digits.length() == start) {
                result.add(cur);
                return;
            }
            String str = dict[digits.charAt(start) - '0'];
            for (int i = 0; i < str.length(); i++) {
                dfs(digits, start + 1, cur + str.charAt(i), result);
            }
        }
    }
}
