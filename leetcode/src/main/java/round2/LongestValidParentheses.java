package round2;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {

    /**
     * dp[i]:表示包含s.charAt(i)在内的最长合法括号序列
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = s.length() - 2; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '(') {
                int j = i + 1 + dp[i + 1];
                if (s.charAt(j) == ')') {
                    dp[i] = dp[j] + 2;
                }
                if (j + 1 < s.length() && s.charAt(j + 1) == '(') {
                    dp[i] = dp[j + 1];
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
