package round2;

/**
 * https://leetcode.com/problems/implement-strstr/.
 */
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        int[] next = getNext(needle);
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == needle.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    private int[] getNext(String str) {
        int[] next = new int[str.length()];
        if (str.length() == 0) {
            return next;
        }
        next[0] = -1;
        int k = -1;
        int i = 0;
        while (i < str.length() - 1) {
            if (k == -1 || str.charAt(k) == str.charAt(i)) {
                next[++i] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
