package recursive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xuyaning on 29/12/15.
 */
public class Leet46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (nums == null || nums.length == 0) {
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
}
