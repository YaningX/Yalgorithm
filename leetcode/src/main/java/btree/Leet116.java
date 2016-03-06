package btree;

/**
 * Created by xuyaning on 22/1/16.
 */
public class Leet116 {
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
        root.left.next = root.right;
        root.right.next = root.next == null ? null: root.next.left;
        dfs(root.left);
        dfs(root.right);
    }
}
