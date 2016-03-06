package math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuyaning on 9/1/16.
 */
public class Leet89 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        if (n == 0) {
            return result;
        }
        result.add(1);
        dfs(n, result, 1);
        return result;
    }

    private void dfs(int n, List<Integer> result, int index) {
        if (index == n) {
            return;
        }
        int size = result.size();
        for (int i = size - 1; i >= 0; i--) {
            result.add(result.get(i) + size);
        }
        dfs(n, result, index + 1);
    }
    /**
     n = 5:

     00000
     00001
     -----
     00011
     00010
     =====
     00110
     00111
     00101
     00100
     */
}
