package linkedlist;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xuyaning on 17/2/16.
 */
public class Leet23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1) {
            return lists[0];
        }
        Queue<ListNode> queue = new LinkedList<ListNode>();
        for (ListNode node: lists) {
            queue.offer(node);
        }
        while (queue.size() != 1) {
            ListNode node = merge2Lists(queue.poll(), queue.poll());
            queue.offer(node);
        }
        return queue.poll();
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return dummy.next;
    }
}
