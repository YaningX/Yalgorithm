package lib.knapsack;

import java.util.LinkedList;
import java.util.List;

/**
 * 子集和问题
 */
public class SubsetSum {

    /**
     * 转换为01背包中的"恰好装满背包"问题
     * @param nums
     * @param target
     * @return
     */
    public static boolean subsetSum0(int[] nums, int target) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j >= 1; j--) {
                if (j < nums[i - 1] || !dp[j - nums[i - 1]]) {
                    dp[j] = false;
                } else {
                    dp[j] = true;
                }
            }
        }
        return dp[target];
    }

    /**
     * "恰好装满背包"
     * @param nums
     * @param target
     * @return
     */
    public static List<Integer> subSetSum1(int[] nums, int target) {
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < nums[i - 1] || !dp[i - 1][j - nums[i - 1]]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = true;
                }
            }
        }
        List<Integer> result = new LinkedList<Integer>();
        int i = nums.length;
        int j = target;
        while (j > 0 && dp[i][j]) {
            if (j < nums[i - 1] || !dp[i - 1][j - nums[i - 1]]) {
                i--;
            } else {
                result.add(0, i);
                i--;
                j -= nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(SubsetSum.subsetSum0(new int[] {1, 2, 3, 4, 5}, 7));
        System.out.println(SubsetSum.subSetSum1(new int[] {1, 2, 3, 4, 5}, 7));
    }
}
