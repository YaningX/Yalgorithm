package math;

/**
 * Created by xuyaning on 3/1/16.
 */
public class Leet67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        String longString;
        String shortString;
        if (a.length() >= b.length()) {
            longString = a;
            shortString = b;
        } else {
            longString = b;
            shortString = a;
        }

        int carry = 0;
        for (int i = 0; i < shortString.length(); i++) {
            int sum = longString.charAt(longString.length() - i - 1) - '0' + shortString.charAt(shortString.length() - i - 1) - '0' + carry;
            carry = sum / 2;
            sb.append(sum % 2);
        }

        for (int i = shortString.length(); i < longString.length(); i++) {
            int sum = longString.charAt(longString.length() - i - 1) - '0' + carry;
            carry = sum / 2;
            sb.append(sum % 2);
        }
        if (carry == 1) {
            sb.append(carry);
        }
        sb.reverse();
        return sb.toString();
    }
}
