package poj;

import java.util.Scanner;

/**
 * http://www.cnblogs.com/BlackStorm/p/5240201.html
 */
public class ThePilotsBrotherRefrigeator {

    public static void solve() {
        Scanner in = new Scanner(System.in);
        int[][] flip = new int[5][5];
        for (int i = 1; i <= 4; i++) {
            if (in.hasNextLine()) {
                String str = in.nextLine().trim();
                for (int j = 0; j < 4; j++) {
                    if (str.charAt(j) == '+') {
                        for (int k = 1; k <= 4; k++) {
                            flip[i][k] ^= 1;
                            flip[k][j + 1] ^= 1;
                        }
                        flip[i][j + 1] ^= 1;
                    }
                }
            }
        }
        int result = 0;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                if (flip[i][j] == 1) {
                    result++;
                }
            }
        }
        System.out.println(result);
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                if (flip[i][j] == 1) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }

    public static void main(String[] args) {
        ThePilotsBrotherRefrigeator.solve();
    }
}
