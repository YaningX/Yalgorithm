package round2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergekSortedLists {

    /**
     * 归并排序time O(nlogk)
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int size = lists.length;
        while (size != 1) {
            int index = 0;
            for (int i = 0; i + 1 < size; i += 2) {
                merge(lists, i, i + 1, index++);
            }
            if ((size & 1) == 1) {
                lists[index] = lists[size - 1];
            }
            size = (size + 1) / 2;
        }
        return lists[0];
    }


    private void merge(ListNode[] lists, int left, int right, int index) {
        ListNode lHead = lists[left];
        ListNode rHead = lists[right];
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (lHead != null && rHead != null) {
            if (lHead.val < rHead.val) {
                p.next = lHead;
                p = p.next;
                lHead = lHead.next;
            } else {
                p.next = rHead;
                p = p.next;
                rHead = rHead.next;
            }
        }

        if (lHead != null) {
            p.next = lHead;
        }

        if (rHead != null) {
            p.next = rHead;
        }
        lists[index] = dummy.next;
    }


    /**
     * 使用优先队列,最小堆,复杂度如上
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pqueue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        for (ListNode node: lists) {
            if (node != null) {
                pqueue.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (!pqueue.isEmpty()) {
            ListNode node = pqueue.poll();
            p.next = node;
            p = p.next;
            if (node.next != null) {
                pqueue.offer(node.next);
            }
        }
        return dummy.next;
    }
}
