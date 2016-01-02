package linkedlist;

/**
 * Created by xuyaning on 2/1/16.
 */
public class Leet61 {
    public ListNode rotateRight(ListNode head, int k) {
        int length = getLength(head);
        if (length == 0 || k == length) {
            return head;
        }

        k = k % length;
        ListNode slow = head;
        ListNode tmp = head;
        for (int i = 0; i < k; i++) {
            tmp = tmp.next;
        }
        ListNode fast = tmp;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

    int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
}
