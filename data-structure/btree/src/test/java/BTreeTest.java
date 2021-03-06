import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

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

    @Test
    public void testCases() {
        System.out.println("12AVCD123....".toLowerCase());
        System.out.println(Character.isAlphabetic('a'));
        System.out.println(12 ^ 11);
    }

    @Test
    public void testMap() {
        Set<Node> set = new HashSet<Node>();
        Node node1 = new Node(1, 2);
        set.add(node1);
        Node node2 = new Node(1, 2);
        set.add(node2);
        System.out.println(set);
    }

    class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (! (object instanceof  Node)) {
                return false;
            }

            if (this.x == ((Node) object).x && this.y == ((Node) object).y) {
                return true;
            }
            return false;
        }
    }

    @Test
    public void testSet() {
        Set<Integer> set = new HashSet<Integer>();
        Integer integer1 = new Integer(1);

        set.add(integer1);
        System.out.println(set.contains(new Integer(1)));
        System.out.println((double) 1 / 0);
        Set<Character> set1 = new HashSet<Character>();
        set1.add(new Character('c'));
        set1.add(new Character('c'));
        System.out.println(set1.size());
        System.out.println(isAnagram("aacc", "ccac"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        Map<Character, Integer> tMap = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                return false;
            } else {
                if (!tMap.containsKey(t.charAt(i))) {
                    tMap.put(t.charAt(i), 1);
                } else {
                    tMap.put(t.charAt(i), tMap.get(t.charAt(i)) + 1);
                    if (tMap.get(t.charAt(i)) > map.get(t.charAt(i))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Test
    public void testStr() {
        String[] strings = new String[3];
        System.out.println(strings[0]);
        System.out.println((0.0 / 0.0) * 0);
        Collections.sort(new ArrayList<Integer>());
        System.out.println(Double.valueOf("1.3") + Double.valueOf("2.12"));
        String string = "12345";
        System.out.println(new StringBuilder(string).insert(1,"a").toString());
        int x = 1;
        System.out.println(2 << 0);

        System.out.println("ab cd ef ad".split(" ").length);
    }

    @Test
    public void testLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);
        System.out.println(linkedList);
        System.out.println(linkedList.poll());
        System.out.println(linkedList);
    }

    @Test
    public void testReverseStack() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        Collections.reverse(stack);
        System.out.println(stack);
        System.out.println(stack.pop());
    }

    @Test
    public void testPriorityQueue() {
        Queue<Integer> queue = new PriorityQueue<Integer>();
        queue.offer(1);
        queue.offer(-3);
        queue.offer(5);
        System.out.println(queue);
        //queue.poll();
        System.out.println(queue.peek());
        System.out.println(getDouble());
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(a));
        List<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.toString());
    }

    private double getDouble() {
        return 3;
    }

    @Test
    public void test() {
        int x = 123450;
        System.out.println(x);
        String y = "" + x;
        System.out.println(Long.valueOf(new StringBuilder(y).reverse().toString()));
    }

    @Test
    public void test1() {
        long x = 1;
        int y = 1;
        System.out.println(x == y);
        isMatch("aaa", "ab*a*c*a");
    }

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j <= p.length(); j++) {
            for (int i = 1; i <= s.length(); i++) {
                if (dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                    dp[i][j] = true;
                } else if (p.charAt(j - 1) == '*') {
                    if (dp[i - 1][j - 1]) {
                        int k = i;
                        while (k <= s.length() && (s.charAt(k - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            dp[k][j] = true;
                            k++;
                        }
                    }
                    if (dp[i - 1][j - 2]) {
                        dp[i - 1][j] = true;
                    }
                    if (dp[i][j - 2]) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

}
