package round2;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        dfs(result, n, n, "");
        return result;
    }

    private void dfs(List<String> result, int left, int right, String current) {
        if (left == 0 && right == 0) {
            result.add(current);
            return;
        }
        if (left > 0) {
            dfs(result, left - 1, right, current + "(");
        }
        if (right > left) {
            dfs(result, left, right - 1, current + ")");
        }
    }
}
