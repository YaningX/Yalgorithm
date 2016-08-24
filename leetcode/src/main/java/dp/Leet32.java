package dp;

/**
 * http://blog.csdn.net/cfc1243570631/article/details/9304525
 */
public class Leet32 {
    public int longestValidParentheses(String s) {
        int result = 0;
        int[] dp = new int[s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '(' && i < s.length() - 1) {
                int j = i + 1 + dp[i + 1];
                if (j < s.length() && s.charAt(j) == ')') {
                    dp[i] = dp[i + 1] + 2;
                    if (j + 1 < s.length()) {
                        dp[i] += dp[j + 1];
                    }
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
