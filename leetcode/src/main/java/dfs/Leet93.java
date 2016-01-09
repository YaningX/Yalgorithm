package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuyaning on 9/1/16.
 */
public class Leet93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        List<String> candidate = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 16) {
            return result;
        }

        dfs(result, candidate, s, 0);
        return result;
    }

    private void dfs(List<String> result, List<String> candidate, String s, int start) {
        if (candidate.size() == 4) {
            if (start != s.length()) {
                return;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(candidate.get(0));
                for (int i = 1; i < candidate.size(); i++) {
                    sb.append(".");
                    sb.append(candidate.get(i));
                }
                result.add(sb.toString());
                return;
            }
        }

        for (int i = start; i < s.length() && i <= start + 3; i++) {
            String tmp = s.substring(start, i + 1);
            if (isValid(tmp)) {
                candidate.add(tmp);
                dfs(result, candidate, s, i + 1);
                candidate.remove(candidate.size() - 1);
            }

        }
    }

    private boolean isValid(String str) {
        if (str.charAt(0) == '0') { //剔除 00 01的情况.
            return str.length() == 1;
        }
        return Integer.valueOf(str) <= 255;
    }
}
