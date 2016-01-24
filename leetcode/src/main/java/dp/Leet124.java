package dp;

/**
 * Created by xuyaning on 24/1/16.
 */
public class Leet124 {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        dfs(root, max);
        return max[0];
    }

    private int dfs(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, max);
        int right = dfs(root.right, max);
        int current = Math.max(root.val, Math.max(left + root.val, right + root.val));
        max[0] = Math.max(max[0], Math.max(current, root.val + left + right));
        return current;
    }
}
