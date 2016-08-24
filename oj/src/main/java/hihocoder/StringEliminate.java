package hihocoder;

import java.util.Scanner;

public class StringEliminate {

    public static int handle(StringBuilder sb) {
        while (true) {
            StringBuilder tmp = new StringBuilder();
            int right = 0;
            while (right < sb.length()) {
                if (right + 1 < sb.length()) {
                    if (sb.charAt(right) == sb.charAt(right + 1)) {
                        char ch = sb.charAt(right);
                        while (right < sb.length() && sb.charAt(right) == ch) {
                            right++;
                        }
                    } else {
                        tmp.append(sb.charAt(right++));
                    }
                } else {
                    tmp.append(sb.charAt(right++));
                }
            }
            if (tmp.length() == sb.length()) {
                break;
            }
            sb = tmp;
        }
        return sb.length();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            String str = in.next();
            int result = Integer.MAX_VALUE;
            for (char ch = 'A'; ch <= 'C'; ch++) {
                for (int j = 0; j <= str.length(); j++) {
                    result = Math.min(result, handle(new StringBuilder(str).insert(j, ch)));
                }
            }
            System.out.println(str.length() + 1 - result);
        }
    }
}
