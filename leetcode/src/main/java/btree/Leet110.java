package btree;

/**
 * Created by xuyaning on 20/1/16.
 */
public class Leet110 {
    public boolean isBalanced(TreeNode root) {
        return dfs(root, new int[1]);
    }

    private boolean dfs(TreeNode root, int[] height) {
        if (root == null) {
            height[0] = 0;
            return true;
        }
        int[] leftHeight = new int[1];
        if (!dfs(root.left, leftHeight)) {
            return false;
        }
        int[] rightHeight = new int[1];
        if (!dfs(root.right, rightHeight)) {
            return false;
        }

        if (Math.abs(leftHeight[0] - rightHeight[0]) > 1) {
            return false;
        }

        height[0] = Math.max(leftHeight[0], rightHeight[0]) + 1;
        return true;
    }
}
