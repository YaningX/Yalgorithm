package round2;

import java.util.*;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSumII {
    //背包问题
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[][] dp = new boolean[candidates.length + 1][target + 1];
        for (int i = 0; i <= candidates.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= candidates.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (candidates[i - 1] <= j) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - candidates[i - 1]];
                }
            }
        }
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        dfs(candidates, dp, candidates.length, target, new ArrayList<Integer>(), result);
        return new ArrayList<List<Integer>>(result);
    }

    private void dfs(int[] candidates, boolean[][] dp, int x, int y, List<Integer> current, Set<List<Integer>> result) {
        if (y == 0) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        if (x == 0) {
            return;
        }
        if (dp[x - 1][y]) {
            dfs(candidates, dp, x - 1, y, current, result);
        }
        if (y >= candidates[x - 1] && dp[x - 1][y - candidates[x - 1]]) {
            current.add(candidates[x - 1]);
            dfs(candidates, dp, x - 1, y - candidates[x - 1], current, result);
            current.remove(current.size() - 1);
        }
    }
}
