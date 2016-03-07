package btree;

import java.util.Stack;

/**
 * Created by xuyaning on 7/3/16.
 */
public class Leet331 {
    public boolean isValidSerialization(String preorder) {
        if (preorder.length() == 0) {
            return false;
        }
        String[] strs = preorder.split(",");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("#")) {
                while (stack.size() > 1 && stack.peek().equals("#")) {
                    stack.pop();
                    if (stack.peek().equals("#")) {
                        return false;
                    }
                    stack.pop();
                }
            }
            stack.push(strs[i]);
        }
        return stack.size() == 1 && stack.pop().equals("#");
    }
}
