package find;

/**
 * Created by xuyaning on 3/1/16.
 */
public class Leet69 {
    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        while (low <= high) {
            long mid = (long) (low + high) / 2;
            long product = mid * mid;
            if (product < x) {
                long upperProduct = (mid + 1) * (mid + 1);
                if (upperProduct > x) {
                    return (int) mid;
                }
                low = (int) mid + 1;
            } else if (product > x) {
                high = (int) mid - 1;
            } else {
                return (int) mid;
            }
        }
        return -1;
    }
}
