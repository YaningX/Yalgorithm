import org.junit.Test;

import java.util.ArrayList;
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
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.subList(3, list.size()));
    }
}
