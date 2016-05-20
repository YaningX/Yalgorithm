import java.util.Arrays;


public class BinaryIndexedTreeUtils {

    public static int[] getBITTree(int[] nums) {
        int[] tree = new int[nums.length];
        System.arraycopy(nums, 0, tree, 0, nums.length);
        for (int i = 0; i < tree.length; i++) {
            int lowbit = (i ^ (i + 1)) & (i + 1);
            int next = i + lowbit;
            if (next < tree.length) {
                tree[next] += tree[i];
            }
        }
        return tree;
    }

    public static int getSum(int[] tree, int k) {
        int sum = 0;
        while (k >= 0) {
            sum += tree[k];
            int lowbit = (k ^ (k + 1)) & (k + 1);
            k -= lowbit;
        }
        return sum;
    }

    public static int getValue(int[] tree, int k) {
        if ((k & 1) == 0) {
            return tree[k];
        }
        int num = tree[k];
        int pre = k - 1;

        while (pre >= 0 && (pre + ((pre ^ (pre + 1)) & (pre + 1)) == k)) {
            num -= tree[pre];
            pre = pre - ((pre ^ (pre + 1)) & (pre + 1));
        }
        return num;
    }

    public static void updateTree(int[] tree, int k, int val) {
        int old = BinaryIndexedTreeUtils.getValue(tree, k);
        int diff = val - old;
        while (k < tree.length) {
            tree[k] += diff;
            int lowbit = (k ^ (k + 1)) & (k + 1);
            k += lowbit;
        }
    }


    public static void main(String[] argvs) {
        int[] nums = new int[] {
                1, -1, 3, 2, 5, 2, 2
        };
        int[] tree = BinaryIndexedTreeUtils.getBITTree(nums);
        System.out.println(Arrays.toString(tree));
        System.out.println(BinaryIndexedTreeUtils.getSum(tree, 6));
        System.out.println(BinaryIndexedTreeUtils.getValue(tree, 6));
        BinaryIndexedTreeUtils.updateTree(tree, 0, 2);
        System.out.println(Arrays.toString(tree));
        System.out.println(BinaryIndexedTreeUtils.getSum(tree, 6));
    }

}
