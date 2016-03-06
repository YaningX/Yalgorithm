package btree;

/**
 * Created by xuyaning on 13/1/16.
 */
public class Leet104 {
    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int level) {
        if (root == null) {
            return level;
        }
        return Math.max(dfs(root.left, level + 1), dfs(root.right, level + 1));
    }
}
