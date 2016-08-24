package recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet78 {
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        subsets.add(new ArrayList<Integer>());
        for (int i = 0; i < S.length; i++) {
            int size = subsets.size();
            for (int j = 0; j < size; j++) {
                ArrayList<Integer> subset = new ArrayList<Integer>(
                        subsets.get(j));
                subset.add(S[i]);
                subsets.add(subset);
            }
        }
        return subsets;
    }
}
