package round2;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        for (int num: nums) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list = new ArrayList<Integer>(result.get(j));
                list.add(num);
                result.add(list);
            }
        }
        return result;
    }
}
