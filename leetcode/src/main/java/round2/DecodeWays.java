package round2;

/**
 * https://leetcode.com/problems/decode-ways/
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (isValid(s.charAt(i - 1))) {
                dp[i] = dp[i - 1];
            }
            if (isValid(s.charAt(i - 2), s.charAt(i - 1))) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

    private boolean isValid(char ch) {
        return ch != '0';
    }

    private boolean isValid(char ch1, char ch2) {
        return (ch1 == '1' || (ch1 == '2' && (ch2 >= '0' && ch2 <= '6')));
    }
}
