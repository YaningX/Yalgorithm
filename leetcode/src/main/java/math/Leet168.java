package math;

/**
 * 将十进制数转换为26进制数.
 * http://www.cnblogs.com/ganganloveu/p/4175848.html
 */
public class Leet168 {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            int remainder = (n - 1) % 26;
            n = (n - 1) / 26;
            result.insert(0, (char) (remainder + 'A'));
        }
        return result.toString();
    }
}
