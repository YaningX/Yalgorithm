
public class SegmentTree {

    private STNode root;

    public SegmentTree(int[] nums) {
        root = build(nums, 0, nums.length - 1);
    }

    private STNode build(int[] nums, int start, int end) {
        STNode ret = new STNode(start, end);
        if (start == end) {
            ret.sum = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            ret.left = build(nums, start, mid);
            ret.right = build(nums, mid + 1, end);
            ret.sum = ret.left.sum + ret.right.sum;
        }
        return ret;
    }

    public void update(int pos, int val) {
        update(root, pos, val);
    }

    private void update(STNode root, int pos, int val) {
        if (root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid) {
                update(root.left, pos, val);
            } else {
                update(root.right, pos, val);
            }
        }
    }

    public int sumRange(int start, int end) {
        return sumRange(root, start, end);
    }

    private int sumRange(STNode root, int start, int end) {
        if (root.start == start && root.end == end) {
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid) {
                return sumRange(root.left, start, end);
            } else if (start >= mid + 1) {
                return sumRange(root.right, start, end);
            } else {
                return sumRange(root.left, start, mid) + sumRange(root.right, mid + 1, end);
            }
        }
    }



    public static class STNode {
        int start, end;
        STNode left, right;
        int sum;

        public STNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        SegmentTree sTree = new SegmentTree(nums);
        System.out.println(sTree.sumRange(2, 3));
    }

}
