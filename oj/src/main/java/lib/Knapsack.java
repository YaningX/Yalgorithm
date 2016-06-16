package lib;

/**
 * 01背包问题
 */
public class Knapsack {

    static class Commodity {
        int value;
        int weight;
        public Commodity(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    public static int knapsack(Commodity[] commodities, int capacity) {
        int[][] dp = new int[commodities.length + 1][capacity + 1];
        for (int i = 0; i <= commodities.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= capacity; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= commodities.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                Commodity commodity = commodities[i - 1];
                if (commodity.weight > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - commodity.weight] + commodity.value, dp[i - 1][j]);
                }
            }
        }
        return dp[commodities.length][capacity];
    }

    public static void main(String[] args) {
        Commodity[] commodities = new Commodity[4];
        commodities[0] = new Commodity(0, 0);
        commodities[1] = new Commodity(60, 10);
        commodities[2] = new Commodity(100, 20);
        commodities[3] = new Commodity(120, 30);
        System.out.println(Knapsack.knapsack(commodities, 50));
    }
}
