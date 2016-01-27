package linkedlist;

/**
 * Created by xuyaning on 26/1/16.
 */
public class Length {
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
