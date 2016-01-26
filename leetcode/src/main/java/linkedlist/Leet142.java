package linkedlist;

/**
 * http://fisherlei.blogspot.com/2013/11/leetcode-linked-list-cycle-ii-solution.html
 */
public class Leet142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null) {
            return null;
        }
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
