import java.util.*;

/**
 * leetcode 51. https://leetcode.com/problems/n-queens/
 */
public class NQueens {
    public List<List<String>> recSolveNQueens(int n) {
        List<List<String>> res = new LinkedList<List<String>>();
        doRecSolveNQueens(n, 0, new int[n], res);
        return res;
    }

    private void doRecSolveNQueens(int n, int row, int[] queens, List<List<String>> res) {
        if (row == n) {
            List<String> strList = new LinkedList<String>();
            for (int i = 0; i < n; i++) {
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[queens[i]] = 'Q';
                strList.add(new String(chars));
            }
            res.add(strList);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (check(row, col, queens)) {
                queens[row] = col;
                doRecSolveNQueens(n, row + 1, queens, res);
            }
        }
    }

    private boolean check(int row, int col, int[] queens) {
        int topLeft = col;
        int topRight = col;
        for (int i = row - 1; i >= 0; i--) {
            topLeft--;
            topRight++;
            if (queens[i] == topLeft || queens[i] == col || queens[i] == topRight) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> iteSolveNQueens(int n) {
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
                    if (check(row, col, queens)) {
                        List<Integer> currentQueens = new LinkedList<Integer>(queens);
                        currentQueens.add(col);
                        stack.push(currentQueens);
                    }
                }
            }
        }
        return res;
    }

    private boolean check(int row, int col, List<Integer> queens) {
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
}
