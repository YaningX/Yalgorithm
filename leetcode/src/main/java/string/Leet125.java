package string;

/**
 * Created by xuyaning on 24/1/16.
 */
public class Leet125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (!Character.isAlphabetic(leftChar) && !Character.isDigit(leftChar)) {
                left++;
                continue;
            }
            if (!Character.isAlphabetic(rightChar) && !Character.isDigit(rightChar)) {
                right--;
                continue;
            }
            if (leftChar != rightChar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
