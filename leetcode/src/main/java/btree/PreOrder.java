package btree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xuyaning on 31/1/16.
 */
public class PreOrder {
    class Snapshot {
        TreeNode root;
        int stage;
        public Snapshot(TreeNode root, int stage) {
            this.root = root;
            this.stage = stage;
        }
    }

    public List<Integer> preOrder(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        Stack<Snapshot> snapshotStack = new Stack<Snapshot>();
        Snapshot snapshot = new Snapshot(root, 0);
        snapshotStack.push(snapshot);
        while (!snapshotStack.isEmpty()) {
            Snapshot snap = snapshotStack.pop();
            if (snap.root == null) {
                continue;
            }
            switch (snap.stage) {
                case 0:
                    result.add(snap.root.val);
                    snapshotStack.push(new Snapshot(snap.root.left, 1));
                    break;
                case 1:
                    snapshotStack.push(new Snapshot(snap.root.right, 0));
                    break;
                default:
                    break;
            }
        }
        return result;
    }

    private void dfs(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        dfs(root.left, result);
        dfs(root.right, result);
    }
    public List<Integer> preOrderRec(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        return null;
    }
}
