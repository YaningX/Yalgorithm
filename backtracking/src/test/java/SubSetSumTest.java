import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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


}
