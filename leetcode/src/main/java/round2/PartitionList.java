package round2;

/**
 * https://leetcode.com/problems/partition-list/
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        ListNode p = new ListNode(0);
        p.next = head;
        while (p.next != null) {
            if (p.next.val < x) {
                p1.next = p.next;
                p.next = p.next.next;
                p1 = p1.next;
                p1.next = null;
            } else {
                p2.next = p.next;
                p.next = p.next.next;
                p2 = p2.next;
                p2.next = null;
            }
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }
}
