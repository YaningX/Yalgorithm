package btree;

/**
 * Created by xuyaning on 10/2/16.
 */
public class Leet235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        TreeNode node = root;
        while (node != null) {
            if (min > node.val) {
                node = node.right;
            } else if (max < node.val) {
                node = node.left;
            } else {
                return node;
            }
        }
        return root;
    }
}
