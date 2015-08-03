package com.github.yaningx.yalgorithm;

import org.junit.Test;

import java.util.Iterator;

public class SinglyLinkedListTest {
    @Test
    public void listTest() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.reverse();
        Iterator iterator = linkedList.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
