package lib.knapsack;

public class DiceSum {
    public static int diceSum(int k, int sum) {
        int[][] dp = new int[k + 1][sum + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= sum; j++) {
                for (int x = 1; x <= 6; x++) {
                    if (j - x >= 0) {
                        dp[i][j] += dp[i - 1][j - x];
                    }
                }
            }
        }
        return dp[k][sum];
    }

    public static void main(String[] args) {
        System.out.println(DiceSum.diceSum(2, 9));
    }
}
