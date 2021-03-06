package recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuyaning on 22/1/16.
 */
public class Leet119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        if (rowIndex < 0) {
            return result;
        }
        if (rowIndex == 0) {
            result.add(1);
            return result;
        }

        result = getRow(rowIndex - 1);
        int last = result.get(0);
        for (int i = 1; i < rowIndex; i++) {
            int add = last;
            last = result.get(i);
            result.set(i, result.get(i) + add);
        }
        result.add(1);
        return result;
    }

    ///////////////////////////////////////////////
    public List<Integer> getRow0(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);
        for (int i = 0; i < rowIndex; i++) {
            int addition = result.get(0);
            for (int j = 1; j < result.size(); j++) {
                int old = result.get(j);
                result.set(j, result.get(j) + addition);
                addition = old;
            }
            result.add(1);
        }
        return result;
    }
}
