package recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuyaning on 22/1/16.
 */
public class Leet118 {
    public List<List<Integer>> generate(int numRows) {
        return dfs(numRows);
    }

    private List<List<Integer>> dfs (int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return result;
        }
        if (numRows == 1) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);
            result.add(list);
            return result;
        }

        List<List<Integer>> last = dfs(numRows - 1);
        List<Integer> endList = last.get(last.size() - 1);
        List<Integer> tmp = new ArrayList<Integer>();
        tmp.add(1);
        for (int i = 1; i < endList.size(); i++) {
            tmp.add(endList.get(i - 1) + endList.get(i));
        }
        tmp.add(1);
        last.add(tmp);
        return last;
    }
}
