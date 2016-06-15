package lib;

import java.util.*;

/**
 * 数组的最长递增子序列, 动态规划
 */
public class LongestIncreasingSubsequence {

    /**
     * 只求最长子序列的长度, 不需要打印出来
     * time O(nlogn), space O(n)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (tails[right] < nums[i]) {
                tails[++right] = nums[i];
            } else {
                tails[find(tails, right, nums[i])] = nums[i];
            }
        }
        return right + 1;
    }

    private int find(int[] tails, int right, int target) {
        int left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (tails[mid] == target) {
                return mid;
            } else if (target < tails[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    /**
     * 只输出一种最长子序列情况
     * http://blog.csdn.net/joylnwang/article/details/6766317
     * time O(n2), space O(n)
     * @param nums
     * @return
     */
    public static List<Integer> lengthOfLISOne(int[] nums) {
        List<Integer> result = new LinkedList<Integer>();
        if (nums.length == 0) {
            return result;
        }
        int[] dp = new int[nums.length];
        int[] pre = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(pre, -1);
        int max = 1;
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                    if (max < dp[i]) {
                        max = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }
        while (maxIndex != -1) {
            result.add(0, nums[maxIndex]);
            maxIndex = pre[maxIndex];
        }
        return result;
    }


    /**
     * 输出所有的最长子序列
     * @param nums
     * @return
     */
    public static List<List<Integer>> lengthOfLISMultiple(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length == 0) {
            return result;
        }
        List<List<Integer>>[] curlongest = new List[nums.length];
        for (int i = 0; i < nums.length; i++) {
            curlongest[i] = new ArrayList<List<Integer>>();
        }
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int subMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    subMax = Math.max(subMax, curlongest[j].get(0).size());
                }
            }
            if (subMax == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                curlongest[i].add(list);
            } else {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j] && curlongest[j].get(0).size() == subMax) {
                        for (List<Integer> tmp: curlongest[j]) {
                            List<Integer> newList = new ArrayList<>(tmp);
                            newList.add(nums[i]);
                            curlongest[i].add(newList);
                        }
                    }
                }
            }
            max = Math.max(max, curlongest[i].get(0).size());
        }
        for (int i = 0; i < nums.length; i++) {
            if (curlongest[i].get(0).size() == max) {
                result.addAll(curlongest[i]);
            }
        }

        return result;
    }



    public static void main(String[] args) {
        System.out.println(LongestIncreasingSubsequence.lengthOfLISOne(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(LongestIncreasingSubsequence.lengthOfLISMultiple(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
