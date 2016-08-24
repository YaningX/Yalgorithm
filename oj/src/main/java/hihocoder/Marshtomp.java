package hihocoder;

import java.util.Scanner;

public class Marshtomp {

    public static String handle(String str) {
        String lowStr = str.toLowerCase();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < lowStr.length()) {
            if (lowStr.startsWith("marshtomp", i)) {
                sb.append("fjxmlhx");
                i += 9;
            } else {
                sb.append(str.charAt(i++));
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            System.out.println(handle(str));
        }
        in.close();
    }
}
