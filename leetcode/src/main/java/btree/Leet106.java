package btree;

/**
 * Created by xuyaning on 14/1/16.
 */
public class Leet106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return bottomUp(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode bottomUp(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd) {
        if (inStart > inEnd || poStart > poEnd) {
            return null;
        }
        int val = postorder[poEnd];
        TreeNode p = new TreeNode(val);
        int k = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == val) {
                k = i;
                break;
            }
        }
        p.left = bottomUp(inorder, inStart, k - 1, postorder, poStart, poStart + (k - inStart) - 1);
        p.right = bottomUp(inorder, k + 1, inEnd, postorder, poEnd - (inEnd - k), poEnd - 1);
        return p;
    }
}
