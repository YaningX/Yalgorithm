package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xuyaning on 19/2/16.
 */
public class Leet39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    private void dfs(int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> result) {
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
}
