package linkedlist;

/**
 * Created by xuyaning on 1/2/16.
 */
public class Leet206 {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy.next;;
        while (p != null && p.next != null) {
            ListNode tmp = p.next;
            p.next = tmp.next;
            tmp.next = dummy.next;
            dummy.next = tmp;
        }
        return dummy.next;
    }
}
