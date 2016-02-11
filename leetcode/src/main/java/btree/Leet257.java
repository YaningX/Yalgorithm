package btree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xuyaning on 11/2/16.
 */
public class Leet257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<String>();
        if (root == null) {
            return result;
        }
        dfs(root, "" + root.val, result);
        return result;
    }

    private void dfs(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        if (root.left != null) {
            dfs(root.left, path + "->" + root.left.val, result);
        }
        if (root.right != null) {
            dfs(root.right, path + "->" + root.right.val, result);
        }
    }
}
