package com.github.yaningx.yalgorithm;

import com.sun.scenario.effect.impl.prism.PrImage;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class SinglyLinkedListTest {
    private SinglyLinkedList<Integer> linkedList;

    @Before
    public void init() {
        linkedList = new SinglyLinkedList<Integer>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(6);
    }

    @Test
    public void reverseTest() {
        linkedList.reverse();
        Iterator iterator = linkedList.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void isPalindromeTest() {
        linkedList.addLast(6);
        linkedList.addLast(5);
        linkedList.addLast(4);
        linkedList.addLast(3);
        linkedList.addLast(2);
        linkedList.addLast(1);
        System.out.println(linkedList.isPalindrome());
    }

    @Test
    public void pairSwapTest() {
        linkedList.pairSwap();
        Iterator iterator = linkedList.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
