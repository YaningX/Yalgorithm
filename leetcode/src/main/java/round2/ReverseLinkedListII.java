package round2;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int count = n - m;
        if (count == 0) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode p = pre.next;
        for (int i = 0; i < count; i++) {
            ListNode tmp = p.next;
            p.next = p.next.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return dummy.next;
    }
}
