/**
 * 1) An integer sorting algorithm based on keys between a specific range (input).
 * 2) not a comparison sort algorithm, and faster than any comparison sorting algorithm.
 * 3) Key idea: for each element x, calculate the number of element which is less than x.
 *              Once we get it, we can put x in the right position.
 * Time complexity O(n + k). n is the input size & k is the input range.
 */
public class CountingSort implements Sort {
    @Override
    public int[] sort(int[] array) {
        array = array.clone();
        int[] resArray = new int[array.length];
        int min = array[0], max = array[0];
        for (int x : array) {
            if (min > x) {
                min = x;
            }

            if (max < x) {
                max = x;
            }
        }

        for (int i = 0; i < array.length; i++) {
            array[i] -= min;
        }

        int[] countArray = new int[max - min + 1];
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]]++;
        }


        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        for (int i = 0; i < array.length; i++) {
            resArray[countArray[array[i]] - 1] = array[i] + min;
            countArray[array[i]]--;
        }

        return resArray;
    }
}
