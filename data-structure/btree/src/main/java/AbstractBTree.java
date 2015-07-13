/**
 * Created by yaningxu on 7/6/2015.
 */
public abstract class AbstractBTree<K extends Comparable<K>, V> implements BTree<K,V> {
    protected BTNode<K, V> root;
}
