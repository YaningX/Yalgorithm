package bit;

import java.util.*;

/**
 * Repeated DNA Sequences
 */
public class Leet187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new LinkedList<String>();
        if (s.length() <= 10) {
            return result;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        Set<Integer> set = new HashSet<Integer>();
        Set<String> resultSet = new HashSet<String>();
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            int ch = map.get(s.charAt(i));
            hash = (hash << 2) + ch;
            hash &= (1 << 20) - 1;
            if (i >= 9) {
                if (!set.contains(hash)) {
                    set.add(hash);
                } else {
                    resultSet.add(s.substring(i - 9, i + 1));
                }
            }
        }
        result.addAll(resultSet);
        return result;
    }
}
