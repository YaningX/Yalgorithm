package btree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuyaning on 11/1/16.
 */
public class Leet103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(root, result, 0);
        return result;
    }

    private void dfs(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) {
            return;
        }
        if (level % 2 == 0) {
            if (result.size() <= level) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(root.val);
                result.add(list);
            } else {
                List<Integer> list = result.get(level);
                list.add(root.val);
            }
        } else {
            if (result.size() <= level) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(root.val);
                result.add(list);
            } else {
                List<Integer> list = result.get(level);
                list.add(0, root.val);
            }
        }
        dfs(root.left, result, level + 1);
        dfs(root.right, result, level + 1);
    }
}
