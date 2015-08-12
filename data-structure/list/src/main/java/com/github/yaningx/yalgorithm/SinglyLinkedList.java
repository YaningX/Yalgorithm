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
        int size = 0;
        Node<T> tNode = first;
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
