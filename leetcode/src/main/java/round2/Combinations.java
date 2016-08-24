package round2;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(0, k, n, new ArrayList<Integer>(), result);
        return result;
    }

    public void dfs(int start, int k, int n, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for (int i = start + 1; i <= n; i++) {
            current.add(i);
            dfs(i, k, n, current, result);
            current.remove(current.size() - 1);
        }
    }
}
