package com.github.yaningx.yalgorithm;

import java.util.NoSuchElementException;

/**
 * Representation:
 *      A linked list is represented by a pointer to the first node of the linked list.
 *The first node is called head(or first). If the linked list is empty, then value of head is NULL.
 *Each node in a list consists of at least two parts:
 *      1) data;
 *      2) pointer to the next node.
 *
 *Basic operations:
 *      1) insert: head, body, tail;
 *      2) delete: head, body, tail;
 *      3) other complex operations can be completed by the above two basic operations.
 *
 * Advantages over arrays:
 *      1) Dynamic size;
 *      2) Ease of insertion/deletion.
 * Drawbacks:
 *      1) Random access is not allowed;
 * Reference LinkedList.
 * @param <T>
 */
public class SinglyLinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public SinglyLinkedList() {

    }

    public int getSize() {
        return getSize(first);
    }

    public int getSize(Node<T> head) {
        int size = 0;
        Node<T> tNode = head;
        while (tNode != null) {
            tNode = tNode.next;
            size++;
        }
        return size;
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public boolean search(T val) {
        Node<T> tNode = first;
        while (tNode != null) {
            if (tNode.value.equals(val)) {
                return true;
            }
            tNode = tNode.next;
        }
        return false;
    }

    /**
     * 1) Initialize a node pointer, current = head.
     * 2) Do following while current is not NULL
     *      a) current->key is equal to the key being searched return true.
     *      b) current = current->next
     * 3) Return false
     * @param value
     */
    public void addLast(T value) {
        Node<T> newNode = new Node<T>(value, null);
        if (size == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public Iterator listIterator() {
        return new Iterator();
    }

    class Iterator implements java.util.Iterator<T> {
        private Node<T> next =  first;
        private int nextIndex;

        public boolean hasNext() {
            return nextIndex < size;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node<T> tmpNode = next;
            next = next.next;
            nextIndex++;
            return tmpNode.value;
        }
    }

    /**
     * reverse the singlylinkedlist
     * for example:
     * 1->3->5->9->0 =====>>  0->9->5->3->1
     * put next node at the first position of sublist.
     * @return
     */
    public void reverse() {
        first = reverse(first);
    }

    private Node<T> reverse(Node<T> node) {
        if (node == null) {
            return null;
        }
        Node<T> head = node;
        Node<T> end = node;
        Node<T> tNode;
        while (end.next != null) {
            tNode = end.next;
            end.next = tNode.next;
            tNode.next = head;
            head = tNode;
        }
        return head;
    }

    /**
     * detect whether there is a loop in the list;
     * @return
     */
    public boolean hasLoop() {
        Node<T> slowNode = first;
        Node<T> fastNode = first;
        while (fastNode != null) {
            if (fastNode == slowNode) {
                return true;
            }
            fastNode = fastNode.next;
            if (fastNode != null) {
                if (fastNode == slowNode) {
                    return true;
                }
                fastNode = fastNode.next;
                slowNode = slowNode.next;
            }
        }
        return false;
    }

    /**
     * *********************************************
     * To check if a singly linked list is palindrome.
     * for odd: [1, (size + 1) / 2], [(size + 1) / 2 + 1, size] // the second half list has one more node than the first half list;
     * for even: [1, size / 2], [size / 2 + 1, size] ==> [1, (size + 1) / 2], [(size + 1) / 2 + 1, size]
     * @return
     */
    public boolean isPalindrome() {
        int size = getSize();
        if (size == 0 || size == 1) {
            return true;
        }
        Node<T> head = first;
        Node<T> midNode = first;
        int num = 1;
        while (num != (size + 1) / 2) {
            midNode = midNode.next;
            num++;
        }

        Node<T> secondHead = midNode.next;
        secondHead = reverse(secondHead);
        Node<T> tNode = secondHead;
        while (tNode != null) {
            if (!tNode.value.equals(head.value)) {
                return false;
            }
            tNode = tNode.next;
            head = head.next;
        }
        return true;
    }

    /**
     * Return the intersection of two singly linked lists.
     *  1) use two loops;
     *  2) mark one linked list using additional resource;
     *  3) calculate the distance of two linked lists.
     *  4£©make a circle in the first list.
     * @param head1
     * @param head2
     * @return
     */
    public T getIntersection(Node<T> head1, Node<T> head2) {
        int differ = getSize(head1) - getSize(head2);
        if (differ > 0) {
            while (differ != 0) {
                head1 = head1.next;
                differ--;
            }
        }
        if (differ < 0) {
            while (differ != 0) {
                head2 = head2.next;
                differ++;
            }
        }
        while (head1 != null) {
            if (head1 == head2) {
                return head1.value;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }

    /************************************************
     * Swap nodes pairwise
     *      1) 1->2->3->4->5      2->1->4->3->5
     *      2) 1->2->3->4->5->6     2->1->4->3->6->5
     */
    public void pairSwap() {
        first = pairSwap(first);
    }

    private Node<T> pairSwap(Node<T> head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node<T> tNode = head.next;
        head.next = tNode.next;
        tNode.next = head;
        head = tNode;
        Node<T> preNode = head.next;

        while (preNode.next != null && preNode.next.next != null) {
            tNode = preNode.next;
            preNode.next = tNode.next;
            tNode.next = preNode.next.next;
            preNode.next.next = tNode;
            preNode = preNode.next.next;
        }
        return head;
    }
}
