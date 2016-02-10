package btree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xuyaning on 31/1/16.
 */
public class InOrder {
    static class Snapshot {
        TreeNode root;
        int stage;
        public Snapshot(TreeNode root, int stage) {
            this.root = root;
            this.stage = stage;
        }
    }

    public static List<Integer> inOrder(TreeNode root) {
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
                    snapshot.stage = 1;
                    stack.push(snapshot);
                    stack.push(new Snapshot(snapshot.root.left, 0));
                    break;
                }
                case 1: {
                    result.add(snapshot.root.val);
                    stack.push(new Snapshot(snapshot.root.right, 0));
                    break;
                }
            }
        }
        return result;
    }

    public List<Integer> inorder(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);
                p = node.right;
            }
        }
        return result;
    }

}
