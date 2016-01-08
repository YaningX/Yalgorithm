package dp;

/**
 * Created by xuyaning on 8/1/16.
 */
public class Leet87 {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int len = s1.length();
        if (len == 0) {
            return true;
        }

        boolean[][][] dp = new boolean[len + 1][len + 1][len + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[1][i][j] = true;
                }
            }
        }

        for (int k = 2; k <= len; k++) {
            for (int i = len - k + 1; i >= 1; i--) {
                for (int j = len - k + 1; j >= 1; j--) {
                    for (int m = 1; m < k; m++) {
                        if ((dp[m][i][j] && dp[k - m][i + m][j + m]) || (dp[m][i][j + k -m] && dp[k - m][i + m][j])) {
                            dp[k][i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[len][1][1];
    }
}
