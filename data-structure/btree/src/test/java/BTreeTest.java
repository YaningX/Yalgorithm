import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Random;

/**
 * Test for BTree.
 */
public class BTreeTest {
    private BTree<Integer, Integer> bTree;
    @Before
    public void initializeBTree() {
        this.bTree = new RecBTree();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            BTNode<Integer, Integer> btNode = new BTNode<Integer, Integer>(random.nextInt(100), random.nextInt(100));
            bTree.add(btNode);
            System.out.print(" " + btNode.getKey() + " ");
        }
    }

    @Test
    public void btNodeTest() throws Exception {
        BTNode<Integer, Integer> btNode = new BTNode<Integer, Integer>(13, 15);
        this.bTree.add(btNode);
        System.out.println(bTree.get(13));
    }

    @Test
    public void addBTNodeTest() {
        Pair<Integer, Integer> pair = new Pair<Integer, Integer>(1, 2);
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());
    }

    @Test
         public void preoderTest() {
        List<BTNode<Integer, Integer>> nodeList = bTree.preorder();
        for (BTNode<Integer, Integer> node : nodeList) {
            System.out.print(" " + node.getKey() + " ");
        }
    }

    @Test
    public void inoderTest() {
        List<BTNode<Integer, Integer>> nodeList = bTree.inorder();
        for (BTNode<Integer, Integer> node : nodeList) {
            System.out.print(" " + node.getKey() + " ");
        }
    }

    @Test
    public void postoderTest() {
        List<BTNode<Integer, Integer>> nodeList = bTree.postorder();
        for (BTNode<Integer, Integer> node : nodeList) {
            System.out.print(" " + node.getKey() + " ");
        }
    }

    @Test
    public void getKthbigNodeTest() {
        BTNode<Integer, Integer> node = bTree.getKthbigNode(2);
        System.out.println();
        System.out.println(node.getKey());
    }

    @Test
    public void getKthsmallNodeTest() {
        BTNode<Integer, Integer> node = bTree.getKthsmallNode(1);
        System.out.println();
        System.out.println(node.getKey());
    }
}
