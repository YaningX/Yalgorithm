import org.junit.Test;

import java.util.Arrays;

public class SortTest {
    private int[] array = new int[] {1, 5, 3, 10, 3, 5, 0, 2, 9, -1};

    private void process(Sort sort) {
        int[] resArray = sort.sort(array);
        System.out.println(Arrays.toString(resArray));
    }

    @Test
    public void heapSortTest() {
        Sort sort = new HeapSort();
        process(sort);
        int x = Integer.MIN_VALUE;
        System.out.println((long)8);
        int[][] array = new int[7][7];
        System.out.print(array.length);
    }

    @Test
    public void bubbleSortTest() {
        Sort sort = new BubbleSort();
        process(sort);
    }

    @Test
    public void countingSortTest() {
        Sort sort = new CountingSort();
        process(sort);
    }

    @Test
    public void mergeSortTest() {
        Sort sort = new MergeSort();
        process(sort);
    }

    @Test
    public void qSortTest() {
        Sort sort = new Qsort();
        process(sort);
    }

    @Test
    public void bucketSort() {
        Sort sort = new BucketSort();
        process(sort);
    }

    @Test
    public void testSplit() {
        String s = "a b  c     dd";
        String[] strings = s.split("\\s+");
        for (String string: strings) {
            System.out.println(string);
        }
    }

    @Test
    public void testThread() throws InterruptedException {
        Thread t1 = new SleepThread();
        t1.start();
       // t1.join();
        Thread.sleep(1000);
        Thread t2 = new SleepThread();
        t2.start();
        //t2.join();
        Thread.sleep(10000);
    }

    static class SleepThread extends Thread {
        private static int count = 0;
        private synchronized void doSleep() throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + " start " + count);
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " end " + count);
        }
        public void run() {
            try {
                doSleep();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
