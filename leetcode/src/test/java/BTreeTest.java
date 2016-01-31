import btree.InOrder;
import btree.PostOrder;
import btree.PreOrder;
import btree.TreeNode;
import org.junit.Test;
import recursive.FibNum;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xuyaning on 31/1/16.
 */
public class BTreeTest {
    private TreeNode buildBTree() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        return root;
    }

    @Test
    public void preOrder() {
        TreeNode root = buildBTree();
        List<Integer> result = new PreOrder().preOrder(root);
        System.out.println(result);
    }

    @Test
    public void inOrder() {
        TreeNode root = buildBTree();
        List<Integer> result = InOrder.inOrder(root);
        System.out.println(result);
    }

    @Test
    public void postOrder() {
        TreeNode root = buildBTree();
        List<Integer> result = PostOrder.postOrder(root);
        System.out.println(result);
    }

    @Test
    public void testFibNum() {
        System.out.println(FibNum.fibnumLoop(15));
        System.out.println(FibNum.fibnum(15));
    }

    @Test
    public void testArray() {
        int[][] array = {
                {1, 2, 3},
                {2, 3, 4}
        };
        System.out.println(array.length);
        System.out.println(array[0].length);
    }
}
