package greedy;

/**
 * Created by xuyaning on 25/1/16.
 */
public class Leet135 {
    public int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        }
        int[] candies1 = new int[ratings.length];
        int[] candies2 = new int[ratings.length];
        candies1[0] = 1;
        for (int i = 1; i < candies1.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies1[i] = candies1[i - 1] + 1;
            } else {
                candies1[i] = 1;
            }
        }

        candies2[candies2.length - 1] = 1;
        for (int i = candies2.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies2[i] = candies2[i + 1] + 1;
            } else {
                candies2[i] = 1;
            }
        }
        int result = 0;
        for (int i = 0; i < ratings.length; i++) {
            result += Math.max(candies1[i], candies2[i]);
        }
        return result;
    }
}
