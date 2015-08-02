package com.github.yaningx.yalgorithm;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Reference LinkedList.
 * @param <T>
 */
public class SinglyLinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public SinglyLinkedList() {

    }

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

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
        if (size == 0) {
            return;
        }

        Node<T> head = first;
        Node<T> end = first;
        while (end.next != null) {
            Node<T> tmp = end.next;
            end.next = tmp.next;
            tmp.next = head;
            head = tmp;
        }
        first = head;
        last = end;
    }
}
