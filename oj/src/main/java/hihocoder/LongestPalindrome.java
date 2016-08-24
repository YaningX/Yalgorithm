package hihocoder;

import java.util.Scanner;

public class LongestPalindrome {

    public static int longestPalindrome(String str) {
        int[][] dp = new int[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            dp[i][i] = 1;
            if (i + 1 < str.length()) {
                if (str.charAt(i) == str.charAt(i + 1)) {
                    dp[i][i + 1] = 2;
                }
            }
        }

        for (int size = 3; size < str.length(); size++) {

        }

        return 0;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {

        }
        in.close();
    }
}
