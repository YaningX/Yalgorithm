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
        if (root.right != null) {
            root.right.next = getNext(root.next);
            dfs(root.right);
        }

        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = getNext(root.next);
            }
            dfs(root.left);
        }
    }

    private TreeLinkNode getNext(TreeLinkNode next) {
        if (next == null) {
            return next;
        }
        if (next.left != null) {
            return next.left;
        }
        if (next.right != null) {
            return next.right;
        }
        return getNext(next.next);
    }
}
