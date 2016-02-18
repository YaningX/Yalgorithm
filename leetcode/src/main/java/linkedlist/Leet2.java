package linkedlist;

/**
 * Created by xuyaning on 12/2/16.
 */
public class Leet2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int carry = 0;
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            ListNode tmp = new ListNode(sum % 10);
            p.next = tmp;
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
            carry = sum / 10;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            ListNode tmp = new ListNode(sum % 10);
            p.next = tmp;
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            ListNode tmp = new ListNode(sum % 10);
            p.next = tmp;
            p = p.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            ListNode tmp = new ListNode(carry);
            p.next = tmp;
        }
        return dummy.next;
    }
}
