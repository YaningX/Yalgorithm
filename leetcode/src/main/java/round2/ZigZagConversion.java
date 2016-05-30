package round2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuyaning on 30/5/16.
 */
public class ZigZagConversion {
    /**
     * time O(n) space O(n)
     * @param s
     * @param numRows
     * @return
     */
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

    /**
     * time: O(n), space: O(n)
     * @param s
     * @param numRows
     * @return
     */
    public String convert0(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int row = 0;
        boolean down = true;
        for (int i = 0; i < s.length(); i++) {
            list.get(row).append(s.charAt(i));
            if (down) {
                if (row == numRows - 1) {
                    down = false;
                    row--;
                } else {
                    row++;
                }
            } else {
                if (row == 0) {
                    down = true;
                    row++;
                } else {
                    row--;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb: list) {
            res.append(sb);
        }
        return res.toString();
    }
}
