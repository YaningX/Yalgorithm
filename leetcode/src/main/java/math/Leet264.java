package math;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xuyaning on 11/2/16.
 */
public class Leet264 {
    public int nthUglyNumber(int n) {
        int result = 1;
        Queue<Integer> queue2 = new LinkedList<Integer>();
        Queue<Integer> queue3 = new LinkedList<Integer>();
        Queue<Integer> queue5 = new LinkedList<Integer>();
        queue2.offer(1);
        queue3.offer(1);
        queue5.offer(1);
        for (int i = 0; i < n; i++) {
            result = Math.min(queue2.peek(), Math.min(queue3.peek(), queue5.peek()));
            if (result == queue2.peek()) {
                queue2.poll();
            }
            if (result == queue3.peek()) {
                queue3.poll();
            }
            if (result == queue5.peek()) {
                queue5.poll();
            }
            queue2.offer(result * 2);
            queue3.offer(result * 3);
            queue5.offer(result * 5);
        }
        return result;
    }
}
