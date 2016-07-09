package round2;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/.
 */
public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = dummy;
        int count = 0;
        while (right != null) {
            if (count == k) {
                left = reverseK(left, k);
                right = left;
                count = 0;
                continue;
            }
            right = right.next;
            count++;
        }
        return dummy.next;
    }

    private ListNode reverseK(ListNode pre, int k) {
        ListNode p = pre.next;
        for (int i = 0; i < k - 1; i++) {
            ListNode node = p.next;
            p.next = node.next;
            node.next = pre.next;
            pre.next = node;
        }
        return p;
    }
}
