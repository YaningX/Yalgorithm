package lib.knapsack;

import sun.nio.cs.ext.MacHebrew;

/**
 * 多重背包问题
 * http://love-oriented.com/pack/P03.html
 * ---基本解法;
 *    转换为01背包问题;
 *
 */
public class MultipleKnapsack {
    static class Commodity {
        int value;
        int weight;
        public Commodity(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    /**
     * 基本解法
     * @param commodities
     * @param nums
     * @param capacity
     * @return
     */
    public static int multipleKnapsack(Commodity[] commodities, int[] nums, int capacity) {
        int[][] dp = new int[commodities.length + 1][capacity + 1];
        for (int i = 1; i <= commodities.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                Commodity commodity = commodities[i - 1];
                int loop = Math.min(nums[i - 1], j / commodity.weight);
                for (int k = 0; k <= loop; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * commodity.weight] + k * commodity.value);
                }
            }
        }
        return dp[commodities.length][capacity];
    }


    public static void main(String[] args) {
        Commodity[] commodities = new Commodity[4];
        commodities[0] = new Commodity(0, 10);
        commodities[1] = new Commodity(60, 10);
        commodities[2] = new Commodity(100, 20);
        commodities[3] = new Commodity(120, 30);
        System.out.println(MultipleKnapsack.multipleKnapsack(commodities, new int[]{2, 3, 3, 3}, 60));
    }
}
