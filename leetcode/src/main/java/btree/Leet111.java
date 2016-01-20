package btree;

/**
 * Created by xuyaning on 20/1/16.
 */
public class Leet111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 1, -1);
    }

    //return minimum depth
    private int dfs(TreeNode root, int depth, int minDepth) {
        if (root.left == null && root.right == null) {
            if (minDepth == -1) {
                return depth;
            }
            return Math.min(depth, minDepth);
        }

        int leftMinDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            leftMinDepth = dfs(root.left, depth + 1, minDepth);
        }
        int rightMinDepth = Integer.MAX_VALUE;
        if (root.right != null) {
            rightMinDepth = dfs(root.right, depth + 1, minDepth);
        }
        return Math.min(leftMinDepth, rightMinDepth);
    }
}
