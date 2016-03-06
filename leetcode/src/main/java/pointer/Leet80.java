package pointer;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by xuyaning on 7/1/16.
 */
public class Leet80 {
    public int badRemoveDuplicates(int[] nums) {
        Map<Integer, Integer> counterMap = new TreeMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (counterMap.containsKey(nums[i])) {
                counterMap.put(nums[i], counterMap.get(nums[i]) + 1);
            } else {
                counterMap.put(nums[i], 1);
            }
        }

        int i = 0;
        for (Map.Entry<Integer, Integer> entry: counterMap.entrySet()) {
            nums[i++] = entry.getKey();
            if (entry.getValue() >= 2) {
                nums[i++] = entry.getKey();
            }
        }
        return i;
    }

    //use two pointers
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int fast = 1;
        int low = 1;
        int counter = 1;
        while (fast < nums.length) {
            if (nums[fast] == nums[fast - 1]) {
                if (counter == 1) {
                    nums[low++] = nums[fast];
                    counter++;
                }
                fast++;
            } else {
                nums[low++] = nums[fast++];
                counter = 1;
            }
        }
        return low;
    }

    //use two pointers
    public int removeDuplicates0(int[] nums) {
        int low = 0;
        for (int i = 0; i < nums.length; i++) {
            if (low - 2 >= 0 && nums[i] == nums[low - 2]) {
                continue;
            }
            nums[low++] = nums[i];
        }
        return low;
    }
}
