/**
 * Created by xuyaning on 27/1/16.
 */
public class Fibonacci366 {
    public int fibonacci(int n) {
        // write your code here
        if (n <= 2) {
            return n - 1;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n -1];
    }
}
