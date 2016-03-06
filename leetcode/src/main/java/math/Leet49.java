package math;

import java.util.*;

/**
 * Created by xuyaning on 29/12/15.
 */
public class Leet49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Arrays.sort(strs);
        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<String>());
            }
            map.get(s).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
