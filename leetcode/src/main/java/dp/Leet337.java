package dp;

/**
 * Created by xuyaning on 25/3/16.
 */
public class Leet337 {
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    private int[] dfs(TreeNode root) {
        int[] result = new int[2];
        if (root == null) {
            return result;
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        result[0] = Math.max(Math.max(left[1] + right[1], left[0] + right[0]), Math.max(left[0] + right[1], left[1] + right[0]));
        result[1] = left[0] + right[0] + root.val;
        return result;
    }
}
