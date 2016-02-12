package map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuyaning on 12/2/16.
 */
public class Leet290 {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<Character, String>();
        for (int i = 0; i < strs.length; i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if (map.containsValue(strs[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), strs[i]);
            } else {
                if (!map.get(pattern.charAt(i)).equals(strs[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
