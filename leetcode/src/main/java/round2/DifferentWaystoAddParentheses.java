package round2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/different-ways-to-add-parentheses/
 */
public class DifferentWaystoAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        return new ArrayList<Integer>(dfs(input));
    }

    private List<Integer> dfs(String input) {
        int num = 0;
        int index = 0;
        while (index < input.length() && Character.isDigit(input.charAt(index))) {
            num = num * 10 + input.charAt(index++) - '0';
        }
        List<Integer> result = new ArrayList<Integer>();
        if (index == input.length()) {
            result.add(num);
            return result;
        }
        for (int i = index; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!Character.isDigit(ch)) {
                String strL = input.substring(0, i);
                String strR = input.substring(i + 1, input.length());
                List<Integer> setL = dfs(strL);
                List<Integer> setR = dfs(strR);
                for (int x: setL) {
                    for (int y: setR) {
                        result.add(compute(x, y, ch));
                    }
                }
            }
        }
        return result;
    }

    private int compute(int x, int y, char operator) {
        switch(operator) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new DifferentWaystoAddParentheses().diffWaysToCompute("2*3-4*5"));
    }

}
