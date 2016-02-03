package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuyaning on 3/2/16.
 */
public class Leet216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result, new ArrayList<Integer>(), k, n, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> currentList, int k, int sum, int start) {
        if (k == 0) {
            if (sum == 0) {
                result.add(new ArrayList<Integer>(currentList));
            }
            return;
        }

        for (int i = start + 1; i < 10; i++) {
            currentList.add(i);
            dfs(result, currentList, k - 1, sum - i, i);
            currentList.remove(currentList.size() - 1);
        }
    }
}
