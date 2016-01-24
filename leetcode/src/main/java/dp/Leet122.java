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
}
