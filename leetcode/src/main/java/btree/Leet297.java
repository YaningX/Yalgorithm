package btree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

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
            ArrayList<Integer> ans = new ArrayList<Integer>();
            sHelper(root, ans);
            return ans.toString();
        }
        private void sHelper(TreeNode root, ArrayList<Integer> ans) {
            if(root == null) {
                ans.add(null);
                return;
            }
            ans.add(root.val);
            sHelper(root.left, ans);
            sHelper(root.right, ans);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data == null) return null;
            data = data.substring(1, data.length() - 1);
            String[] nodesVal = data.split(", ");
            Deque<String> strList = new LinkedList<String>(Arrays.asList(nodesVal));
            return dHelper(strList);
        }
        private TreeNode dHelper(Deque<String> strList) {
            if(strList.size() == 0) return null;
            String str = strList.pop();
            if(str.equals("null")) {
                return null;
            }
            TreeNode cur = new TreeNode(Integer.parseInt(str));
            cur.left = dHelper(strList);
            cur.right = dHelper(strList);
            return cur;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
