package dp;

/**
 * Created by xuyaning on 11/2/16.
 */
public class Leet279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int j = 1;
            while (j * j < i) {
                j++;
            }
            if (j * j == i) {
                dp[i] = 1;
                continue;
            }
            dp[i] = Integer.MAX_VALUE;
            for (int k = 1; k < j; k++) {
                dp[i] = Math.min(dp[i - k * k] + 1, dp[i]);
            }
        }
        return dp[n];
    }
}
