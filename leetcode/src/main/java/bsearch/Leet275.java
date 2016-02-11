package bsearch;

/**
 * Created by xuyaning on 11/2/16.
 */
public class Leet275 {
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length - 1;
        int hIndex = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = citations.length - mid;
            if (citations[mid] == count) {
                return count;
            } else if (citations[mid] > count) {
                hIndex = Math.max(hIndex, count);
                right = mid - 1;
            } else {
                hIndex = Math.max(hIndex, citations[mid]);
                left = mid + 1;
            }
        }
        return hIndex;
    }
}
