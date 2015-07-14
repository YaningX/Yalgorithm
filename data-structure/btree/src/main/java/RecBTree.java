import java.util.LinkedList;
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
        return preorder(root);
    }

    @Override
    public List<BTNode<K, V>> preorder(BTNode<K, V> btNode) {
        if (btNode == null) {
            return new LinkedList<BTNode<K, V>>();
        }
        List<BTNode<K, V>> preList = new LinkedList<BTNode<K, V>>();
        preList.add(btNode);
        preList.addAll(preorder(btNode.getLeftChild()));
        preList.addAll(preorder(btNode.getRightChild()));
        return preList;
    }

    @Override
    public List<BTNode<K, V>> inorder() {
        return inorder(root);
    }

    @Override
    public List<BTNode<K, V>> inorder(BTNode<K, V> btNode) {
        if (btNode == null) {
            return new LinkedList<BTNode<K, V>>();
        }
        List<BTNode<K, V>> inList = inorder(btNode.getLeftChild());
        inList.add(btNode);
        inList.addAll(inorder(btNode.getRightChild()));
        return inList;
    }

    @Override
    public List<BTNode<K, V>> postorder() {
        return postorder(root);
    }

    @Override
    public List<BTNode<K, V>> postorder(BTNode<K, V> btNode) {
        if (btNode == null) {
            return new LinkedList<BTNode<K, V>>();
        }
        List<BTNode<K, V>> postList = postorder(btNode.getLeftChild());
        postList.addAll(postorder(btNode.getRightChild()));
        postList.add(btNode);
        return postList;
    }

    @Override
    public BTNode<K, V> getKthbigNode(int k) {
        List<BTNode<K,V>> nodeList = doGetKthbigNode(root, k);
        return nodeList.get(k - 1);
    }

    private List<BTNode<K, V>>  doGetKthbigNode(BTNode<K, V> btnode, int k) {
        if (btnode == null) {
            return new LinkedList<BTNode<K, V>>();
        }
        List<BTNode<K,V>> nodeList = doGetKthbigNode(btnode.getRightChild(), k);
        if (nodeList.size() == k) {
            return nodeList;
        }
        nodeList.add(btnode);
        if (nodeList.size() == k) {
            return nodeList;
        }
        nodeList.addAll(doGetKthbigNode(btnode.getLeftChild(), k - nodeList.size()));
        return nodeList;
    }

    /**
     * Since the inorder result is an increasing order, we can implement it using it.
     */
    @Override
    public BTNode<K, V> getKthsmallNode(int k) {
        List<BTNode<K, V>> nodeList = doGetKthsmallNode(root, k);
        return nodeList.get(k - 1);
    }

    private List<BTNode<K, V>> doGetKthsmallNode(BTNode<K, V> btnode, int k) {
        if (btnode == null) {
            return new LinkedList<BTNode<K, V>>();
        }

        List<BTNode<K, V>> nodeList = doGetKthsmallNode(btnode.getLeftChild(), k);
        if (nodeList.size() == k) {
            return nodeList;
        }
        nodeList.add(btnode);
        if (nodeList.size() == k) {
            return nodeList;
        }
        nodeList.addAll(doGetKthsmallNode(btnode.getRightChild(), k - nodeList.size()));
        return nodeList;
    }

}
