package lib;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 组合[1, 2, 3, ..., n]
 */
public class Combinations {

    /**
     * 使用队列,非递归实现
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
        for (int i = 1; i <= n; i++) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(i);
            queue.offer(list);
        }
        while (!queue.isEmpty()) {
            if (queue.peek().size() == k) {
                result.addAll(queue);
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list = queue.poll();
                for (int j = list.get(list.size() - 1) + 1; j <= n; j++) {
                    List<Integer> tmp = new ArrayList<Integer>(list);
                    tmp.add(j);
                    queue.offer(tmp);
                }
            }
        }
        return result;
    }

    /**
     * 递归实现
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        dfs(n, k, 1, new ArrayList<Integer>(), result);
        return result;
    }

    private void dfs(int n, int k, int start, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(n, k, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
}
