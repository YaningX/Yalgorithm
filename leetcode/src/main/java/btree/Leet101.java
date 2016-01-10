package btree;

/**
 * Created by xuyaning on 10/1/16.
 */
public class Leet101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left != null && right != null) {
            if (left.val == right.val) {
                if (!isSymmetric(left.left, right.right)) {
                    return false;
                }

                if (!isSymmetric(left.right, right.left)) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
