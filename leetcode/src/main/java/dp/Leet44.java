package dp;


public class Leet44 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (dp[0][i - 1] && p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            }
        }

        for (int j = 1; j <= p.length(); j++) {
            for (int i = 1; i <=s.length(); i++) {
                if (dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')) {
                    dp[i][j] = true;
                } else if (p.charAt(j - 1) == '*') {
                    if (dp[i - 1][j - 1]) {
                        for (int k = i - 1; k <= s.length(); k++) {
                            dp[k][j] = true;
                        }
                    } else if (dp[i][j - 1]) {
                        for (int k = i; k <= s.length(); k++) {
                            dp[k][j] = true;
                        }
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
