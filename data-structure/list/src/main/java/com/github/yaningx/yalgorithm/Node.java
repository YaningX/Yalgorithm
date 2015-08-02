package com.github.yaningx.yalgorithm;

public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public void setNext(Node<T> nextNode) {
        this.next = nextNode;
    }

    public Node<T> getNext() {
        return this.next;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Node)) {
            return false;
        }

        Node<T> node = (Node<T>) object;
        if (!value.equals(node.getValue())) {
            return false;
        }

        return true;
    }
}
