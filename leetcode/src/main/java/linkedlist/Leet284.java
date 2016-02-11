package linkedlist;

import java.util.Iterator;

/**
 * Created by xuyaning on 11/2/16.
 */
public class Leet284 {
    // Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
    class PeekingIterator implements Iterator<Integer> {
        Integer val = null;
        Iterator<Integer> iterator;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (val == null) {
                val = iterator.next();
            }
            return val;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        public Integer next() {
            if (val == null) {
                val = iterator.next();
            }
            Integer value = val;
            val = null;
            return value;
        }
        
        public boolean hasNext() {
            return val != null || iterator.hasNext();
        }
    }
}
