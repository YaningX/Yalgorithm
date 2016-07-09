/**
 * Divide and Conquer
 * a comparison sorting, 0(nlog(n)),
 * Can be stable.
 */
public class MergeSort implements Sort {
    //bottom up
    public int[] sort(int[] numbers) {
        for (int halfSize = 1; halfSize < numbers.length; halfSize *= 2) {
            int i = 0;
            while (i + 2 * halfSize <= numbers.length) {
                merge(numbers, i, i + halfSize - 1, i + 2 * halfSize - 1);
                i += (2 * halfSize);
            }

            if (i + halfSize -1 < numbers.length - 1) {
                merge(numbers, i, i + halfSize - 1, numbers.length - 1);
            }
        }
        return numbers;
    }

    //merge two parts of an array, [i, j] [j + 1, t]
    //Two sets: numbers[i, i + 1, ..., i + j - 1] and numbers[i + j, ....., t]
    private void merge(int[] numbers, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (numbers[i] <= numbers[j]) {
                tmp[k++] = numbers[i++];
            } else {
                tmp[k++] = numbers[j++];
            }
        }

        if (i > mid) {
            System.arraycopy(numbers, j, tmp, k, right - j + 1);
        } else {
            System.arraycopy(numbers, i, tmp, k, mid - i + 1);
        }

        System.arraycopy(tmp, 0, numbers, left, tmp.length);
    }
}
