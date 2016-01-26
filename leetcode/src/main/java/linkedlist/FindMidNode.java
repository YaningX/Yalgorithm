package linkedlist;

/**
 * Created by xuyaning on 26/1/16.
 */
public class FindMidNode {
    //长度为L, 当偶数个节点时,返回 (L - 1) / 2, 长度为奇数时,返回 (L - 1) / 2, 正中间的数或者正中间偏左一个的数.
    //经常需要将一个链表在中间位置一分为二,记得将slow.next = null
    public ListNode findMidNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
