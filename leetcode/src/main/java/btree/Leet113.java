package btree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xuyaning on 21/1/16.
 */
public class Leet113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root != null) {
            dfs(root, sum, new ArrayList<Integer>(), result);
        }
        return result;
    }

    private void dfs(TreeNode root, int sum, List<Integer> current, List<List<Integer>> result) {
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> list = new ArrayList<Integer>(current);
                list.add(root.val);
                result.add(list);
            }
            return;
        }
        current.add(root.val);
        if (root.left != null) {
            dfs(root.left, sum - root.val, current, result);
        }
        if (root.right != null) {
            dfs(root.right, sum -root.val, current, result);
        }
        current.remove(current.size() - 1);
    }
}
