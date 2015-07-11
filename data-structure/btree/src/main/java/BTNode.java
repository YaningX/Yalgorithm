import java.util.LinkedList;
import java.util.List;

/**
 * Node in a binary tree, include key/value/leftChild/rightChild.
 */
public class BTNode<K extends Comparable<K>, V> {
    private K key;
    private V value;
    private BTNode<K, V> leftChild;
    private BTNode<K, V> rightChild;

    public BTNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        List list = new LinkedList<String>();
        return this.value;
    }

    public void setLeftChild(BTNode<K, V> btNode) {
        this.leftChild = btNode;
    }

    public BTNode<K, V> getLeftChild() {
        return this.leftChild;
    }

    public void setRightChild(BTNode<K, V> btNode) {
        this.rightChild = btNode;
    }

    public BTNode<K, V> getRightChild() {
        return this.rightChild;
    }
}
