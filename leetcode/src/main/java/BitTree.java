import java.util.ArrayList;
import java.util.List;

/**
 * an implementation of binary indexed tree
 * http://www.cnblogs.com/xudong-bupt/p/3484080.html
 */
public class BitTree {
    private List<Integer> tree = new ArrayList<Integer>();

    public void add(int num) {
        int size = tree.size();
        if ((size & 1) == 0) {
            tree.add(num);
            return;
        }

        int pre = size - 1;
        while (pre >= 0 &&(pre + ((pre ^ (pre + 1)) & (pre + 1))) == size) {
            num += tree.get(pre);
            pre = pre - ((pre ^ (pre + 1)) & (pre + 1));
        }
    }

    public void update(int k, int num) {

    }

    public int getSum(int k) {
        return 0;
    }

    public static int[] toBitTree(int[] nums) {
        return new int[1];
    }
}
