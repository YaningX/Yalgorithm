package btree;

/**
 * Created by xuyaning on 10/1/16.
 */
public class Leet100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            } else {
                if (!isSameTree(p.left, q.left)) {
                    return false;
                }
                if (!isSameTree(p.right, q.right)) {
                    return false;
                }
                return true;
            }
        } else {
            return false;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val =val;
        }
    }
}
