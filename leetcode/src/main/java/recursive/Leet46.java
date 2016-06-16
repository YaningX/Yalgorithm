package recursive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class Leet46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (nums.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i: nums) {
            list.add(i);
        }
        result = doPermute(list);
        return result;
    }

    private List<List<Integer>> doPermute(List<Integer> list) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (list.size() == 1) {
            result.add(list);
            return result;
        }

        for (int i = 0; i < list.size(); i++) {
            List<Integer> tmpList = new ArrayList<Integer>(list);
            tmpList.remove(i);
            List<List<Integer>> nextRec = doPermute(tmpList);
            for (int j = 0; j < nextRec.size(); j++) {
                List<Integer> innerList = new ArrayList<Integer>();
                innerList.add(list.get(i));
                innerList.addAll(nextRec.get(j));
                result.add(innerList);
            }
        }
        return result;
    }




    // another effective solution
    public List<List<Integer>> permute0(int[] nums) {
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
}
