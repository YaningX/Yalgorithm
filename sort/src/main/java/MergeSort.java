/**
 * Divide and Conquer
 * a comparison sorting, nlog(n),
 * Can be stable.
 */
public class MergeSort implements Sort {
    //bottom up
    @Override
    public int[] sort(int[] numbers) {
        int[] resArray = numbers.clone();
        int k = 1;
        while (k < resArray.length) {
            int s = k;
            k = 2 * s;
            int i = 0;
            while (i + k <= resArray.length) {
                merge(resArray, i, i + s - 1, i + k - 1);
                i += k;
            }
            if (i + s - 1 < resArray.length - 1) {
                merge(resArray, i, i + s - 1, resArray.length - 1);
            }
        }
        return resArray;
    }

    //merge two parts of an array, [i, j] [j + 1, t]
    private void merge(int[] numbers, int i, int j, int t) {
        int[] tmpArray = new int[t - i + 1];
        int k = 0;
        int tmpi = i;
        int s = j + 1;
        while (tmpi <= j && s <= t) {
            if (numbers[tmpi] <= numbers[s]) {
                tmpArray[k++] = numbers[tmpi++];
            } else {
                tmpArray[k++] = numbers[s++];
            }
        }
        if (tmpi <= j) {
            while (k < tmpArray.length) {
                tmpArray[k++] = numbers[tmpi++];
            }
        }
        if (s <= t) {
            while (k < tmpArray.length) {
                tmpArray[k++] = numbers[s++];
            }
        }
        System.arraycopy(tmpArray, 0, numbers, i, tmpArray.length);
    }
}
