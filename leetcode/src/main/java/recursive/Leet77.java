package recursive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xuyaning on 7/1/16.
 */
public class Leet77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (k == 0) {
            return result;
        }

        Stack<List<Integer>> stack = new Stack<List<Integer>>();
        for (int i = 1; i <= n - k + 1; i++) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(i);
            stack.push(list);
        }

        while (!stack.isEmpty()) {
            List<Integer> list = stack.pop();
            if (list.size() == k) {
                result.add(list);
                continue;
            }
            for (int i = list.get(list.size() - 1) + 1; i <= n; i++) {
                List<Integer> tmpList = new ArrayList<Integer>(list);
                tmpList.add(i);
                stack.push(tmpList);
            }
        }
        return result;
    }

    //method 2
    public List<List<Integer>> dfsCombine(int n, int k) {
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
