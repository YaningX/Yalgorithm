package round2;

/**
 *
 */
public class LongestPalindromicSubstring {

    /**
     * time O(n2), space O(n2)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0;
        int end = 0;
        for (int k = 0; k < s.length(); k++) {
            for (int i = k; i >= 0; i--) {
                for (int j = k; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j) && ((j -i < 3) || dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                        if (j - i > end - start) {
                            start = i;
                            end = j;
                        }
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * time O(n2), space O(n)
     * @param s
     * @return
     */
    public String longestPalindrome0(String s) {
        boolean[][] dp = new boolean[3][];
        dp[0] = new boolean[s.length()];
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[0][i] = true;
            start = i;
            end = i + 1;
        }
        dp[1] = new boolean[s.length() - 1];
        for (int i = 0; i + 1 < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[1][i] = true;
                start = i;
                end = i + 2;
            }
        }

        for (int diff = 2; diff < s.length(); diff++) {
            dp[2] = new boolean[s.length() - diff];
            for (int i = 0; i + diff < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i + diff) && dp[diff & 1][i + 1]) {
                    dp[2][i] = true;
                    start = i;
                    end = i + diff + 1;
                }
            }
            dp[diff & 1] = dp[2];
        }

        return s.substring(start, end);
    }
}
