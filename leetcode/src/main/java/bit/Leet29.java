package bit;

public class Leet29 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MIN_VALUE;
        }
        int result = 0;
        long dend = (long) dividend;
        long dsor = (long) divisor;
        dend = Math.abs(dividend);
        dsor = Math.abs(divisor);
        boolean isPositive = (dividend ^ divisor) >>> 31 == 0? true: false;
        int count = 0;
        while (dsor <= (dend >> 1)) {
            dsor <<= 1;
            count++;
        }
        while (count >= 0) {
            if (dend >= dsor) {
                dend -= dsor;
                result += 1 << count;
            }
            dsor >>= 1;
            count--;
        }
        return isPositive? result: -result;
    }
}
