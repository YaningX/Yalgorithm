package string;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.lifeincode.net/programming/leetcode-minimum-window-substring-java/
 */
public class Leet76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> dict = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            Character ch = t.charAt(i);
            if (dict.containsKey(ch)) {
                dict.put(ch, dict.get(ch) + 1);
            } else {
                dict.put(ch, 1);
            }
        }

        int start = 0;
        int end = 0;
        Map<Character, Integer> found = new HashMap<Character, Integer>();
        int foundCounter = 0;
        int min = Integer.MAX_VALUE;
        String minWindow = "";
        while (end < s.length()) {
            Character c = s.charAt(end);
            if (dict.containsKey(c)) {
                if (!found.containsKey(c)) {
                    found.put(c, 1);
                    foundCounter++;
                } else {
                    if (found.get(c) < dict.get(c)) {
                        foundCounter++;
                    }
                    found.put(c, found.get(c) + 1);
                }
            }

            if (foundCounter == t.length()) {
                Character cs = s.charAt(start);
                while (!dict.containsKey(cs) || dict.get(cs) < found.get(cs)) {
                    if (dict.containsKey(cs) && dict.get(cs) < found.get(cs)) {
                        found.put(cs, found.get(cs) -  1);
                    }
                    start++;
                    cs = s.charAt(start);
                }
                if (end - start + 1 < min) {
                    minWindow = s.substring(start, end + 1);
                    min = minWindow.length();
                }
            }
            end++;
        }
        return minWindow;
    }
}
