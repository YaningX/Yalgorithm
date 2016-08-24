package round2;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/gray-code/
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        int e = 1;
        while (n > 0) {
            int size = result.size();
            for (int i = size - 1; i >= 0; i--) {
                result.add(result.get(i) + e);
            }
            e = e * 2;
            n--;
        }
        return result;
    }
}
