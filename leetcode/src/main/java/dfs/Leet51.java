package dfs;

import java.util.*;

/**
 * Created by xuyaning on 21/2/16.
 */
public class Leet51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<List<String>>();
        Stack<List<Integer>> stack = new Stack<List<Integer>>();

        for (int i = 0; i < n; i++) {
            List<Integer> queens = new ArrayList<Integer>(n);
            queens.add(i);
            stack.push(queens);
        }

        while (!stack.isEmpty()) {
            List<Integer> queens = stack.pop();
            if (queens.size() == n) {
                List<String> strList = new LinkedList<String>();
                for (int i = 0; i < n; i++) {
                    char[] chars = new char[n];
                    Arrays.fill(chars, '.');
                    chars[queens.get(i)] = 'Q';
                    strList.add(new String(chars));
                }
                res.add(strList);
            } else {
                int row = queens.size();
                for (int col = 0; col < n; col++) {
                    if (check(n, row, col, queens)) {
                        List<Integer> currentQueens = new LinkedList<Integer>(queens);
                        currentQueens.add(col);
                        stack.push(currentQueens);
                    }
                }
            }
        }
        return res;
    }
    private boolean check(int n, int row, int col, List<Integer> queens) {
        int topLeft = col;
        int topRight = col;
        for (int i = row - 1; i >= 0; i--) {
            topLeft--;
            topRight++;
            if (queens.get(i) == topLeft || queens.get(i) == col || queens.get(i) == topRight) {
                return false;
            }
        }
        return true;
    }





    public List<List<String>> solveNQueens0(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (n == 0) {
            return result;
        }
        dfs(result, n, 0, new ArrayList<Integer>());
        return result;
    }

    private void dfs(List<List<String>> result, int n, int row, List<Integer> queens) {
        if (row == n) {
            List<String> currentList = new LinkedList<String>();
            for (int queen: queens) {
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[queen] = 'Q';
                currentList.add(new String(chars));
            }
            result.add(currentList);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(n, i, queens)) {
                queens.add(i);
                dfs(result, n, row + 1, queens);
                queens.remove(queens.size() - 1);
            }
        }
    }

    private boolean isValid(int n, int col, List<Integer> queens) {
        int topLeft = col;
        int topRight = col;
        for (int i = queens.size() - 1; i >= 0; i--) {
            int queen = queens.get(i);
            topLeft--;
            topRight++;
            if (queen == col || queen == topLeft || queen == topRight) {
                return false;
            }
        }
        return true;
    }
}
