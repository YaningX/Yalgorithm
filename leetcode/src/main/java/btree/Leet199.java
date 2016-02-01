package btree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by xuyaning on 1/2/16.
 */
public class Leet199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        dfs(root, 0, map);
        for (int i = 0; i < map.size(); i++) {
            result.add(map.get(i));
        }
        return result;
    }

    private void dfs(TreeNode root, int depth, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(depth)) {
            map.put(depth, root.val);
        }
        dfs(root.right, depth + 1, map);
        dfs(root.left, depth + 1, map);
    }
}
