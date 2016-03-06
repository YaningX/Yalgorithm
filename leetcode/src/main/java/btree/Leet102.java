package btree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuyaning on 11/1/16.
 */
public class Leet102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result, root, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (result.size() == level) {
            List<Integer> list = new ArrayList<Integer>();
            result.add(list);
        }
        result.get(level).add(root.val);
        dfs(result, root.left, level + 1);
        dfs(result, root.right, level + 1);
    }
}
