package linkedlist;

/**
 * Created by xuyaning on 11/2/16.
 */
public class Leet234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        ListNode secondHead = reverse(mid);
        while (head != null && secondHead != null) {
            if (head.val != secondHead.val) {
                return false;
            }
            head = head.next;
            secondHead = secondHead.next;
        }
        return true;
    }

    private int getLength(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0;
        while (dummy.next != null) {
            dummy = dummy.next;
        }
        return count;
    }

    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        while (p != null && p.next != null) {
            ListNode tmp = p.next;
            p.next = tmp.next;
            tmp.next = dummy.next;
            dummy.next = tmp;
        }
        return dummy.next;
    }
}
