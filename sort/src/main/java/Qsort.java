/**
 * Not a stable sort, comparison.
 * Based on Divide-and-Conquer.
 *
 * Time Complexity T(n) = T(n/2) + n ==> O(nlogn),, Space Complexity O(1)
 * key idea: Select a pivot key in array[], usually key = array[0],
 * then the elements smaller than key are on key's left and the elements larger than key are on key's right.
 * It means key is on the right position of array[].
 *      How to implement it?
 *
 *
 * Base case: left == right.
 *
 */
public class Qsort implements Sort{
    public int[] sort(int[] numbers) {
        doRecQsort(numbers, 0, numbers.length - 1);
        return numbers;
    }

    //The idea of dichotomy has been used int quick sort.
    private void doRecQsort(int[] numbers, int left, int right) {
        if (left < right) {
            int pos = partition(numbers, left, right);
            doRecQsort(numbers, left, pos - 1);
            doRecQsort(numbers, pos + 1, right);
        }
    }

    private int partition(int[] numbers, int left, int right) {
        //事实上numbers[low]是第一个大于numbers[right]的数, 即numbers[right]应该处于的位置.
        int low = left;
        for (int i = left; i < right; i++) {
            if (numbers[i] <= numbers[right]) {
                int tmp = numbers[i];
                numbers[i] = numbers[low];
                numbers[low++] = tmp;
            }
        }
        int tmp = numbers[right];
        numbers[right] = numbers[low];
        numbers[low] = tmp;
        return low;
    }

    //fill the pit
    private int partition0(int[] numbers, int left, int right) {
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
