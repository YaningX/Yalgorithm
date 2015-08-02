/**
 * Not a stable sort, comparison.
 * Based on Divide-and-Conquer.
 *
 * key idea: Select a pivot key in array[], usually key = array[0],
 * then the elements smaller than key are on key's left and the elements larger than key are on key's right.
 * It means key is on the right position of array[].
 *      How to implement it?
 *
 *
 * Base case: left == right.
 *
 */
public class Qsort {
    public static int[] recQsort(int[] numbers) {
        int[] resArray = numbers.clone();
        doRecQsort(resArray, 0, numbers.length - 1);
        return resArray;
    }

    private static void doRecQsort(int[] numbers, int left, int right) {
        if (left < right) {
            int pos = partition(numbers, left, right);
            doRecQsort(numbers, left, pos - 1);
            doRecQsort(numbers, pos + 1, right);
        }
    }

    //more easy to code.
    private static int partition(int[] numbers, int left, int right) {
        int key = numbers[right];
        int low = left;
        for (int i = left; i < right; i++) {
            if (numbers[i] <= key) {
                int tmp = numbers[i];
                numbers[i] = numbers[low];
                numbers[low++] = tmp;
            }
        }
        //put key at the right position.
        numbers[right] = numbers[low];
        numbers[low] = key;
        return low;
    }

    //fill the pit
    private static int partition0(int[] numbers, int left, int right) {
        int low = left;
        int high = right;
        int key = numbers[right];
        while (low < high) {
            while(low < high) {
                if (numbers[low] > key) {
                    numbers[high] = numbers[low];
                    break;
                }
                low++;
            }
            while (low < high) {
                if (numbers[high] < key) {
                    numbers[low] = numbers[high];
                    break;
                }
                high--;
            }
        }
        numbers[low] = key;
        return low;
    }
}
