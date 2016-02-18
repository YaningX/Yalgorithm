package dp;

/**
 * Created by xuyaning on 17/2/16.
 */
public class Leet10 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*' && dp[0][i - 2]) {
                dp[0][i] = true;
            }
        }
        for (int j = 1; j <= p.length(); j++) {
            for (int i = 1; i <= s.length(); i++) {
                if (dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                    dp[i][j] = true;
                } else if (p.charAt(j - 1) == '*') {
                    if (dp[i - 1][j - 1]) {
                        int k = i;
                        while (k <= s.length() && (s.charAt(k - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            dp[k][j] = true;
                            k++;
                        }
                    }
                    if (dp[i][j - 1] || dp[i][j - 2]) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
