package string;

/**
 * https://segmentfault.com/a/1190000003059361
 * http://blog.csdn.net/v_july_v/article/details/7041827
 */
public class Leet214 {
    public String shortestPalindrome(String s) {
        int comLength = getCommonLength(s);
        return new StringBuilder(s).reverse().substring(0, s.length() - comLength) + s;
    }

    private int getCommonLength(String s) {
        StringBuilder sb = new StringBuilder(s);
        String revS = sb.reverse().toString();
        s = s + "#" + revS;
        int[] com = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            int j = com[i - 1];
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = com[j - 1];
            }
            if (j == 0) {
                com[i] = s.charAt(i) == s.charAt(j) ? 1: 0;
            } else {
                com[i] = j + 1;
            }
        }
        return com[com.length - 1];
    }
}
