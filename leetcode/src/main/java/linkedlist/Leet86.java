package linkedlist;

/**
 * Created by xuyaning on 8/1/16.
 */
public class Leet86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        dummy1.next = head;
        ListNode dummy2 = new ListNode(0);
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        while (p1 != null && p1.next != null) {
            if (p1.next.val < x) {
                ListNode tmp = p1.next;
                p1.next = p1.next.next;
                p2.next = tmp;
                p2 = p2.next;
            } else {
                p1 = p1.next;
            }
        }
        p2.next = dummy1.next;
        return dummy2.next;
    }
}
