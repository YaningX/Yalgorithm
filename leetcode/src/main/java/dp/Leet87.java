package dp;

/**
 * https://leetcode.com/problems/scramble-string/
 */
public class Leet87 {
    public boolean isScramble(String s1, String s2) {
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
                        if ((dp[m][i][j] && dp[k - m][i + m][j + m]) || (dp[m][i][j + k - m] && dp[k - m][i + m][j])) {
                            dp[k][i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[len][1][1];
    }

    public boolean isScramble1(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 != n2) {
            return false;
        }
        int len = 128;
        int[] c1 = new int[len];
        int[] c2 = new int[len];
        for (int i = 0; i < n1; i++) {
            c1[s1.charAt(i)]++;
            c2[s2.charAt(i)]++;
        }
        for (int i = 0; i < len; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        for (int i = 1; i < n1; i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);
            String s23 = s2.substring(n2 - i);
            String s24 = s2.substring(0, n2 - i);
            if ((isScramble(s11, s21) && isScramble(s12, s22))
                    || (isScramble(s11, s23) && isScramble(s12, s24))) {
                return true;
            }
        }
        return false;
    }
}
