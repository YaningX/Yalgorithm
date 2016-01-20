package btree;

/**
 * 平衡二叉树（Balanced Binary Tree）具有以下性质：它是一 棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树.
 */
public class Leet108 {
    /**
     * [Thoughts]
     * If we build BST from array, we can build it from top to bottom, like
     * 1. choose the middle one as root,
     * 2. build left sub BST via left part array
     * 3. build right sub BST via right part array
     * 4. do this recursively.
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, start, mid - 1);
        root.right = dfs(nums, mid + 1, end);
        return root;
    }
}
