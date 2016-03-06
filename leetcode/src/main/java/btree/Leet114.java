package btree;

/**
 * Created by xuyaning on 21/1/16.
 */
public class Leet114 {
    public void flatten(TreeNode root) {
        flattenHelper(root);
    }

    private TreeNode flattenHelper(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root;
        }

        if (root.left == null) {
            return flattenHelper(root.right);
        }

        if (root.right == null) {
            root.right = root.left;
            root.left = null; // important!
            return flattenHelper(root.right);
        }

        // Divide
        TreeNode leftLastNode = flattenHelper(root.left);
        TreeNode rightLastNode = flattenHelper(root.right);

        // Conquer
        leftLastNode.right = root.right;
        root.right = root.left;
        root.left = null; // important!
        return rightLastNode;
    }

    public void flatten0(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                TreeNode p = node.left;
                while (p.right != null) {
                    p = p.right;
                }
                p.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }
}
