package linkedlist;

/**
 * Created by xuyaning on 7/1/16.
 */
public class Leet82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p != null && p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                int val = p.next.val;
                while (p.next != null && p.next.val == val) {
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }
}
