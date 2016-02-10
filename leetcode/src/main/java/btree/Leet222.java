package btree;

/**
 * Created by xuyaning on 10/2/16.
 */
public class Leet222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getLeft(root) + 1;
        int right = getRight(root) + 1;
        if (left == right) {
            return (2 << (left - 1)) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int getLeft(TreeNode root) {
        int count = 0;
        while (root.left != null) {
            root = root.left;
            count++;
        }
        return count;
    }

    private int getRight(TreeNode root) {
        int count = 0;
        while (root.right != null) {
            root = root.right;
            count++;
        }
        return count;
    }
}
