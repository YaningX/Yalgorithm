package graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuyaning on 25/1/16.
 */
public class Leet138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode newHead = new RandomListNode(head.label);
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        map.put(head, newHead);
        dfs(head, newHead, map);
        return newHead;
    }

    private void dfs(RandomListNode head, RandomListNode newHead, Map<RandomListNode, RandomListNode> map) {
        if (head.next == null) {
            newHead.next = null;
        } else if (!map.containsKey(head.next)) {
            RandomListNode next = new RandomListNode(head.next.label);
            map.put(head.next, next);
            newHead.next = next;
            dfs(head.next, newHead.next, map);
        } else {
            newHead.next = map.get(head.next);
        }

        if (head.random == null) {
            newHead.random = null;
        } else if (!map.containsKey(head.random)) {
            RandomListNode random = new RandomListNode(head.random.label);
            map.put(head.random, random);
            newHead.random = random;
            dfs(head.random, newHead.random, map);
        } else {
            newHead.random = map.get(head.random);
        }
    }
}
