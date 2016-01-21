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
        if (root == null) {
            return result;
        }
        Stack<Integer> path = new Stack<Integer>();
        dfs(root, sum, 0, result, path);
        return result;
    }

    private void dfs(TreeNode root, int sum, int addSum, List<List<Integer>> result, Stack<Integer> path) {
        if (root.left == null && root.right == null) {
            if (addSum + root.val == sum) {
                path.push(root.val);
                result.add(new ArrayList<Integer>(path));
                path.pop();
                return;
            }
        }

        path.push(root.val);
        if (root.left != null) {
            dfs(root.left, sum, addSum + root.val, result, path);
        }

        if (root.right != null) {
            dfs(root.right, sum, addSum + root.val, result, path);
        }
        path.pop();
    }
}
