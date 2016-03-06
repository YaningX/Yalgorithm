package btree;

/**
 * Created by xuyaning on 20/1/16.
 */
public class Leet111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        int result = Integer.MAX_VALUE;
        if (root.left != null) {
            result = Math.min(result, dfs(root.left));
        }
        if (root.right != null) {
            result = Math.min(result, dfs(root.right));
        }
        return result + 1;
    }
}
