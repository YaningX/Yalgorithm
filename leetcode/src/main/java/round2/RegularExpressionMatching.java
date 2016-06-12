package round2;

/**
 * Created by xuyaning on 4/6/16.
 */
public class RegularExpressionMatching {
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
                char chs = s.charAt(i - 1);
                char chp = p.charAt(j - 1);
                if (dp[i - 1][j - 1] && (chs == chp || chp == '.')) {
                    dp[i][j] = true;
                } else if (chp == '*') {
                    if (dp[i - 1][j - 1]) {
                        int k = i;
                        while (k <= s.length() && (s.charAt(k - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            dp[k++][j] = true;
                        }
                    }
                    dp[i][j] = dp[i][j - 1] || dp[i][j - 2];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public boolean isMatch0(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            dp[0][i] = p.charAt(i - 1) == '*' && dp[0][i - 2];
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        //匹配0个, 1个, 多个
                        dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        //匹配0个
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
