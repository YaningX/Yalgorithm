package lib;

/**
 * 查找最大公约数 --- 辗转相除法.
 */
public class GCD {

    public static int findGCD(int m, int n) {
        int remainder = m % n;
        while (remainder != 0) {
            m = n;
            n = remainder;
            remainder = m % n;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.print(GCD.findGCD(36, 96));
    }
}
