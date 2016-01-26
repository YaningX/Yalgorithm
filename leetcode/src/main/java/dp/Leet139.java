package dp;

import java.util.Set;

/**
 * Created by xuyaning on 25/1/16.
 */
public class Leet139 {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (!dp[i]) {
                continue;
            }
            for (String word: wordDict) {
                int end = i + word.length();
                if (end <= s.length()) {
                    if (s.substring(i, end).equals(word)) {
                        dp[end] = true;
                    }
                }
            }
        }
        return dp[s.length()];
    }
}
