package linkedlist;

/**
 * Created by xuyaning on 26/1/16.
 */
public class Leet141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
