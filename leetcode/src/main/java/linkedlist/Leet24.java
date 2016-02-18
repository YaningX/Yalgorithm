package linkedlist;

/**
 * Created by xuyaning on 17/2/16.
 */
public class Leet24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null && p.next.next != null) {
            ListNode tmp = p.next.next;
            p.next.next = tmp.next;
            tmp.next = p.next;
            p.next = tmp;
            p = p.next.next;
        }
        return dummy.next;
    }
}
