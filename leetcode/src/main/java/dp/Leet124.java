package dp;

/**
 * Created by xuyaning on 24/1/16.
 */
public class Leet124 {
    public int maxPathSum(TreeNode root) {
        int[] result = new int[1];
        result[0] = Integer.MIN_VALUE;
        dfs(root, result);
        return result[0];
    }

    private int dfs(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, result);
        int right = dfs(root.right, result);
        int current = Math.max(root.val, Math.max(left, right) + root.val);
        result[0] = Math.max(result[0], Math.max(current, root.val + left + right));
        return current;
    }
}
