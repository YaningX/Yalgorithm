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
        Stack<Snapshot> stack = new Stack<Snapshot>();
        stack.push(new Snapshot(root, 0));
        while (!stack.isEmpty()) {
            Snapshot snapshot = stack.pop();
            switch (snapshot.stage) {
                case 0: {
                    if (snapshot.root == null) {
                        continue;
                    }
                    result.add(snapshot.root.val);
                    snapshot.stage = 1;
                    stack.push(snapshot);
                    stack.push(new Snapshot(snapshot.root.left, 0));
                    break;
                }
                case 1: {
                    snapshot.stage = 0;
                    stack.push(new Snapshot(snapshot.root.right, 0));
                    break;
                }
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
