package round2;

/**
 * Created by xuyaning on 23/7/16.
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int zIndex = 0, oIndex = 0, tIndex = 0;
        for (int num: nums) {
            if (num == 0) {
                nums[tIndex++] = 2;
                nums[oIndex++] = 1;
                nums[zIndex++] = 0;
            } else if (num == 1) {
                nums[tIndex++] = 2;
                nums[oIndex++] = 1;
            } else {
                nums[tIndex++] = 2;
            }
        }
    }
}
