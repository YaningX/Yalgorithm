package btree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuyaning on 11/1/16.
 */
public class Leet98 {

    //中序遍历之后顺序递增
    public boolean isValidBST(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        dfs(root, result);
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i) >= result.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }

    public boolean isValidBST0(TreeNode root) {
        return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public boolean isValidBST(TreeNode p, double min, double max){
        if(p==null)
            return true;

        if(p.val <= min || p.val >= max)
            return false;

        return isValidBST(p.left, min, p.val) && isValidBST(p.right, p.val, max);
    }

    public boolean isValidBST1(TreeNode root) {
        long max = Long.MAX_VALUE;
        long min = Long.MIN_VALUE;
        return dfs(root, min, max);
    }

    private boolean dfs(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        if (!dfs(root.left, min, root.val) || !dfs(root.right, root.val, max)) {
            return false;
        }
        return true;
    }

}
