package bit;

/**
 * Created by xuyaning on 1/2/16.
 */
public class Leet191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i <= 31; i++) {
            result += (n & 1);
            n >>= 1;
        }
        return result;
    }
}
