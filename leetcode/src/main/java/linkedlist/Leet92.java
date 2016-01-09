package linkedlist;

/**
 * Created by xuyaning on 9/1/16.
 */
public class Leet92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        int i = 0;
        while (i < m - 1) {
            p = p.next;
            i++;
        }
        ListNode pre = p;


        ListNode phead = p.next;
        p = p.next;
        i++;
        while (i < n) {
            ListNode tmp = p.next;
            p.next = tmp.next;
            tmp.next = phead;
            phead = tmp;
            i++;
        }
        pre.next = phead;

        return dummy.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
