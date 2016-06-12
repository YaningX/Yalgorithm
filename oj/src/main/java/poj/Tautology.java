package poj;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Tautology {

    /**
     * 输入字符串类似
     *      * 二叉树的先序遍历, 每个中间节点是一个云算符,每个叶子节点是一个变量
     *      * 计算的时候,需要先获得左右叶子节点,再获取根节点
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next().trim();
            if (str.equals("0")) {
                break;
            }
            System.out.println(Tautology.solve(str));
        }
    }

    public static String solve(String str) {

        boolean[] vals = new boolean[2];
        vals[0] = true;
        vals[1] = false;
        for (boolean p: vals) {
            for (boolean q: vals) {
                for (boolean r: vals) {
                    for (boolean s: vals) {
                        for (boolean t: vals) {
                            Map<Character, Boolean> map = new HashMap<Character, Boolean>();
                            map.put('p', p);
                            map.put('q', q);
                            map.put('r', r);
                            map.put('s', s);
                            map.put('t', t);
                            Stack<Boolean> stack = new Stack<Boolean>();
                            for (int i = str.length() - 1; i >= 0; i--) {
                                char ch = str.charAt(i);
                                if (map.containsKey(ch)) {
                                    stack.push(map.get(ch));
                                } else if (ch == 'K') {
                                    stack.push(stack.pop() & stack.pop());
                                } else if (ch == 'A') {
                                    stack.push(stack.pop() | stack.pop());
                                } else if (ch == 'N') {
                                    stack.push(!stack.pop());
                                } else if (ch == 'C') {
                                    stack.push(stack.pop() | (!stack.pop()));
                                } else if (ch == 'E') {
                                    stack.push(stack.pop() == stack.pop());
                                }
                            }
                            if (stack.size() != 1 || stack.pop() == false) {
                                return "not";
                            }
                        }
                    }
                }
            }
        }
        return "tautology";
    }
}
