package bit;

/**
 * Created by xuyaning on 25/1/16.
 */
public class Leet136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num: nums) {
            result ^= num;
        }
        return result;
    }
}
