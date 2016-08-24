package round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        dfs(n, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void dfs(int n, int k, List<Integer> current, List<List<String>> result) {
        if (k == n) {
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[current.get(i)] = 'Q';
                list.add(new String(chars));
            }
            result.add(list);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(i, current)) {
                current.add(i);
                dfs(n, k + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    public boolean isValid(int col, List<Integer> queens) {
        int leftup = col;
        int rightup = col;
        for (int i = queens.size() - 1; i >= 0; i--) {
            leftup--;
            rightup++;
            int index = queens.get(i);
            if (index == leftup || index == col || index == rightup) {
                return false;
            }
        }
        return true;
    }
}
