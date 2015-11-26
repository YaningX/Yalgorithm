package string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

 * For example, given: s="barfoothefoobarman" & words=["foo", "bar"], return [0,9].
 *
 *
 * Key idea: Use a map as a dictionary to markdown the frequency of word in words.
 *          This dictionary is used as a windows. If this window doesn't match, adjust the window's left edge forwards.
 *
 */

public class Leet30 {


    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<Integer>();

        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return result;
        }

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word: words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        int len = words[0].length();
        for (int i = 0; i < len; i++) {
            int count = 0;
            int start = i;
            Map<String, Integer> currentMap = new HashMap<String, Integer>();
            for (int j = i; j <= s.length() - len; j += len) {
                String sub = s.substring(j, j + len);
                if (map.containsKey(sub)) {
                    if (currentMap.containsKey(sub)) {
                        currentMap.put(sub, currentMap.get(sub) + 1);
                    } else {
                        currentMap.put(sub, 1);
                    }

                    count++;

                    while (currentMap.get(sub) > map.get(sub)) {
                        String left = s.substring(start, start + len);
                        currentMap.put(left, currentMap.get(left) - 1);
                        count--;
                        start += len;
                    }

                    if (count == words.length) {
                        result.add(start);
                        String left = s.substring(start, start + len);
                        currentMap.put(left, currentMap.get(left) - 1);
                        count--;
                        start += len;
                    }
                } else {
                    currentMap.clear();
                    count = 0;
                    start = j + len;
                }
            }
        }
        return result;
    }

}
