package btree;

/**
 * Created by xuyaning on 20/1/16.
 */
public class Leet110 {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) >= 0;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left < 0 || right < 0 || Math.abs(left - right) > 1) {
            return Integer.MIN_VALUE;
        }
        return Math.max(left, right) + 1;
    }
}
