package round2;

/**
 * https://leetcode.com/problems/multiply-strings/
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int[] nums = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                nums[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int carry = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = carry + nums[i];
            nums[i] = sum % 10;
            carry = sum / 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.insert(0, nums[i]);
        }
        while (sb.length() != 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
