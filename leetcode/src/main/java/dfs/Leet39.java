package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xuyaning on 19/2/16.
 */
public class Leet39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (candidates.length == 0) {
            return result;
        }
        dfs(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    private static void dfs(int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0 && !current.isEmpty()) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            current.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], current, result);
            current.remove(current.size() - 1);
        }
    }


    public static int combinationSum1(int[] candidates, int target) {
        int[][] dp = new int[candidates.length + 1][target + 1];
        for (int i = 0; i <= candidates.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= candidates.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= candidates[i - 1]) {
                    dp[i][j] = dp[i][j] + dp[i][j - candidates[i - 1]];
                }
            }
        }
        return dp[candidates.length][target];
    }

}


