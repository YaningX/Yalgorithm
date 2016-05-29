package poj;


import java.util.Scanner;

public class Y2KAccountingBug {

    public static void solve() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int s = in.nextInt();
            int d = in.nextInt();
            int result;
            if (d > 4 * s) {
                result = 10 * s - 2 * d;
            } else if (2 * d > 3 * s) {
                result = 8 * s - 4 * d;
            } else if (3 * d > 2 * s) {
                result = 6 * s - 6 * d;
            } else if (4 * d > s) {
                result = 3 * s - 9 * d;
            } else {
                result = -1;
            }
            if (result > 0) {
                System.out.println(result);
            } else {
                System.out.println("Deficit");
            }
        }
    }

    public static void main(String[] args) {
        Y2KAccountingBug.solve();
    }
}
