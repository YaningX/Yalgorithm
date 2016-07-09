package round2;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p != null && p.next != null && p.next.next != null) {
            ListNode node = p.next.next;
            p.next.next = node.next;
            node.next = p.next;
            p.next = node;
            p = p.next.next;
        }
        return dummy.next;
    }
}
