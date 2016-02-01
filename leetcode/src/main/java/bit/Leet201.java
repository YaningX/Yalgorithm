package bit;

/**
 * Created by xuyaning on 1/2/16.
 */
public class Leet201 {
    public int rangeBitwiseAnd(int m, int n) {
        int bit = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            bit++;
        }
        return m << bit;
    }
}
