package dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by xuyaning on 26/1/16.
 */
public class Leet140 {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String>[] dp = new List[s.length() + 1];
        dp[0] = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            if (dp[i] == null) {
                continue;
            }
            for (String word: wordDict) {
                int end = i + word.length();
                if (end <= s.length()) {
                    String str = s.substring(i, end);
                    if (str.equals(word)) {
                        if (dp[end] == null) {
                            dp[end] = new ArrayList<String>();
                        }
                        dp[end].add(str);
                    }
                }
            }
        }
        if (dp[s.length()] == null) {
            return new ArrayList<String>();
        }
        List<String> result = new ArrayList<String>();
        dfs(dp, result, "", s.length());
        return result;
    }

    private void dfs(List<String>[] dp, List<String> result, String current, int end) {
        if (end <= 0) {
            current = current.substring(1, current.length());
            result.add(current);
            return;
        }
        for (String str: dp[end]) {
            dfs(dp, result, " " + str + current, end - str.length());
        }
    }
}
