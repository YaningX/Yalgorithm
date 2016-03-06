package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xuyaning on 20/2/16.
 */
public class Leet47 {
    public ArrayList<List<Integer>> permuteUnique(int[] num) {
        ArrayList<List<Integer>> returnList = new ArrayList<List<Integer>>();
        returnList.add(new ArrayList<Integer>());

        for (int i = 0; i < num.length; i++) {
            Set<ArrayList<Integer>> currentSet = new HashSet<ArrayList<Integer>>();
            for (List<Integer> l : returnList) {
                for (int j = 0; j < l.size() + 1; j++) {
                    l.add(j, num[i]);
                    ArrayList<Integer> T = new ArrayList<Integer>(l);
                    l.remove(j);
                    currentSet.add(T);
                }
            }
            returnList = new ArrayList<List<Integer>>(currentSet);
        }

        return returnList;
    }


    //dfs solution
    public List<List<Integer>> permuteUnique0(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        List<Integer> rootList = new ArrayList<Integer>();
        for (int num: nums) {
            rootList.add(num);
        }
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        dfs(rootList, 0, result);
        return new ArrayList<List<Integer>>(result);
    }

    private void dfs(List<Integer> rootList, int index, Set<List<Integer>> result) {
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
