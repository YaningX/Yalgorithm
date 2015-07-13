import java.util.List;

/**
 * Implment BTree by using recursive trick.
 */
public class RecBTree<K extends Comparable<K>, V> extends AbstractBTree<K, V> {

    @Override
    public void add(BTNode<K, V> btNode) {
        doAdd(root, btNode);
    }

    private BTNode<K, V> doAdd(BTNode<K, V> root, BTNode<K, V> btNode) {
        if (root == null) {

        }

        if (root.getKey() > btNode.getKey())
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public List<BTNode<K, V>> preorder() {
        return null;
    }

    @Override
    public List<BTNode<K, V>> preorder(BTNode<K, V> btNode) {
        return null;
    }

    @Override
    public List<BTNode<K, V>> inorder() {
        return null;
    }

    @Override
    public List<BTNode<K, V>> inorder(BTNode<K, V> btNode) {
        return null;
    }

    @Override
    public List<BTNode<K, V>> postorder() {
        return null;
    }

    @Override
    public List<BTNode<K, V>> postorder(BTNode<K, V> btNode) {
        return null;
    }
}
