package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuyaning on 9/1/16.
 */
public class Leet93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        dfs(s, new ArrayList<String>(), result);
        return result;
    }

    private void dfs(String string, List<String> current, List<String> result) {
        if (string.length() == 0 && current.size() == 4) {
            String str= current.get(0);
            for (int i = 1; i < 4; i++) {
                str = str + "." + current.get(i);
            }
            result.add(str);
            return;
        }
        if (current.size() >= 4) {
            return;
        }
        for (int i = 1; i <= 3 && i <= string.length(); i++) {
            String substr = string.substring(0, i);
            if (isValid(substr)) {
                current.add(substr);
                dfs(string.substring(i), current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isValid(String str) {
        if (str.length() != 1 && str.charAt(0) == '0') {//剔除 00 01的情况.
            return false;
        }
        return Integer.valueOf(str) <= 255;
    }
}
