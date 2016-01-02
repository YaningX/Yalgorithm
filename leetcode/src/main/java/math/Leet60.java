package math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuyaning on 2/1/16.
 */
public class Leet60 {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<Integer>();

        int permCount = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            permCount *= i;
        }
        k--;

        for (int i = 0; i < n; i++) {
            permCount = permCount / (n - i);
            sb.append(list.remove(k / permCount));
            k = k % permCount;
        }
        return sb.toString();
    }
}
