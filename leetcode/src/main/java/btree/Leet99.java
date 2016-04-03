package btree;

/**
 * Recover Binary Search Tree
 * 中序遍历为有序遍历
 */
public class Leet99 {
    public void recoverTree(TreeNode root) {
        TreeNode pre = new TreeNode(0);
        TreeNode p = new TreeNode(0);
        dfs(root, pre, p);
        int tmp = p.left.val;
        p.left.val = p.right.val;
        p.right.val = tmp;
    }

    //中序遍历.
    private void dfs(TreeNode root, TreeNode pre, TreeNode p) {
        if (root == null) {
            return;
        }
        dfs(root.left, pre, p);

        if (pre.left != null) {
            if (pre.left.val >= root.val) {
                if (p.left == null) {
                    p.left = pre.left;
                }
                p.right = root;
            }
        }
        pre.left = root;
        dfs(root.right, pre, p);
    }
}
