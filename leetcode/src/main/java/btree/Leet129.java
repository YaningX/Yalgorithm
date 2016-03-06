package btree;

/**
 * Created by xuyaning on 24/1/16.
 */
public class Leet129 {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int num) {
        if (root == null) {
            return 0;
        }
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            return num;
        }
        return dfs(root.left, num) + dfs(root.right, num);
    }
}
