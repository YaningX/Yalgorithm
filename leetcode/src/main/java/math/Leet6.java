package math;

/**
 * Created by xuyaning on 14/2/16.
 */
public class Leet6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int step = 2 * numRows - 2;
        //first row
        String result = "";
        for (int i = 0; i < s.length(); i += step) {
            result += s.charAt(i);
        }
        for (int i = 1; i < numRows - 1; i++) {
            for (int j = 0; i + j < s.length(); j += step) {
                result += s.charAt(i + j);
                if (j + step -  i < s.length()) {
                    result += s.charAt(j + step - i);
                }
            }
        }
        //last row
        for (int i = numRows - 1; i < s.length(); i += step) {
            result += s.charAt(i);
        }
        return result;
    }
}
