package graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuyaning on 25/1/16.
 */
public class Leet133 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        map.put(node, newNode);
        dfs(node, newNode, map);
        return newNode;
    }

    private void dfs(UndirectedGraphNode node, UndirectedGraphNode newNode, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        List<UndirectedGraphNode> neighbors = node.neighbors;
        for (UndirectedGraphNode pNode: neighbors) {
            if (!map.containsKey(pNode)) {
                UndirectedGraphNode tmpNode = new UndirectedGraphNode(pNode.label);
                map.put(pNode, tmpNode);
                newNode.neighbors.add(tmpNode);
                dfs(pNode, tmpNode, map);
            } else {
                newNode.neighbors.add(map.get(pNode));
            }
        }
    }
}
