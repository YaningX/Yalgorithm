package graph;

import java.util.List;

/**
 * 有向图无向图区别在于你的邻边集合包含了对方的同时,对方的邻边邻边集合是否包含了你
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) {
        label = x;
    }
}
