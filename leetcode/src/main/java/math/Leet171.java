package math;

/**
 * Created by xuyaning on 30/1/16.
 */
public class Leet171 {
    public int titleToNumber(String s) {
        int result = 0;
        if (s == null || s.length() == 0) {
            return result;
        }
        int exp = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            result += (s.charAt(i) - 'A' + 1) * exp;
            exp *= 26;
        }
        return result;
    }
}
