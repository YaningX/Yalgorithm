package btree;

/**
 * http://www.programcreek.com/2014/06/leetcode-construct-binary-tree-from-preorder-and-inorder-traversal-java/
 * 自下向上构建二叉树.
 */
public class Leet105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preStart = 0;
        int preEnd = preorder.length - 1;
        int inStart = 0;
        int inEnd = inorder.length - 1;
        return bottomUp(preorder, preStart, preEnd, inorder, inStart, inEnd);
    }

    private TreeNode bottomUp(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int val = preorder[preStart];
        TreeNode p = new TreeNode(val);
        int k = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (val == inorder[i]) {
                k = i;
                break;
            }
        }
        p.left = bottomUp(preorder, preStart + 1, preStart + k - inStart, inorder, inStart, k - 1);
        p.right = bottomUp(preorder, preStart + k - inStart + 1, preEnd, inorder, k + 1, inEnd);
        return p;
    }
}
