package map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuyaning on 27/1/16.
 */
public class Leet242 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        Map<Character, Integer> tMap = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                return false;
            } else {
                if (!tMap.containsKey(t.charAt(i))) {
                    tMap.put(t.charAt(i), 1);
                } else {
                    tMap.put(t.charAt(i), tMap.get(t.charAt(i)) + 1);
                    if (tMap.get(t.charAt(i)) > map.get(t.charAt(i))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
