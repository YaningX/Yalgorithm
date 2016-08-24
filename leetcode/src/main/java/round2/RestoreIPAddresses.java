package round2;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/restore-ip-addresses/
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        dfs(s, new ArrayList<String>(), result);
        return result;
    }

    private void dfs(String s, List<String> current, List<String> result) {
        if (current.size() == 4 && s.length() == 0) {
            String str = current.get(0);
            for (int i = 0; i < 3; i++) {
                str = str + "." + current.get(i + 1);
            }
            result.add(str);
            return;
        }

        if (current.size() >= 4) {
            return;
        }

        for (int i = 1; i <= 3 && i <= s.length(); i++) {
            String str = s.substring(0, i);
            if (isValid(str)) {
                current.add(str);
                dfs(s.substring(i), current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isValid(String str) {
        if (str.charAt(0) == '0' && str.length() != 1) {
            return false;
        }
        int val = Integer.valueOf(str);
        return val < 256;
    }
}
