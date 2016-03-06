package dp;

/**
 * Created by xuyaning on 24/1/16.
 */
public class Leet122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int[] diff = new int[prices.length - 1];
        int result = 0;
        int sum = 0;
        for (int i = 0; i < diff.length; i++) {
            diff[i] = prices[i + 1] - prices[i];
        }
        for (int i = 0; i < diff.length; i++) {
            if (diff[i] > 0) {
                sum += diff[i];
            } else {
                result += sum;
                sum = 0;
            }
        }
        result += sum;
        return result;
    }

    public int maxProfit1(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            max = profit > 0 ? max + profit: max;
        }
        return max;
    }
}
