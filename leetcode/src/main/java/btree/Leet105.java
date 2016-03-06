package btree;

/**
 * http://www.programcreek.com/2014/06/leetcode-construct-binary-tree-from-preorder-and-inorder-traversal-java/.
 */
public class Leet105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int k = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                k = i;
                break;
            }
        }
        root.left = dfs(preorder, preStart + 1, preStart + k - inStart, inorder, inStart, k - 1);
        root.right = dfs(preorder, preStart + k - inStart + 1, preEnd, inorder, k + 1, inEnd);
        return root;
    }
}
