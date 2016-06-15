package lib;

/**
 * 最小公倍数---两个数的积除以最大公约数
 */
public class LCM {

    public static int findGCD(int m, int n) {
        int r = m % n;
        while (r != 0) {
            m = n;
            n = r;
            r = m % n;
        }
        return n;
    }

    public static int findLCM(int m, int n) {
        return m * n / LCM.findGCD(m, n);
    }

    public static void main(String[] args) {
        System.out.print(LCM.findLCM(18, 24));
    }
}
