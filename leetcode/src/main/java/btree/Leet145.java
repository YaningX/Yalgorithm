package btree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/
 */
public class Leet145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        Stack<Integer> reStack = new Stack<Integer>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            reStack.push(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        while (!reStack.isEmpty()) {
            result.add(reStack.pop());
        }
        return result;
    }
}
