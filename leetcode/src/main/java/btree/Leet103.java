package btree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuyaning on 11/1/16.
 */
public class Leet103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
            result.add(list);
        }
        if ((level & 1) == 0) {
            result.get(level).add(root.val);
        } else {
            result.get(level).add(0, root.val);
        }
        dfs(root.left, level + 1, result);
        dfs(root.right, level + 1, result);
    }
}
