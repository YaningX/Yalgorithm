package string;

/**
 * Created by xuyaning on 24/12/15.
 */
public class Leet43 {
    public String multiply(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();
        int[] digits = new int[n1.length() + n2.length()];
        for (int i = 0; i < n1.length(); i++) {
            for (int j = 0; j < n2.length(); j++) {
                digits[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            result.insert(0, digits[i] % 10);
            if (i + 1 < digits.length) {
                digits[i + 1] += digits[i] / 10;
            }
        }
        while (result.charAt(0) == '0' && result.length() != 1) {
            result.deleteCharAt(0);
        }
        return result.toString();
    }
}
