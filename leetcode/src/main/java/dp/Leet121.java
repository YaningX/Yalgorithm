package dp;

/**
 * 转化为求最大子序列和.
 */
public class Leet121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int[] diff = new int[prices.length - 1];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = prices[i + 1] - prices[i];
        }
        int max = 0;
        int sum = 0;
        for (int i = 0; i < diff.length; i++) {
            sum = Math.max(sum + diff[i], diff[i]);
            max = Math.max(sum, max);
        }
        return max;
    }

    public int maxProfit1(int[] prices) {
        int max = 0;
        int low = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            max = Math.max(max, prices[i] - low);
        }
        return max;
    }
}
