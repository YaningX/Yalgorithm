package math;

/**
 * Created by xuyaning on 11/2/16.
 */
public class Leet274 {
    public int hIndex(int[] citations) {
        int hIndex = 0;
        if (citations.length == 0) {
            return hIndex;
        }
        int max = citations[0];
        for (int i = 1; i < citations.length; i++) {
            max = Math.max(max, citations[i]);
        }
        int[] h = new int[max + 1];
        for (int i = 0; i < citations.length; i++) {
            h[citations[i]]++;
        }
        int count = 0;
        for (int i = max; i >=0; i--) {
            count += h[i];
            if (count >= i) {
                return i;
            } else {
                hIndex = Math.max(hIndex, count);
            }
        }
        return hIndex;
    }
}
