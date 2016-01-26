package stack;

/**
 * Created by xuyaning on 26/1/16.
 */
public class Leet155 {
    class MinStack {
        private Node top;
        public void push(int x) {
            if (top == null) {
                top = new Node(x);
                top.min = x;
            } else {
                Node node = new Node(x);
                node.min = Math.min(top.min, x);
                node.next = top;
                top = node;
            }
        }

        public void pop() {
            top = top.next;
        }

        public int top() {
            return top.val;
        }

        public int getMin() {
            return top.min;
        }

        class Node {
            int val;
            int min;
            Node next;
            Node(int x) {
                val = x;
            }
        }
    }

}
