package linkedlist;

/**
 * Created by xuyaning on 26/1/16.
 */
public class Leet147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        while (p.next != null) {
            ListNode q = dummy;
            while (q.next.val <= p.next.val && p != q) {
                q = q.next;
            }
            if (p == q) {
                p = p.next;
                continue;
            }
            ListNode tmp = p.next;
            p.next = tmp.next;
            tmp.next = q.next;
            q.next = tmp;
        }
        return dummy.next;
    }
}
