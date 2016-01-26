package linkedlist;

/**
 * http://www.programcreek.com/2013/12/in-place-reorder-a-singly-linked-list-in-java/
 */
public class Leet143 {
    public static void reorderList(ListNode head) {

        if (head != null && head.next != null) {

            ListNode slow = head;
            ListNode fast = head;

            //use a fast and slow pointer to break the link to two parts.
            while (fast != null && fast.next != null && fast.next.next!= null) {
                //why need third/second condition?
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode second = slow.next;
            slow.next = null;// need to close first part
            // now should have two lists: head and fast

            // reverse order for second part
            second = reverseOrder(second);

            ListNode p1 = head;
            ListNode p2 = second;

            //merge two lists here
            while (p2 != null) {
                ListNode temp1 = p1.next;
                ListNode temp2 = p2.next;

                p1.next = p2;
                p2.next = temp1;

                p1 = temp1;
                p2 = temp2;
            }
        }
    }


    private static ListNode reverseOrder(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = head;
        while (pre.next != null) {
            ListNode tmp = pre.next;
            pre.next = tmp.next;
            tmp.next = dummy.next;
            dummy.next = tmp;
        }
        return dummy.next;
    }
}
