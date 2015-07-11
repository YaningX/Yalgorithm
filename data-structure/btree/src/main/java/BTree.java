import java.util.List;

/**
 * A binary tree, include add/get/order operations, includes recursive and iterative implement
 */
public interface BTree<K extends Comparable<K>, V> {
    /**
     * Add a node into the existing binary tree, if key exists, then update the value.
     * @param btNode
     */
    void add(BTNode<K, V> btNode);

    /**
     * Get the value of the node of the key.
     * @param key
     * @return
     */
    V get(K key);

    /**
     * Traverse the binary tree in preorder.
     * @return
     */
    List<BTNode<K, V>> preorder();

    /**
     * Traverse btNode's subtree in preorder.
     * @param btNode
     * @return
     */
    List<BTNode<K, V>> preorder(BTNode<K, V> btNode);

    /**
     * Traverse the binary tree in inorder.
     * @return
     */
    List<BTNode<K, V>> inorder();

    /**
     * Traverse btNode's subtree in inorder.
     * @param btNode
     * @return
     */
    List<BTNode<K, V>> inorder(BTNode<K, V> btNode);

    /**
     * Traverse the binary tree in postorder.
     * @return
     */
    List<BTNode<K, V>> postorder();

    /**
     * Traverse btNode's subtree in postorder.
     * @param btNode
     * @return
     */
    List<BTNode<K, V>> postorder(BTNode<K, V> btNode);
}
