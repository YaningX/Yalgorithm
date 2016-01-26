package linkedlist;

/**
 * Created by xuyaning on 26/1/16.
 */
public class Leet148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode firstHalf = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode leftList = null, rightList = null;
        if (firstHalf != secondHalf) {
            leftList = sortList(firstHalf);
            rightList = sortList(secondHalf);
        }
        return merge(leftList, rightList);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                p.next = head1;
                head1 = head1.next;
            } else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        if (head1 == null) {
            p.next = head2;
        }
        if (head2 == null) {
            p.next = head1;
        }
        return dummy.next;
    }
}
