package dp;

/**
 * http://liangjiabin.com/blog/2015/04/leetcode-best-time-to-buy-and-sell-stock.html
 */
public class Leet188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) return 0;

        int days = prices.length;
        if (k >= days) return maxProfit2(prices);

        int[][] local = new int[days][k + 1];
        int[][] global = new int[days][k + 1];

        for (int i = 1; i < days ; i++) {
            int diff = prices[i] - prices[i - 1];

            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(global[i - 1][j - 1], local[i - 1][j]) + diff;
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }

        return global[days - 1][k];
    }


    public int maxProfit2(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }
}
