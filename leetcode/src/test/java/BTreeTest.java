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
public class BTreeTest extends ClassLoader{
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
        System.out.println((1 + 2) * 3 / 5);
        System.out.println(3 ^ (-3));
        System.out.println((5 & 1) == 1);
    }

    @Test
    public void testAssign() {
        int x = 1, y = 1;// x = y = 1非法
        System.out.println();
        List<Integer> list = new LinkedList<Integer>();
        for (int i: list) {

        }
    }

    @Test
    public void testCharacter() {
        String string = "abcdef";
        Character character = new Character('a');
        Character ch = new Character('a');
        System.out.println(character == string.charAt(0));
    }

    @Test
    public void testHashSet() {
        TreeNode node1 = new TreeNode(1);
        Set<TreeNode> set = new HashSet<TreeNode>();
        set.add(node1);
        TreeNode node2 = new TreeNode(1);
        System.out.println(node1.equals(node2));
    }


    @Test
    public void testAnd() {
        System.out.println(true & false);
    }
    @Test
    public void testFinally() {
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        String d = "ab" + "c";
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == d);
        System.out.println(c == d);
    }

    @Test
    public void testStatic() throws ClassNotFoundException {
        Thread.currentThread().getContextClassLoader().loadClass("Loader");
        Class.forName("Loader");
        System.out.println(Loader.class.getClassLoader());
        System.out.println(ClassLoader.class.getClassLoader());
    }

    @Test
    public void testTime() throws InterruptedException {
        long t0 = System.currentTimeMillis();
        Thread.sleep(1000);
        System.out.println((System.currentTimeMillis() - t0) / 1000 + " seconds");
        byte[] array = new byte[1314572800];
        System.out.println(array.length);

        for (int i = 0; i < 5; i++) {
            int k = 5;//不加花括号会出错
        }
    }

    @Test
    public void testP2O() {
        int[] array = new int[3];
        Integer[] brray = org.apache.commons.lang.ArrayUtils.toObject(array);
        List<Integer> list = Arrays.asList(brray);
        System.out.println(list);
    }

    @Test
    public void testList() {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        list1.add(1);
        list2.add(1);
        System.out.println(list1.equals(list2));
    }

    @Test
    public void testIn() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            System.out.println(in.nextLine());
        }
    }


    public static int getValue(String key, String code) {
        String result = "0";
        for (int i = 0; i < code.length(); i++) {
            char ch = code.charAt(i);
            int index = key.indexOf(ch);
            if (index > 0) {
                result += ((index + 1) % 10);
            }
        }
        return Integer.valueOf(result);
    }

    @Test
    public void testSubstitude() {
        System.out.println(BTreeTest.getValue("TRADINGFEW", "LGXWEV"));
        System.out.println(BTreeTest.getValue("ABCDEFGHIJ", "XJ"));
    }





}

class Loader {
    static {
        System.out.println("hello world");
    }
    public final void load() {
        return;
    }
}