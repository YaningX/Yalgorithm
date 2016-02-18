package dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xuyaning on 17/2/16.
 */
public class Leet22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<String>();
        if (n == 0) {
            return result;
        }
        dfs(n, n, "", result);
        return result;
    }

    private void dfs(int leftNum, int rightNum, String cur, List<String> result) {
        if (leftNum == 0 && rightNum == 0) {
            result.add(cur);
            return;
        }
        if (leftNum > 0) {
            dfs(leftNum - 1, rightNum, cur + '(', result);
        }
        if (rightNum > 0 && leftNum < rightNum) {
            dfs(leftNum, rightNum - 1, cur + ')', result);
        }
    }
}
