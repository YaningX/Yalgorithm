package btree;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by xuyaning on 2/4/16.
 */
public class HuffmanTree {
    public static TreeNode createHuffmanTree(List<Integer> list) {
        if (list.size() == 0) {
            return null;
        }
        PriorityQueue<TreeNode> queue = new PriorityQueue<TreeNode>();
        for (int val: list) {
            queue.offer(new TreeNode(val));
        }
        while (queue.size() > 1) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            TreeNode parent = new TreeNode(left.val + right.val);
            parent.left = left;
            parent.right = right;
            queue.offer(parent);
        }
        return queue.poll();
    }
}
