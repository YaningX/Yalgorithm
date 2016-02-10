package stack;

import java.util.Stack;

/**
 * Created by xuyaning on 10/2/16.
 */
public class Leet232 {
    class MyQueue {
        Stack<Integer> inStack = new Stack<Integer>();
        Stack<Integer> outStack = new Stack<Integer>();
        // Push element x to the back of queue.
        public void push(int x) {
            inStack.push(x);
        }

        private void move() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        // Removes the element from in front of queue.
        public void pop() {
            if (outStack.isEmpty()) {
                move();
            }
            outStack.pop();
        }

        // Get the front element.
        public int peek() {
            if (outStack.isEmpty()) {
                move();
            }
            return outStack.peek();
        }

        // Return whether the queue is empty.
        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }
}
