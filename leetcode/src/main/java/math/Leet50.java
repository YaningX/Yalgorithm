package math;

/**
 * Created by xuyaning on 29/12/15.
 */
public class Leet50 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        } else if (n == Integer.MIN_VALUE) {
            return 1 / (myPow(x, -n - 1) * x);
        } else if (n < 0) {
            return 1 / myPow(x, -n);
        } else {
            double nextResult = myPow(x, n / 2);
            if (n % 2 == 0) {
                return nextResult * nextResult;
            } else {
                return nextResult * nextResult * x;
            }
        }
    }
}
