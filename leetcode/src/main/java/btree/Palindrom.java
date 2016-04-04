package btree;

/**
 * Created by xuyaning on 3/4/16.
 */
import java.lang.StringBuilder;
import java.util.*;
public class Palindrom {
    public static int longestPalindrome(String str) {
        if (str.length() < 2) {
            return str.length();
        }
        List<String> list = new ArrayList<String>();
        int max = 0;
        list.add("");
        for (int i = 0; i < str.length(); i++) {
            int size = list.size();
            for (int j = 0; j < size; j++) {
                String tmpStr = list.get(j) + str.charAt(i);
                list.add(tmpStr);
                if (Palindrom.isPalindrome(tmpStr)) {
                    max = max > tmpStr.length()? max: tmpStr.length();
                }
            }
        }
        return max;
    }

    public static boolean isPalindrome(String str) {
        String reverse = new StringBuilder(str).reverse().toString();
        return str.equals(reverse);
    }

    public static void main(String[] argvs) {
        System.out.println(Palindrom.longestPalindrome(""));
        System.out.println(argvs.length);
    }

}