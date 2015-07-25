/**
 * bubble sort, a comparison sorting, stable.
 * 1) 5 2 4 1 3
 *      a. 2 5 4 1 3
 *      b. 2 4 5 1 3
 *      c. 2 4 1 5 3
 *      d. 2 4 1 3 5
 * 2) 2 1 3 4 5 --> can be optimize.
 * 3) 2 1 3 4 5
 * 4) 1 2 3 4 5
 */
public class BubbleSort {
    public static int[] simplyBubbleSort(int[] numbers) {
        int[] resArray = numbers.clone();
        for (int i = 1; i < resArray.length; i++) {
            for (int j = 0; j < resArray.length - i; j++) {
                if (resArray[j] > resArray[j + 1]) {
                    int tmp = resArray[j];
                    resArray[j] = resArray[j + 1];
                    resArray[j + 1] = tmp;
                }
            }
        }
        return resArray;
    }

    /**
     * Here we don't use a flag to judge whether the array is sorted or not directly.
     * @param numbers
     * @return
     */
    public static int[] optimizedBubbleSort(int[] numbers) {
        int[] resArray = numbers.clone();
        int lastSwap = resArray.length - 1;
        while (lastSwap != -1) {
            int currentSwap = -1;
            for (int j = 0; j < lastSwap; j++) {
                if (resArray[j] > resArray[j + 1]) {
                    currentSwap = j;
                    int tmp = resArray[j];
                    resArray[j] = resArray[j + 1];
                    resArray[j + 1] = tmp;
                }
            }
            lastSwap = currentSwap;
        }
        return resArray;
    }
}
