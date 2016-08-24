package round2;

/**
 * https://leetcode.com/problems/count-and-say/
 */
public class CountandSay {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            char ch = res.charAt(0);
            int count = 1;
            for (int j = 1; j < res.length(); j++) {
                if (res.charAt(j) == ch) {
                    count++;
                } else {
                    sb.append(count).append(ch);
                    count = 1;
                    ch = res.charAt(j);
                }
            }
            sb.append(count).append(ch);
            res = sb.toString();
        }
        return res;
    }
}
