package bsearch;

/**
 * Created by xuyaning on 11/2/16.
 */
public class Leet287 {
    public int findDuplicate(int[] nums) {
        int n = nums.length-1;
        int low = 1, high= n;
        int mid = 0;
        while(low<high) {
            mid = low + (high-low)/2;
            int c= count(nums, mid); //count #numbers less than mid.
            if(c<=mid) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int count(int[] nums, int mid) {
        int c =0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]<=mid) c++;
        }
        return c;
    }
}
