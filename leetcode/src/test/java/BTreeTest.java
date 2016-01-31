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

    class Status {
        int num;
        int stage;
        public Status(int num, int stage) {
            this.num = num;
            this.stage = stage;
        }
    }
    private void add(int num, List<Integer> result) {
        Status status = new Status(0, 0);
        Stack<Status> statusStack = new Stack<Status>();
        statusStack.push(status);
        while (!statusStack.isEmpty()) {
            Status status1 = statusStack.pop();
            if (status1.num == 10) {
                continue;
            }
            switch (status1.stage) {
                case 0: {
                    result.add(status1.num);
                    statusStack.push(new Status(status1.num + 1, 0));
                    break;
                }
                default:
                    break;
            }
        }
    }

    @Test
    public void testAdd() {
        List<Integer> result = new ArrayList<Integer>();
        add(0, result);
        System.out.println(result);
    }

    @Test
    public void testFibNum() {
        System.out.println(FibNum.fibnumLoop(15));
        System.out.println(FibNum.fibnum(15));
    }
}
