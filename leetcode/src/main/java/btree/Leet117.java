package btree;

/**
 * Created by xuyaning on 22/1/16.
 */
public class Leet117 {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        dfs(root);
    }

    private void dfs(TreeLinkNode root) {
        if (root.left == null && root.right == null) {
            return;
        }

        if (root.right != null) {
            if (root.next != null) {
                root.right.next = next(root.next);
            }
            dfs(root.right);
        }

        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = next(root.next);
            }
            dfs(root.left);
        }
    }

    private TreeLinkNode next(TreeLinkNode next) {
        if (next == null) {
            return null;
        }

        if (next.left != null) {
            return next.left;
        }

        if (next.right != null) {
            return next.right;
        }

        return next(next.next);
    }
}
