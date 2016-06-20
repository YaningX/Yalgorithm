package lib.knapsack;

/**
 * 完全背包问题
 * http://love-oriented.com/pack/P02.html
 * 解法:
 *      1) 基本解法
 *      2) 转换为01背包问题
 *      3) 优化后解法
 */
public class CompleteKnapsack {

    static class Commodity {
        int value;
        int weight;
        public Commodity(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    /**
     * 不需要把背包 "恰好装满",空间复杂度高
     * @param commodities
     * @param capacity
     * @return
     */
    public static int knapsack(Commodity[] commodities, int capacity) {
        int[][] dp = new int[commodities.length + 1][capacity + 1];
        for (int i = 1; i <= commodities.length; i++) {
            Commodity commodity = commodities[i - 1];
            for (int j = 1; j <= capacity; j++) {
                if (j < commodity.weight) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - commodity.weight] + commodity.value);
                }
            }
        }
        return dp[commodities.length][capacity];
    }

    /**
     * ----不需要把背包 "恰好装满",空间被优化
     * @param commodities
     * @param capacity
     * @return
     */
    public static int knapsack1(Commodity[] commodities, int capacity) {
        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= commodities.length; i++) {
            Commodity commodity = commodities[i - 1];
            for (int j = 1; j <= capacity; j++) {
                if (j < commodity.weight) {
                    continue;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - commodity.weight] + commodity.value);
                }
            }
        }
        return dp[capacity];
    }

    /**
     * "恰好装满",空间被优化
     * @param commodities
     * @param capacity
     * @return
     */
    public static int knapsack2(Commodity[] commodities, int capacity) {
        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= capacity; i++) {
            dp[i] = -1;
        }
        for (int i = 1; i <= commodities.length; i++) {
            Commodity commodity = commodities[i - 1];
            for (int j = 1; j <= capacity; j++) {
                if (j < commodity.weight || dp[j - commodity.weight] < 0) {
                    continue;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - commodity.weight] + commodity.value);
                }
            }
        }
        return dp[capacity];
    }

    public static void main(String[] args) {
        Commodity[] commodities = new Commodity[4];
        commodities[0] = new Commodity(0, 0);
        commodities[1] = new Commodity(30, 10);
        commodities[2] = new Commodity(100, 20);
        commodities[3] = new Commodity(190, 30);
        System.out.println(CompleteKnapsack.knapsack(commodities, 70));
        System.out.println(CompleteKnapsack.knapsack1(commodities, 70));
        System.out.println(CompleteKnapsack.knapsack2(commodities, 80));
    }

}
