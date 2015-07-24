import org.junit.Test;

public class SubSetSumTest {

    @Test
    public void subSetSumTest() {
        int[] set = new int[] {1, 3, 4, 10, 5, 6};
        System.out.println(DPSubSetSum.dpSubsetSum(set, 19));
    }
}
