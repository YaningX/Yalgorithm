package hihocoder;

import java.util.Scanner;

public class SupplementaryCard {

    public static int handle(int[] nums, int k) {
        if (nums.length <= k) {
            return 100;
        }

        int result = nums[k] - 1;
        for (int i = 1; i + k + 1 < nums.length; i++) {
            result = Math.max(result, nums[i + k + 1] - nums[i] - 1);
        }

        result = Math.max(result, 100 - nums[nums.length - k - 1] - 1);
        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int M = in.nextInt();
            int[] nums = new int[N];
            for (int j = 0; j < N; j++) {
                nums[j] = in.nextInt();
            }
            System.out.println(handle(nums, M));
        }
    }
}
