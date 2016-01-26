package dfs;

import java.util.Set;

/**
 * Created by xuyaning on 25/1/16.
 */
public class Leet139 {
    //会超时,应该用动态规划
    public boolean wordBreak(String s, Set<String> wordDict) {
        return dfs(s, wordDict);
    }

    private boolean dfs(String s, Set<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }
        for (String word: wordDict) {
            if (s.startsWith(word)) {
                if (dfs(s.substring(word.length(), s.length()), wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }
}
