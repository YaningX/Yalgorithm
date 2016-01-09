package dp;

/**
 * Created by xuyaning on 9/1/16.
 */
public class Leet91 {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (valid(s.charAt(i - 1))) {
                dp[i] = dp[i - 1];
            }

            if (valid(s.charAt(i - 2), s.charAt(i - 1))) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }

    private boolean valid(char ch) {
        return ch != '0'? true: false;
    }

    private boolean valid(char ch1, char ch2) {
        return (ch1 == '1' || (ch1 == '2' && ch2 >= '0' && ch2 <= '6'));
    }
}
