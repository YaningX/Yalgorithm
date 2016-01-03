package dp;

/**
 * Created by xuyaning on 3/1/16.
 */
public class Leet64 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int[][] dp = new int[grid.length][grid[0].length];
        int m = grid.length;
        int n = grid[0].length;
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
