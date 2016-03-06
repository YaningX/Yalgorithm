package recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xuyaning on 9/1/16.
 */
public class Leet90 {
    /**
     * 输入:
     * [1,2,2,2]
     * 第0次:
     * []
     * 第1次:
     * [1]
     * 第2次:
     * [1,2]
     * [2]
     * 第三次:
     * [1,2,2]
     * [2,2]
     * 第四次:
     * [1,2,2,2]
     * [2,2,2]
     * 如果输入的nums[i] = nums[i - 1] (i != 0),那么从上轮输入基础上每个加nums[i],否则全部加nums[i]
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        result.add(new ArrayList<Integer>());
        int start = 0;
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
