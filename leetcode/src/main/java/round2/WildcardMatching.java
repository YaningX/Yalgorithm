package round2;

/**
 * https://leetcode.com/problems/wildcard-matching/
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                dp[0][i + 1] = true;
            } else {
                break;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if ((s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') && dp[i][j]) {
                    dp[i + 1][j + 1] = true;
                } else if (p.charAt(j) == '*') {
                    if (dp[i][j]) {
                        for (int k = i; k <= s.length(); k++) {
                            dp[k][j + 1] = true;
                        }
                    } else if (dp[i + 1][j]) {
                        for (int k = i + 1; k <= s.length(); k++) {
                            dp[k][j + 1] = true;
                        }
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
