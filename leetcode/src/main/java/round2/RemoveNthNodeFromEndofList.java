package round2;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        for (int i = 0; i < n - 1; i++) {
            head = head.next;
        }
        while (head.next != null) {
            head = head.next;
            p = p.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }
}
