package math;

/**
 * Created by xuyaning on 14/2/16.
 */
public class Leet9 {
    //反转之后是否相等
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        long y = 0;
        int z = x;
        while (z > 0) {
            y = 10 * y + z % 10;
            z /= 10;
        }
        return x == y;
    }
}
