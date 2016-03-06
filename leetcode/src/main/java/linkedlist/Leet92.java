package linkedlist;

/**
 * Created by xuyaning on 9/1/16.
 */
public class Leet92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        for (int i = 0; i < m - 1; i++) {
            p = p.next;
        }
        int k = n - m + 1;
        ListNode q = p.next;;
        for (int i = 0; i < k - 1; i++) {
            ListNode tmp = q.next;
            q.next = tmp.next;
            tmp.next = p.next;
            p.next = tmp;
        }
        return dummy.next;
    }
}
