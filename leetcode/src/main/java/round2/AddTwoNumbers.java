package round2;

import linkedlist.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * (1) time O(n), space O(n)
 * (2) 通过定义伪首节点,来简化过程
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = carry + l1.val + l2.val;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = carry + l1.val;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            p = p.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = carry + l2.val;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            p = p.next;
            l2 = l2.next;
        }

        if (carry != 0) {
            p.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
