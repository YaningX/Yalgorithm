package linkedlist;

/**
 * Created by xuyaning on 8/1/16.
 */
public class Leet83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode iter = dummyNode.next;
        while (iter != null && iter.next != null) {
            while (iter.next != null && iter.val == iter.next.val) {
                iter.next = iter.next.next;
            }
            iter = iter.next;
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
