package map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xuyaning on 1/2/16.
 */
public class Leet202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            List<Integer> list = divide(n);
            n = 0;
            for (Integer i: list) {
                n += i * i;
            }
        }
        return true;
    }

    private List<Integer> divide(int n) {
        List<Integer> result = new ArrayList<Integer>();
        while (n != 0) {
            result.add(n % 10);
            n /= 10;
        }
        return result;
    }
}
