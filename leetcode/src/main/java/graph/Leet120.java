package graph;

import java.util.List;

/**
 * Created by xuyaning on 23/1/16.
 */
public class Leet120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int[] dp = new int[triangle.size() + 1];
        for (int i = 1; i <= triangle.size(); i++) {
            List<Integer> list = triangle.get(i - 1);
            dp[i] = dp[i - 1] + list.get(i - 1);
            for (int j = i - 1; j > 0; j--) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + list.get(j - 1);
            }
            dp[0] = dp[0] + list.get(0);
        }
        int min = dp[0];
        for (int i = 1; i <= triangle.size(); i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }
}
