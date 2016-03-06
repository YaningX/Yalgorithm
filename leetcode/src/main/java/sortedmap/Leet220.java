package sortedmap;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by xuyaning on 2/2/16.
 */
public class Leet220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0 || nums.length < 2) {
            return false;
        }
        SortedSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {
            SortedSet<Long> subset = set.subSet((long)nums[i] - t, (long)nums[i] + t + 1);
            if (!subset.isEmpty()) {
                return true;
            }
            if (set.size() == k) {
                set.remove((long)nums[i - k]);
            }
            set.add((long)nums[i]);
        }
        return false;
    }
}
