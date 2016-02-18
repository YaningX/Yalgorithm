package math;

/**
 * Created by xuyaning on 14/2/16.
 */
public class Leet7 {
    public int reverse(int x) {
        long y = (long) x;
        boolean isPositive = y >= 0? true: false;
        y = Math.abs(y);
        long z = Long.valueOf(new StringBuilder("" + y).reverse().toString());
        if (!isPositive) {
            z *= -1;
        }
        if (z > Integer.MAX_VALUE || z < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) z;
    }
}
