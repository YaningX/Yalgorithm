package btree;

import java.util.Stack;

/**
 * Binary Search Tree Iterator
 * Pre-order traverse using stack
 */
public class Leet173 {
    public class BSTIterator {
        int next;
        Stack<Snapshot> stack = new Stack<Snapshot>();
        class Snapshot {
            TreeNode root;
            int stage;
            public Snapshot(TreeNode root, int stage) {
                this.root = root;
                this.stage = stage;
            }
        }

        public BSTIterator(TreeNode root) {
            stack.push(new Snapshot(root, 0));
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            if (stack.isEmpty()) {
                return false;
            }
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
                        this.next = snapshot.root.val;
                        stack.push(new Snapshot(snapshot.root.right, 0));
                        return true;
                    }
                }
            }
            return false;
        }

        /** @return the next smallest number */
        public int next() {
            return this.next;
        }
    }
}
