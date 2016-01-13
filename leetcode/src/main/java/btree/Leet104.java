package btree;

/**
 * Created by xuyaning on 13/1/16.
 */
public class Leet104 {
    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int maxDepth) {
        if (node == null) {
            return maxDepth;
        }

        int leftMax = dfs(node.left, maxDepth) + 1;
        int rightMax = dfs(node.right, maxDepth) + 1;
        return Math.max(maxDepth, Math.max(leftMax, rightMax));
    }
}
