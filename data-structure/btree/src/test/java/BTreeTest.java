import org.junit.Before;
import org.junit.Test;

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

    }

}
