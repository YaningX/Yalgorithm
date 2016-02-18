package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuyaning on 12/2/16.
 */
public class Leet3 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)));
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - left);
        }
        return res;
    }
}
