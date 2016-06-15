package dp;

/**
 * http://blog.csdn.net/cfc1243570631/article/details/9304525
 */
public class Leet32 {
    public int longestValidParentheses(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int result = 0;
        int[] dp = new int[s.length()];
        dp[s.length() - 1] = 0;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                int j = i + 1 + dp[i + 1];
                if (j < s.length() && s.charAt(j) == ')') {
                    dp[i] = dp[i + 1] + 2;
                    if (j + 1 < s.length()) {
                        dp[i] += dp[j + 1];
                    }
                }
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }
}
