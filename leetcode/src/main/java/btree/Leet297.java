package btree;

import java.util.*;

/**
 * Created by xuyaning on 12/2/16.
 */
public class Leet297 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {


        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<Integer> result = new LinkedList<Integer>();
            sDfs(root, result);
            return result.toString();
        }

        private void sDfs(TreeNode root, List<Integer> result) {
            if (root == null) {
                result.add(null);
                return;
            }
            result.add(root.val);
            sDfs(root.left, result);
            sDfs(root.right, result);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] strArray = data.substring(1, data.length() - 1).split(", ");
            Queue<String> queue = new LinkedList<String>(Arrays.asList(strArray));
            return dDfs(queue);
        }

        private TreeNode dDfs(Queue<String> queue) {
            if (queue.size() == 0) {
                return null;
            }
            if (queue.peek().equals("null")) {
                queue.poll();
                return null;
            }
            TreeNode node = new TreeNode(Integer.valueOf(queue.poll()));
            node.left = dDfs(queue);
            node.right = dDfs(queue);
            return node;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
