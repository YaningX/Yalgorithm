package linkedlist;

/**
 * Created by xuyaning on 27/1/16.
 */
public class Leet160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenAC = length(headA);
        int lenBC = length(headB);
        int diff = Math.abs(lenAC - lenBC);
        while (diff > 0) {
            if (lenAC > lenBC) {
                headA = headA.next;
            } else {
                headB = headB.next;
            }
            diff--;
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private int length(ListNode head) {
        ListNode p = head;
        int len = 0;
        while (p != null) {
            p = p.next;
            len++;
        }
        return len;
    }
}
