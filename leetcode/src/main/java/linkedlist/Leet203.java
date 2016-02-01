package linkedlist;

/**
 * Created by xuyaning on 1/2/16.
 */
public class Leet203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        //凡是要出现(判断)p.next之前,先判断 p != null
        while (p != null && p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }
}
