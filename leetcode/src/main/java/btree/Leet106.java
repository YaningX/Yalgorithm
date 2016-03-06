package btree;

/**
 * Created by xuyaning on 14/1/16.
 */
public class Leet106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return dfs(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode dfs(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int k = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[postEnd]) {
                k = i;
                break;
            }
        }
        root.left = dfs(inorder, inStart, k - 1, postorder, postStart, postStart + k - inStart - 1);
        root.right = dfs(inorder, k + 1, inEnd, postorder, postStart + k - inStart, postEnd - 1);
        return root;
    }
}
