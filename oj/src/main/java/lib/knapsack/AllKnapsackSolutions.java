package lib.knapsack;

import sun.nio.cs.ext.MacHebrew;

import java.util.*;

/**
 *
 */
public class AllKnapsackSolutions {

    static class Commodity {
        int value;
        int weight;
        public Commodity(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    /**
     * 输出所有最优解的总量, 可以用1维来做
     * @param commodities
     * @param capacity
     * @return
     */
    public static int knapsack(Commodity[] commodities, int capacity) {
        int[][] dp = new int[commodities.length + 1][capacity + 1];
        int[][] g = new int[commodities.length + 1][capacity + 1];
        for (int i = 0; i <= commodities.length; i++) {
            Arrays.fill(g[i], 1);
        }
        for (int i = 1; i <= commodities.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                Commodity commodity = commodities[i - 1];
                if (j < commodity.weight) {
                    dp[i][j] = dp[i - 1][j];
                    g[i][j] = g[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - commodity.weight] + commodity.value);
                    if (dp[i][j] == dp[i - 1][j] && dp[i][j] != dp[i - 1][j - commodity.weight] + commodity.value) {
                        g[i][j] = g[i - 1][j];
                    } else if (dp[i][j] != dp[i - 1][j] && dp[i][j] == dp[i - 1][j - commodity.weight] + commodity.value) {
                        g[i][j] = g[i - 1][j - commodity.weight];
                    } else if (dp[i][j] == dp[i - 1][j] && dp[i][j] == dp[i - 1][j - commodity.weight] + commodity.value) {
                        g[i][j] = g[i - 1][j] + g[i - 1][j - commodity.weight];
                    }
                }

            }
        }
        return g[commodities.length][capacity];
    }

    public static List<List<Integer>> knapsack0(Commodity[] commodities, int capacity) {
        int[][] dp = new int[commodities.length + 1][capacity + 1];
        int[][] g = new int[commodities.length + 1][capacity + 1];
        for (int i = 0; i <= commodities.length; i++) {
            Arrays.fill(g[i], 1);
        }
        for (int i = 1; i <= commodities.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                Commodity commodity = commodities[i - 1];
                if (j < commodity.weight) {
                    dp[i][j] = dp[i - 1][j];
                    g[i][j] = g[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - commodity.weight] + commodity.value);
                    if (dp[i][j] == dp[i - 1][j] && dp[i][j] != dp[i - 1][j - commodity.weight] + commodity.value) {
                        g[i][j] = g[i - 1][j];
                    } else if (dp[i][j] != dp[i - 1][j] && dp[i][j] == dp[i - 1][j - commodity.weight] + commodity.value) {
                        g[i][j] = g[i - 1][j - commodity.weight];
                    } else if (dp[i][j] == dp[i - 1][j] && dp[i][j] == dp[i - 1][j - commodity.weight] + commodity.value) {
                        g[i][j] = g[i - 1][j] + g[i - 1][j - commodity.weight];
                    }
                }

            }
        }
        return getSolutions(dp, commodities);
    }

    public static List<List<Integer>> getSolutions(int[][] dp, Commodity[] commodities) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        dfs(dp, commodities, result, new LinkedList<Integer>(), dp.length - 1, dp[0].length - 1);
        return result;
    }


    public static void dfs(int[][] dp, Commodity[] commodities, List<List<Integer>> result, List<Integer> current, int i, int j) {
        if (j == 0) {
            result.add(new ArrayList<Integer>(current));
            return;
        }

        Commodity commodity = commodities[i - 1];
        if (commodity.weight > j) {
            dfs(dp, commodities, result, current, i - 1, j);
            return;
        }
        if (dp[i][j] == dp[i - 1][j] && dp[i][j] != dp[i - 1][j - commodity.weight] + commodity.value) {
            dfs(dp, commodities, result, current, i - 1, j);
        } else if (dp[i][j] != dp[i - 1][j] && dp[i][j] == dp[i - 1][j - commodity.weight] + commodity.value) {
            current.add(0, i);
            dfs(dp, commodities, result, current, i - 1, j - commodity.weight);
            current.remove(0);
        } else if (dp[i][j] == dp[i - 1][j] && dp[i][j] == dp[i - 1][j - commodity.weight] + commodity.value) {
            dfs(dp, commodities, result, current, i - 1, j);
            current.add(0, i);
            dfs(dp, commodities, result, current, i - 1, j - commodity.weight);
            current.remove(0);
        }
    }


    public static void main(String[] args) {
        Commodity[] commodities = new Commodity[5];
        commodities[0] = new Commodity(50, 10);
        commodities[1] = new Commodity(50, 10);
        commodities[2] = new Commodity(100, 20);
        commodities[3] = new Commodity(120, 30);
        commodities[4] = new Commodity(100, 20);
        System.out.println(AllKnapsackSolutions.knapsack(commodities, 20));
        System.out.println(AllKnapsackSolutions.knapsack0(commodities, 20));
    }
}
