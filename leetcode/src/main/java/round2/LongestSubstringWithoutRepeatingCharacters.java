package round2;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * time O(n), space O(n)
     * (1) 哈希
     * (2) 双指针 + 滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int left = -1;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                left++;
                char lch = s.charAt(left);
                while (lch != ch) {
                    map.remove(lch);
                    left++;
                    lch = s.charAt(left);
                }
            }
            map.put(ch, i);
            result = Math.max(result, i - left);
        }
        return result;
    }


    /**
     * time O(n), space O(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring0(String s) {
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
