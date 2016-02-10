package bit;

/**
 * Created by xuyaning on 10/2/16.
 */
public class Leet231 {
    public boolean isPowerOfTwo(int n) {
        for (int i = 0; i < 31; i++) {
            if ((1 << i) == n) {
                return true;
            }
        }
        return false;
    }
}
