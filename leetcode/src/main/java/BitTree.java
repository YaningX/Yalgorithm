import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * an implementation of binary indexed tree
 * http://www.cnblogs.com/xudong-bupt/p/3484080.html
 */
public class BitTree {
    public List<Integer> tree = new ArrayList<Integer>();

    public BitTree() {}

    public BitTree(int[] nums) {
        for (int num: nums) {
            this.add(num);
        }
    }

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
        tree.add(num);
    }

    public void update(int k, int num) {
        int old = this.getElement(k);
        int diff = num - old;
        while (k < tree.size()) {
            tree.set(k, tree.get(k) + diff);
            int lowbit = (k ^ (k + 1)) & (k + 1);
            k += lowbit;
        }
    }

    public int getElement(int k) {
        int num = tree.get(k);
        if ((k & 1) == 0) {
            return num;
        }
        int pre = k - 1;
        int lowbit = (pre ^ (pre + 1)) & (pre + 1);
        while (pre >=0 & (pre + lowbit) == k) {
            num -= tree.get(pre);
            pre -= lowbit;
            lowbit = (pre ^ (pre + 1)) & (pre + 1);
        }
        return num;
    }

    public int getSum(int k) {
        int sum = 0;
        while (k >= 0) {
            sum += tree.get(k);
            int lowbit = (k ^ (k + 1)) & (k + 1);
            k -= lowbit;
        }
        return sum;
    }

    public static int[] toBitTree(int[] nums) {
        int[] tree = new int[nums.length];
        System.arraycopy(nums, 0, tree, 0, nums.length);
        for (int i = 0; i < nums.length; i++) {
            int lowbit = (i ^ (i + 1)) & (i + 1);
            int father = i + lowbit;
            if (father < nums.length) {
                tree[father] += tree[i];
            }
        }
        return tree;
    }

    public static void main(String[] argvs) {
        int[] nums = new int[] {1, 2, 3, -1, 4, 5, 6};
        int[] bitTree = BitTree.toBitTree(nums);
        System.out.println(Arrays.toString(bitTree));
        System.out.println(BinaryIndexedTreeUtils.getSum(bitTree, 4));

        BitTree binaryIndexTree = new BitTree(nums);
        System.out.println(binaryIndexTree.tree);

    }
}
