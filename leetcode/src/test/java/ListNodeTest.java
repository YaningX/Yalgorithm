import linkedlist.ListNode;
import org.junit.Test;

/**
 * Created by xuyaning on 26/1/16.
 */
public class ListNodeTest {
    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head = reverseOrder(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    private static ListNode reverseOrder(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy.next;
        while (pre.next != null) {
            ListNode tmp = pre.next;
            pre.next = tmp.next;
            tmp.next = dummy.next;
            dummy.next = tmp;
        }
        return dummy.next;
    }
}
