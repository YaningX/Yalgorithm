
public class Leet38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String nextRes = countAndSay(n - 1);
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < nextRes.length()) {
            int count = count(index, nextRes);
            sb.append(count);
            sb.append(nextRes.charAt(index));
            index += count;
        }
        return sb.toString();
    }

    private int count(int index, String str) {
        int count = 0;
        while ((index + count) < str.length() && str.charAt(index) == str.charAt(index + count)) {
            count++;
        }
        return count;
    }
}
