package map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuyaning on 30/1/16.
 */
public class Leet169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
                if (map.get(nums[i]) > nums.length / 2) {
                    return nums[i];
                }
            }
        }

        return nums[0];
    }
}
