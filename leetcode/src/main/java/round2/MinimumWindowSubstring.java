package round2;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }

        Map<Character, Integer> sMap = new HashMap<Character, Integer>();
        int start = 0;
        int end = 0;
        int count = 0;
        String result = "";
        while (end < s.length()) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                if (sMap.containsKey(ch)) {
                    if (sMap.get(ch) < map.get(ch)) {
                        count++;
                    }
                    sMap.put(ch, sMap.get(ch) + 1);
                } else {
                    sMap.put(ch, 1);
                    count++;
                }

                if (count == t.length()) {
                    ch = s.charAt(start);
                    while (!map.containsKey(ch) || sMap.get(ch) > map.get(ch)) {
                        if (map.containsKey(ch)) {
                            sMap.put(ch, sMap.get(ch) - 1);
                        }
                        start++;
                        ch = s.charAt(start);
                    }
                    if (result.equals("") || result.length() > (end - start + 1)) {
                        result = s.substring(start, end + 1);
                    }
                }
            }

            end++;
        }
        return result;
    }
}
