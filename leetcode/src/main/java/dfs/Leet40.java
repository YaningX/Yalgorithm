package dfs;

import java.util.*;

/**
 * Created by xuyaning on 19/2/16.
 */
public class Leet40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        Arrays.sort(candidates);
        dfs(candidates, -1, target, new ArrayList<Integer>(), result);
        return new ArrayList<List<Integer>>(result);
    }

    private void dfs(int[] candidates, int index, int target, List<Integer> current, Set<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for (int i = index + 1; i < candidates.length; i++) {
            current.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], current, result);
            current.remove(current.size() - 1);
        }
    }
}
