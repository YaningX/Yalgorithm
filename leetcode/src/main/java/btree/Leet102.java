package btree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuyaning on 11/1/16.
 */
public class Leet102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(root, result, 0);
        return result;
    }

    private void dfs(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) {
            return;
        }

        if (result.size() <= level) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(node.val);
            result.add(list);
        } else {
            List<Integer> list = result.get(level);
            list.add(node.val);
        }
        dfs(node.left, result, level + 1);
        dfs(node.right, result, level + 1);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
