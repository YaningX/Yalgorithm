import java.util.List;

/**
 * A binary tree, include add/get/order operations, includes recursive and iterative implement
 * @author 1234
 */
public interface BTree<K extends Comparable<K>, V> {
    /**
     * Add a node into the existing binary tree, if key exists, then update the value.
     * @param btNode, node to add
    */
    void add(BTNode<K, V> btNode);

    /**
     * Get the value of the node of the key.
     * @param key , key of the node
     * @return, value of the node
     */
    V get(K key) throws Exception;

    /**
     * Traverse the binary tree in preorder.
     * @return, print all nodes in preorder.
     */
    List<BTNode<K, V>> preorder();

    /**
     * Traverse btNode's subtree in preorder.
     * @param btNode, the node start.
     * @return, subtree of preorder.
     */
    List<BTNode<K, V>> preorder(BTNode<K, V> btNode);

    /**
     * Traverse the binary tree in inorder.
     * @return, print all nodes in ineorder.
     */
    List<BTNode<K, V>> inorder();

    /**
     * Traverse btNode's subtree in inorder, thus the output btNodes are in increasing order.
     * @param btNode ,
     * @return, 091
     */
    List<BTNode<K, V>> inorder(BTNode<K, V> btNode);

    /**
     * Traverse the binary tree in postorder.
     * @return, print all nodes in postorder.
     */
    List<BTNode<K, V>> postorder();

    /**
     * Traverse btNode's subtree in postorder.
     * @param btNode ,23
     * @return, print all nodes in postorder.
     */
    List<BTNode<K, V>> postorder(BTNode<K, V> btNode);

    /**
     * To get kth big node in this BTree.
     * @return, return the kth big node.
     */
    BTNode<K, V> getKthbigNode(int k);

    /**
     * To get kth small node in this BTree.
     * @return, return the kth small node.
     */
    BTNode<K, V> getKthsmallNode(int k);
}
