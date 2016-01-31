package math;

/**
 * Created by xuyaning on 30/1/16.
 */
public class Leet172 {
    public int trailingZeroes(int n) {
        int result = 0;
        int k = n / 5;
        while (k != 0) {
            result += k;
            k /= 5;
        }
        return result;
    }
}
