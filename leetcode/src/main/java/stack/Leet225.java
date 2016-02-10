package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xuyaning on 10/2/16.
 */
public class Leet225 {
    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();

    // Push element x onto stack.
    public void push(int x) {
        if (queue1.isEmpty()) {
            queue1.offer(x);
            while(!queue2.isEmpty()) {
                queue1.offer(queue2.poll());
            }
        } else {
            queue2.offer(x);
            while (!queue1.isEmpty()) {
                queue2.offer(queue1.poll());
            }
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (!queue1.isEmpty()) {
            queue1.poll();
        } else {
            queue2.poll();
        }
    }

    // Get the top element.
    public int top() {
        if (!queue1.isEmpty()) {
            return queue1.peek();
        } else {
            return queue2.peek();
        }
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
