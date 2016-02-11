package math;

/**
 * Created by xuyaning on 11/2/16.
 */
public class Leet263 {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        while (num > 1 && num % 2 == 0) {
            num /= 2;
        }
        while (num > 1 && num % 3 == 0) {
            num /= 3;
        }
        while (num > 1 && num % 5 == 0) {
            num /= 5;
        }
        if (num > 1) {
            return false;
        } else {
            return true;
        }
    }
}
