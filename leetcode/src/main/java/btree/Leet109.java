package btree;

import linkedlist.ListNode;

/**
 * http://bangbingsyb.blogspot.com/2014/11/leetcode-convert-sorted-list-to-binary.html
 */
public class Leet109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        return dfs(dummy, 0, len - 1);
    }

    private TreeNode dfs(ListNode dummy, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode left = dfs(dummy, start, mid - 1);
        TreeNode parent = new TreeNode(dummy.next.val);
        parent.left = left;
        dummy.next = dummy.next.next;
        parent.right = dfs(dummy, mid + 1, end);
        return parent;
    }
}
