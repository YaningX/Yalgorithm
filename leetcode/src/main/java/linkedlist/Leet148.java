package linkedlist;

/**
 * Created by xuyaning on 26/1/16.
 */
public class Leet148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(second);
        return merge(left, right);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val >= head2.val) {
                p.next = head2;
                head2 = head2.next;
            } else {
                p.next = head1;
                head1 = head1.next;
            }
            p = p.next;
        }
        if (head1 != null) {
            p.next = head1;
        }
        if (head2 != null) {
            p.next = head2;
        }
        return dummy.next;
    }
}
