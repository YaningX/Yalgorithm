package math;

/**
 * Created by xuyaning on 14/2/16.
 */
public class Leet8 {
    public int myAtoi(String str) {
        long result = 0;
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int i = 0;
        boolean isPositive = false;
        if (str.charAt(i) == '+') {
            isPositive = true;
            i++;
        } else if (str.charAt(i) == '-') {
            isPositive = false;
            i++;
        } else {
            isPositive = true;
        }
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            result = result * 10 + str.charAt(i) - '0';
            if (-result < Integer.MIN_VALUE) {
                break;
            }
            i++;
        }
        if (!isPositive) {
            result *= -1;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }
}
