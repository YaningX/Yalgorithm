package btree;

/**
 * Created by xuyaning on 27/2/16.
 */
public class Leet112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return dfs(root, sum);
    }

    private boolean dfs(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        if (root.left != null && dfs(root.left, sum - root.val)) {
            return true;
        }
        if (root.right != null && dfs(root.right, sum - root.val)) {
            return true;
        }
        return false;
    }
}
