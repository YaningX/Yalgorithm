package lib;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 全排列[1, 2, 3]共六种
 */
public class Permutations {

    /**
     * 递归实现n!
     * @param nums
     * @return
     */
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> rootList = new ArrayList<Integer>();
        for (int num: nums) {
            rootList.add(num);
        }
        dfs(rootList, 0, result);
        return result;
    }

    private void dfs(List<Integer> rootList, int index, List<List<Integer>> result) {
        if (index == rootList.size()) {
            result.add(new ArrayList<Integer>(rootList));
            return;
        }
        for (int i = index; i < rootList.size(); i++) {
            int tmp = rootList.get(index);
            rootList.set(index, rootList.get(i));
            rootList.set(i, tmp);
            dfs(rootList, index + 1, result);
            rootList.set(i, rootList.get(index));
            rootList.set(index, tmp);
        }
    }


    /**
     * 非递归实现n!
     * @param nums
     * @return
     */
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
        queue.offer(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list = queue.poll();
                for (int k = 0; k <= list.size(); k++) {
                    List<Integer> copy = new ArrayList<Integer>(list);
                    copy.add(k, nums[i]);
                    queue.offer(copy);
                }
            }
        }
        return new LinkedList<List<Integer>>(queue);
    }
}
