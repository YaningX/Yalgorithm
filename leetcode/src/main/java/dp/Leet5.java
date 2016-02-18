package dp;

/**
 * Created by xuyaning on 13/2/16.
 */
public class Leet5 {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int start = 0;
        int len = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                len = 2;
            }
        }
        for (int i = 3; i <= s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                if (s.charAt(j) == s.charAt(j + i - 1) && dp[j + 1][j + i -  2]) {
                    dp[j][j + i - 1] = true;
                    start = j;
                    len = i;
                }
            }
        }
        return s.substring(start, start + len);
    }
}
