package string;

/**
 * Created by xuyaning on 24/1/16.
 */
public class Leet125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char lch = s.charAt(left);
            char rch = s.charAt(right);
            if (!Character.isDigit(lch) && !Character.isAlphabetic(lch)) {
                left++;
                continue;
            }
            if (!Character.isDigit(rch) && !Character.isAlphabetic(rch)) {
                right--;
                continue;
            }
            if (lch == rch) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
