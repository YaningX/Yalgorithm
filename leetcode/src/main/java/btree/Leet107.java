package btree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuyaning on 12/1/16.
 */
public class Leet107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(root, result, 0);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = result.size() - 1; i >= 0; i--) {
            ans.add(result.get(i));
        }
        return ans;
    }

    private void dfs(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) {
            return;
        }

        if (result.size() <= level) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(node.val);
            result.add(list);
        } else {
            List<Integer> list = result.get(level);
            list.add(node.val);
        }
        dfs(node.left, result, level + 1);
        dfs(node.right, result, level + 1);
    }
    //方法二,不需要逆序,用一个值存储最大level,如果当前level大于最大level就在index 为0的位置add该值,否则为倒置的相应位置.
}
