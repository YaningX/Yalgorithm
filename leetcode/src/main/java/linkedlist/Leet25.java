package linkedlist;

/**
 * Created by xuyaning on 18/2/16.
 */
public class Leet25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0;
        ListNode left = dummy;
        ListNode right = dummy;
        while (right != null) {
            if (count == k) {
                left = reverseK(left, k);
                right = left;
                count = 0;
                continue;
            }
            right = right.next;
            count++;
        }
        return dummy.next;
    }

    private ListNode reverseK(ListNode pre, int k) {
        ListNode p = pre.next;
        for (int i = 0; i < k - 1; i++) {
            ListNode tmp = p.next;
            p.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return p;
    }
}
