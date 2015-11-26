import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * producing all permutations of a set of values.
 */
public class Permutation {
    public static List<String> recPermutate(String str) {
        if (str.length() == 1) {
            List<String> initList = new LinkedList<String>();
            initList.add(str);
            return initList;
        }

        List<String> stringList = new LinkedList<String>();
        for (int i = 0; i < str.length(); i++) {
            StringBuilder sb = new StringBuilder(str);
            List<String> innerList = recPermutate(sb.deleteCharAt(i).toString());
            for (String substring : innerList) {
                stringList.add(str.charAt(i) + substring);
            }
        }
        return stringList;
    }

}
