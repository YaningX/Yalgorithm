package math;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xuyaning on 10/2/16.
 */
public class Leet229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new LinkedList<Integer>();
        if (nums.length == 0) {
            return result;
        }
        int num1 = nums[0];
        int num2 = nums[0];
        int count1 = 0;
        int count2 = 0;
        for (int num: nums) {
            if ((count1 == 0 || num1 == num)) {
                if (count2 != 0 && num2 == num) {
                    count2++;
                    continue;
                }
                num1 = num;
                count1++;
            } else if (count2 == 0 || num2 == num) {
                num2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1) {
                count1++;
            } else if (nums[i] == num2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            result.add(num1);
        }
        if (count2 > nums.length / 3) {
            result.add(num2);
        }
        return result;
    }
}
