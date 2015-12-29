import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubSetSumTest {
    @Test
    public void subsetSumTest() {
        int[] ints = new int[] {2, 4, 1, 6, 5};
        List<List<Integer>> resultList = SubSetSum.recSubsetSum(ints, 15);
        System.out.println(resultList);
    }

    @Test
    public void testList() {
        System.out.println(new NQueens().iteSolveNQueens(4).size());
    }


    @Test
    public void test() {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> list = new LinkedList<Integer>();
        list.add(1);
        result.add(list);
        list.add(2);
        System.out.println(result);
    }

    @Test
    public void testArray() {
        System.out.println(4<<1);
    }
}
