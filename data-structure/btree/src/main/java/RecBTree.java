import java.util.List;

/**
 * Implment BTree by using recursive trick.
 */
public class RecBTree<K extends Comparable<K>, V> extends AbstractBTree<K, V> {

    @Override
    public void add(BTNode<K, V> btNode) {
        root = doAdd(root, btNode);
    }

    private BTNode<K, V> doAdd(BTNode<K, V> root, BTNode<K, V> btNode) {
        if (root == null) {
            return btNode;
        }
        int cmp = root.getKey().compareTo(btNode.getKey());
        if (cmp > 0) {
            root.setLeftChild(doAdd(root.getLeftChild(), btNode));
        } else if (cmp < 0) {
            root.setRightChild(doAdd(root.getRightChild(), btNode));
        } else {
            root.setValue(btNode.getValue());
        }
        return root;
    }

    @Override
    public V get(K key) throws Exception {
        return doGet(root, key).getValue();
    }

    private BTNode<K, V> doGet(BTNode<K, V> root, K key) throws Exception {
        if (root == null) {
            throw new Exception();
        }
        int cmp = root.getKey().compareTo(key);
        if (cmp == 0) {
            return root;
        } else if (cmp > 0) {
            return doGet(root.getLeftChild(), key);
        } else {
            return doGet(root.getRightChild(), key);
        }
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
