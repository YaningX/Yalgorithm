import btree.InOrder;
import btree.PostOrder;
import btree.PreOrder;
import btree.TreeNode;
import org.junit.Test;
import recursive.FibNum;

import java.util.*;

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

    @Test
    public void testSetArray() {
        Set<Integer>[] sets = new Set[2];
        sets[0] = new HashSet<Integer>();
        sets[1] = new HashSet<Integer>();
        sets[0].add(1);
        sets[0].add(2);
        sets[1].add(3);
        sets[1].add(5);
        System.out.println(sets[0]);
    }

    @Test
    public void testStackClone() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        Stack<Integer> tmpStack = (Stack<Integer>) stack.clone();
        System.out.println(tmpStack);
    }

    @Test
    public void testString() {
        String str = "1235678";
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        System.out.println(sb.toString());
        int[] a = new int[0];
    }
}
