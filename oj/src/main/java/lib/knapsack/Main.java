package lib.knapsack;

import java.util.*;


public class Main {

    static class Commodity {
        int weight;
        int value;
        public Commodity(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }


    /**
     * 01背包, 不要求“恰好装满”, 二维动态规划
     * @param commodities
     * @param capacity
     * @return
     */
    public static int knapsack1(Commodity[] commodities, int capacity) {
        int[][] dp = new int[commodities.length + 1][capacity + 1];
        for (int i = 1; i <= commodities.length; i++) {
            Commodity commodity = commodities[i - 1];
            for (int j = 1; j <= capacity; j++) {
                if (commodity.weight > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - commodity.weight] + commodity.value);
                }
            }
        }
        return dp[commodities.length][capacity];
    }

    /**
     * 01背包, 不要求“恰好装满”, 一维动态规划
     * @param commodities
     * @param capacity
     * @return
     */
    public static int knapsack2(Commodity[] commodities, int capacity) {
        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= commodities.length; i++) {
            Commodity commodity = commodities[i - 1];
            for (int j = capacity; j >= commodity.weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - commodity.weight] + commodity.value);
            }
        }
        return dp[capacity];
    }

    /**
     * 01背包,"恰好装满"
     * @param commodities
     * @param capacity
     * @return
     */
    public static int knapsack3(Commodity[] commodities, int capacity) {
        int[] dp = new int[capacity + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= commodities.length; i++) {
            Commodity commodity = commodities[i - 1];
            for (int j = capacity; j >= commodity.weight; j--) {
                if (dp[j - commodity.weight] == -1) {
                    continue;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - commodity.weight] + commodity.value);
                }
            }
        }
        return dp[capacity];
    }

    /**
     * 子集和问题,转换为"巧合装满求解"
     * @param nums
     * @param target
     * @return
     */
    public static boolean subsetSum(int[] nums, int target) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= nums[i - 1]; j--) {
                if (!dp[j - nums[i - 1]]) {
                    continue;
                } else {
                    dp[j] = dp[j] || dp[j - nums[i - 1]];
                }
            }
        }
        return dp[target];
    }

    /**
     * subset sum, 不大于target的最大值
     * @param nums
     * @param target
     * @return
     */
    public static int subsetSum1(int[] nums, int target) {
        int[] dp = new int[target + 1];
        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= nums[i - 1]; j--) {
                if (dp[j - nums[i - 1]] + nums[i - 1] > target) {
                    continue;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - nums[i - 1]] + nums[i - 1]);
                }
            }
        }
        return dp[target];
    }

    /**
     * 01背包,输出最优解个数
     * @param commodities
     * @param capacity
     * @return
     */
    public static int knapsack4(Commodity[] commodities, int capacity) {
        int[] dp = new int[capacity + 1];
        int[] count = new int[capacity + 1];
        Arrays.fill(count, 1);
        for (int i = 1; i <= commodities.length; i++) {
            Commodity commodity = commodities[i - 1];
            for (int j = capacity; j >= commodity.weight; j--) {
                if (dp[j] > dp[j - commodity.weight] + commodity.value) {
                    continue;
                } else if (dp[j] < dp[j - commodity.weight] + commodity.value) {
                    dp[j] = dp[j - commodity.weight] + commodity.value;
                    count[j] = count[j - commodity.weight];
                } else if (dp[j] == dp[j - commodity.weight] + commodity.value) {
                    count[j] = count[j] + count[j - commodity.weight];
                }
            }
        }
        return count[capacity];
    }

    /**
     * 01背包,输出所有最优解集合
     * @param commodities
     * @param capacity
     * @return
     */
    public static List<List<Integer>> knapsack5(Commodity[] commodities, int capacity) {
        int[][] dp = new int[commodities.length + 1][capacity + 1];
        for (int i = 1; i <= commodities.length; i++)  {
            Commodity commodity = commodities[i - 1];
            for (int j = 1; j <= capacity; j++) {
                if (commodity.weight > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - commodity.weight] + commodity.value);
                }
            }
        }
        List<List<Integer>> result = getSolutions(dp, commodities);
        return result;
    }

    private static List<List<Integer>> getSolutions(int[][] dp, Commodity[] commodities) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        dfs(dp, commodities, commodities.length, dp[0].length - 1, result, new LinkedList<Integer>());
        return result;
    }

    private static void dfs(int[][] dp, Commodity[] commodities, int i, int j, List<List<Integer>> result, List<Integer> current) {
        if (j == 0) {
            result.add(new LinkedList<Integer>(current));
            return;
        }
        Commodity commodity = commodities[i - 1];
        if (commodity.weight > j) {
            dfs(dp, commodities, i - 1, j, result, current);
            return;
        }
        if (dp[i][j] == dp[i - 1][j] && dp[i][j] != dp[i - 1][j - commodity.weight] + commodity.value) {
            dfs(dp, commodities, i - 1, j, result, current);
        } else if (dp[i][j] != dp[i - 1][j] && dp[i][j] == dp[i - 1][j - commodity.weight] + commodity.value) {
            current.add(0, i);
            dfs(dp, commodities, i - 1, j - commodity.weight, result, current);
            current.remove(0);
        } else if (dp[i][j] == dp[i - 1][j] && dp[i][j] == dp[i - 1][j - commodity.weight] + commodity.value) {
            dfs(dp, commodities, i - 1, j, result, current);
            current.add(0, i);
            dfs(dp, commodities, i - 1, j - commodity.weight, result, current);
            current.remove(0);
        }
    }

    /**
     * 完全背包问题,一维解法
     * @param commodities
     * @param capacity
     * @return
     */
    public static int knapsack6(Commodity[] commodities, int capacity) {
        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= commodities.length; i++) {
            Commodity commodity = commodities[i - 1];
            for (int j = commodity.weight; j <= capacity; j++) {
                dp[j] = Math.max(dp[j], dp[j - commodity.weight] + commodity.value);
            }
        }
        return dp[capacity];
    }

    /**
     * 完全背包问题,基本解法
     * @param commodities
     * @param capacity
     * @return
     */
    public static int knapsack7(Commodity[] commodities, int capacity) {
        int[][] dp = new int[commodities.length + 1][capacity + 1];
        for (int i = 1; i <= commodities.length; i++) {
            Commodity commodity = commodities[i - 1];
            for (int j = commodity.weight; j <= capacity; j++) {
                int k = j / commodity.weight;
                for (int x = 0; x <= k; x++) {
                    dp[i][j] = Math.max(dp[i - 1][j - x * commodity.weight] + x * commodity.value, dp[i][j]);
                }
            }
        }
        return dp[commodities.length][capacity];
    }

    /**
     * 完全背包问题, 求得一组最优解
     * @param commodities
     * @param capacity
     * @return
     */
    public static Map<Integer, Integer> knapsack8(Commodity[] commodities, int capacity) {
        int[][] dp = new int[commodities.length + 1][capacity + 1];
        for (int i = 1; i <= commodities.length; i++) {
            Commodity commodity = commodities[i - 1];
            for (int j = 1; j <= capacity; j++) {
                if (commodity.weight > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - commodity.weight] + commodity.value);
                }
            }
        }
        int i = commodities.length;
        int j = capacity;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (j > 0) {
            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
                j -= commodities[i - 1].weight;
            }
        }
        return map;
    }

    /**
     * 多重背包得基本解法
     * @param commodities
     * @param weights
     * @param capacity
     * @return
     */
    public static int knapsack9(Commodity[] commodities, int[] weights,int capacity) {
        int[][] dp = new int[commodities.length + 1][capacity + 1];
        for (int i = 1; i <= commodities.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                Commodity commodity = commodities[i - 1];
                int k = Math.min(j / commodity.weight, weights[i - 1]);
                for (int x = 0; x <= k; x++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - x * commodity.weight] + x * commodity.value);
                }
            }
        }
        return dp[commodities.length][capacity];
    }

    static class MulCommodity {
        int weigth1, weight2, value;
        public MulCommodity(int weigth1, int weight2, int value) {
            this.weigth1 = weigth1;
            this.weight2 = weight2;
            this.value = value;
        }
    }

    /**
     * 二维费用背包问题,也有二维dp得解法
     * @param commodities
     * @param capacity1
     * @param capacity2
     * @return
     */
    public static int knapsack9(MulCommodity[] commodities, int capacity1, int capacity2) {
        int[][][] dp = new int[commodities.length + 1][capacity1 + 1][capacity2 + 1];
        for (int i = 1; i <= commodities.length; i++) {
            for (int j = 1; j <= capacity1; j++) {
                for (int k = 1; k <= capacity2; k++) {
                    MulCommodity commodity = commodities[i - 1];
                    if (commodity.weigth1 > j || commodity.weight2 > k) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j - commodity.weigth1][k - commodity.weight2] + commodity.value, dp[i - 1][j][k]);
                    }
                }
            }
        }
        return dp[commodities.length][capacity1][capacity2];
    }

    public static void main(String[] args) {
        Commodity[] commodities = new Commodity[5];
        commodities[0] = new Commodity(1, 1);
        commodities[1] = new Commodity(1, 1);
        commodities[2] = new Commodity(2, 3);
        commodities[3] = new Commodity(3, 3);
        commodities[4] = new Commodity(4, 6);
        System.out.println(Main.knapsack1(commodities, 5));
        System.out.println(Main.knapsack2(commodities, 7));
        System.out.println(Main.knapsack3(commodities, 80));
        System.out.println(Main.subsetSum(new int[] {1, 2, 3, 4, 5, 6}, 90));
        System.out.println(Main.subsetSum1(new int[] {1, 2, 30, 4, 5, 6}, 22));
        System.out.println(Main.knapsack4(commodities, 7));
        System.out.println(Main.knapsack5(commodities, 7));
        System.out.println(Main.knapsack6(commodities, 7));
        System.out.println(Main.knapsack7(commodities, 7));
        System.out.println(Main.knapsack8(commodities, 7));
        System.out.println(Main.knapsack9(commodities, new int[] {1, 1, 2, 2, 1}, 10));
        MulCommodity[] mulCommodities = new MulCommodity[5];
        mulCommodities[0] = new MulCommodity(1, 2, 1);
        mulCommodities[1] = new MulCommodity(2, 1, 1);
        mulCommodities[2] = new MulCommodity(2, 3, 3);
        mulCommodities[3] = new MulCommodity(3, 2, 3);
        mulCommodities[4] = new MulCommodity(4, 4, 6);
        System.out.println(Main.knapsack9(mulCommodities, 10, 17));
    }
}
