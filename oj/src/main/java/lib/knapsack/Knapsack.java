package lib.knapsack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 01背包问题
 * 思路详解:http://love-oriented.com/pack/P01.html
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

    /**
     * ----不需要把背包 "恰好装满",空间复杂度高
     * http://love-oriented.com/pack/P01.html
     * time O(NM), space O(NM), N:商品种类,M:空间
     * @param commodities
     * @param capacity
     * @return
     */
    public static int knapsack(Commodity[] commodities, int capacity) {
        int[][] dp = new int[commodities.length + 1][capacity + 1];
        for (int i = 0; i <= commodities.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= capacity; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= commodities.length; i++) {
            Commodity commodity = commodities[i - 1];
            for (int j = 1; j <= capacity; j++) {
                if (commodity.weight > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - commodity.weight] + commodity.value, dp[i - 1][j]);
                }
            }
        }
        return dp[commodities.length][capacity];
    }


    /**
     * 输出一组最优解
     * @param commodities
     * @param capacity
     * @return
     */
    public static List<Integer> knapsack0(Commodity[] commodities, int capacity) {
        int[][] dp = new int[commodities.length + 1][capacity + 1];
        for (int i = 0; i <= commodities.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= capacity; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= commodities.length; i++) {
            Commodity commodity = commodities[i - 1];
            for (int j = 1; j <= capacity; j++) {
                if (j < commodity.weight) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - commodity.weight] + commodity.value);
                }
            }
        }
        int i = commodities.length;
        int j = capacity;
        List<Integer> result = new LinkedList<Integer>();
        while (j > 0) {
            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else {
                result.add(0, i);
                j -= commodities[i - 1].weight;
                i--;
            }
        }
        return result;
    }



    /**
     * ----不需要把背包 "恰好装满",空间被优化
     * @param commodities
     * @param capacity
     * @return
     */
    public static int knapsack1(Commodity[] commodities, int capacity) {
        int[] dp = new int[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            dp[i] = 0;
        }
        for (int i = 0; i < commodities.length; i++) {
            Commodity commodity = commodities[i];
            for (int j = capacity; j > 0; j--) {
                if (commodity.weight > j) {
                    continue;
                } else {
                    dp[j] = Math.max(dp[j - commodity.weight] + commodity.value, dp[j]);
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
        dp[0] = 0;
        for (int i = 1; i <= capacity; i++) {
            dp[i] = -1;
        }
        for (int i = 0; i < commodities.length; i++) {
            Commodity commodity = commodities[i];
            for (int j = capacity; j >= 0; j--) {
                if (commodity.weight <= j && dp[j - commodity.weight] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - commodity.weight] + commodity.value);
                }
            }
        }
        return dp[capacity];
    }

    public  static List<Integer> knapsack20(Commodity[] commodities, int capacity) {
        int[][] dp = new int[commodities.length + 1][capacity + 1];
        for (int i = 0; i <= commodities.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i <= commodities.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= commodities.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                Commodity commodity = commodities[i - 1];
                if (j < commodity.weight || dp[i - 1][j - commodity.weight] == -1) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - commodity.weight]);
                }
            }
        }
        int i = commodities.length;
        int j = capacity;
        List<Integer> result = new LinkedList<Integer>();
        while (j > 0) {
            if (dp[i][j] == dp[i - 1][j] || dp[i][j] == -1) {
                i--;
            } else {
                result.add(i);
                j -= commodities[i - 1].weight;
                i--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Commodity[] commodities = new Commodity[4];
        commodities[0] = new Commodity(0, 0);
        commodities[1] = new Commodity(60, 10);
        commodities[2] = new Commodity(100, 20);
        commodities[3] = new Commodity(120, 30);
        System.out.println(Knapsack.knapsack(commodities, 60));
        System.out.println(Knapsack.knapsack1(commodities, 60));
        System.out.println(Knapsack.knapsack2(commodities, 30));
        System.out.println(Knapsack.knapsack0(commodities, 30));
        System.out.println(Knapsack.knapsack20(commodities, 50));
    }
}
