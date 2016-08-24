package round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int start = 0;
        result.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] != nums[i - 1]) {
                start = 0;
            }
            int size = result.size();
            for (int j = start; j < size; j++) {
                List<Integer> list = new ArrayList<Integer>(result.get(j));
                list.add(nums[i]);
                result.add(list);
            }
            start = size;
        }
        return result;
    }
}
