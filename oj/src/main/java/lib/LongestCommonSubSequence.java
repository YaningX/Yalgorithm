package lib;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  最长公共子序列LCS
 */
public class LongestCommonSubSequence {

    /**
     * 只求一个解
     * 讲解很清楚:
     * http://blog.csdn.net/yysdsyl/article/details/4226630/
     */
    public static String findLongestCommonSubSequence(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        int i = str1.length();
        int j = str2.length();
        StringBuilder sb = new StringBuilder();
        while (dp[i][j] != 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.insert(0, str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else {
                j--;
            }
        }
        return sb.toString();
    }

    static class Status {
        int x, y;
        StringBuilder sb = new StringBuilder();
        public Status(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static List<String> findMultipleLCS(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        Queue<Status> queue = new LinkedList<Status>();
        queue.offer(new Status(str1.length(), str2.length()));
        List<String> result = new LinkedList<String>();
        while (!queue.isEmpty()) {
            Status status = queue.poll();
            if ((status.x <= 0 || status.y <= 0)) {
                if (status.sb.length() == dp[str1.length()][str2.length()]) {
                    result.add(status.sb.toString());
                }
                continue;
            }
            if (str1.charAt(status.x - 1) == str2.charAt(status.y - 1)) {
                status.sb.insert(0, str1.charAt(status.x - 1));
                status.x--;
                status.y--;
                queue.offer(status);
            } else {
                Status statusleft = new Status(status.x - 1, status.y);
                statusleft.sb = new StringBuilder(status.sb.toString());
                Status statusup = status;
                statusup.y--;
                queue.offer(statusleft);
                queue.offer(statusup);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(LongestCommonSubSequence.findLongestCommonSubSequence("abcbdab", "bdcaba"));
        List<String> result = LongestCommonSubSequence.findMultipleLCS("abcbdab", "bdcaba");
        for (String str: result) {
            System.out.println(str);
        }
    }
}
