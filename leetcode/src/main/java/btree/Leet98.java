package btree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuyaning on 11/1/16.
 */
public class Leet98 {
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
}
