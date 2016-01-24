package dp;

/**
 * Created by xuyaning on 24/1/16.
 */
public class Leet123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[] dp1 = new int[prices.length];
        int[] dp2 = new int[prices.length];
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            dp1[i] = Math.max(dp1[i - 1], prices[i] - min);
        }
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            dp2[i] = Math.max(dp2[i + 1], max - prices[i]);
        }
        int best = 0;
        for (int i = 0; i < dp1.length; i++) {
            best = Math.max(best, dp1[i] + dp2[i]);
        }
        return best;
    }
}
