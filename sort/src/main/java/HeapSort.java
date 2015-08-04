/**
 * nlogn, not stable.
 * A max heap is a complete binary tree stored in an array numbers[], where numbers[i] >= numbers[2 * i + 1] && numbers[i] >= numbers[2 * i + 2], a recursive definition.
 *
 * Heap sort algorithm
 *      1) Build a max heap numbers[], using heapify process in bottom up order;
 *      2)
 *
 * Key point: heapify process, Heapify procedure can be applied to a node only if its children nodes are heapified.
 *           So the heapification must be performed in the bottom up order.
 */
public class HeapSort implements Sort {
    public int[] sort(int[] numbers) {
        int[] resArray = numbers.clone();
        buildMaxHeap(resArray);
        for (int i = resArray.length - 1; i >= 0; i--) {
            int tmp = resArray[0];
            resArray[0] = resArray[i];
            resArray[i] = tmp;
            maxHeapify(resArray, 0, i);
        }
        return resArray;
    }

    /**
     * The maxHeapify process: Compare the value of parentNode and its two child nodes and swap recursively.
     * Condition the sub-binary tree must be maxheapified.
     * @param numbers
     * @param parentIndex
     * @param heapSize
     */
    private void maxHeapify(int[] numbers, int parentIndex, int heapSize) {
        int leftchildIndex = 2 * parentIndex + 1;
        int rightchildIndex = 2 * parentIndex + 2;
        int largestIndex = parentIndex;

        if (leftchildIndex < heapSize && numbers[largestIndex] < numbers[leftchildIndex]) {
            largestIndex = leftchildIndex;
        }

        if (rightchildIndex < heapSize && numbers[largestIndex] < numbers[rightchildIndex]) {
            largestIndex = rightchildIndex;
        }

        if (largestIndex != parentIndex) {
            int tmp = numbers[parentIndex];
            numbers[parentIndex] = numbers[largestIndex];
            numbers[largestIndex] = tmp;
            maxHeapify(numbers, largestIndex, heapSize);
        }
    }

    /**
     * Heapify an array in bottom up order,
     * base case: the last layer in the binary tree/heap
     *            better: the last second layer in the binary tree/heap
     *            2 * parentIdex + 2 = heapSize ==> parentIndex = heapSize / 2 - 1
     *            or 2 * parentIdex + 3 = heapSize ==> parentIndex = heapSize/2 - 1
     *            So base case: parentIndex = heapSize / 2 - 1.
     *
     * @param numbers
     */
    private void buildMaxHeap(int[] numbers) {
        for (int parentIndex = numbers.length / 2 - 1; parentIndex >= 0; parentIndex--) {
            maxHeapify(numbers, parentIndex, numbers.length);
        }
    }
}
