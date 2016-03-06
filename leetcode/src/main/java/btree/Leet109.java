package btree;

import linkedlist.ListNode;

/**
 * http://bangbingsyb.blogspot.com/2014/11/leetcode-convert-sorted-list-to-binary.html
 */
public class Leet109 {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        int len = 0;
        while (p != null) {
            p = p.next;
            len++;
        }
        return dfs(dummy, 0, len - 1);
    }

    private TreeNode dfs(ListNode pre, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode left = dfs(pre, start, mid - 1);
        TreeNode root = new TreeNode(pre.next.val);
        root.left = left;
        pre.next = pre.next.next;
        root.right = dfs(pre, mid + 1, end);
        return root;
    }
}
