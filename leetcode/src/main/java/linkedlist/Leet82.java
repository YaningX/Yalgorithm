package linkedlist;

/**
 * Created by xuyaning on 7/1/16.
 */
public class Leet82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode iter = dummyNode;
        while (iter.next != null && iter.next.next != null) {
            if (iter.next.val == iter.next.next.val) {
                ListNode fast = iter.next.next;
                while (fast.next != null && fast.val == fast.next.val) {
                    fast = fast.next;
                }
                iter.next = fast.next;
            } else {
                iter = iter.next;
            }
        }
        return dummyNode.next;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
