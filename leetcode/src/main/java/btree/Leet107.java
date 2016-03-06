package btree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuyaning on 12/1/16.
 */
public class Leet107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (level == result.size()) {
            List<Integer> list = new ArrayList<Integer>();
            result.add(0, list);
        }
        result.get(result.size() - level - 1).add(root.val);
        dfs(root.left, level + 1, result);
        dfs(root.right, level + 1, result);
    }
}
