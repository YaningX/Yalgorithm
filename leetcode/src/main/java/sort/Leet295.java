package sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xuyaning on 12/2/16.
 */
public class Leet295 {
    class MedianFinder {
        Queue<Integer> minHeap = new PriorityQueue<Integer>();
        Queue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer x, Integer y) {
                return y - x;
            }

        });
        // Adds a number into the data structure.
        public void addNum(int num) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.offer(maxHeap.poll());
            }
        }

        // Returns the median of current data stream
        public double findMedian() {
            return minHeap.size() == maxHeap.size() ? (double) (minHeap.peek() + maxHeap.peek()) / 2.0 : maxHeap.peek();
        }
    };
}
