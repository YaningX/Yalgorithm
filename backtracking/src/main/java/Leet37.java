import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leet37 {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9) {
            return;
        }
        List<Integer> emptyList = getEmptyList(board);
        doSolveSudoku(board, 0, emptyList);
    }

    private boolean doSolveSudoku(char[][] board, int index, List<Integer> emptyList) {
        if (index == emptyList.size()) {
            return true;
        }

        int row = emptyList.get(index) / 9;
        int col = emptyList.get(index) % 9;
        for (int i = 1; i <= 9; i++) {
            char ch = (char) (i + '0');
            if (checkValid(board, row, col, ch)) {
                board[row][col] = ch;
                if (doSolveSudoku(board, index + 1, emptyList)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }

    private boolean checkValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == ch || board[row][i] == ch) {
                return false;
            }
        }

        for (int i = row / 3 * 3; i <= row / 3 * 3 + 2; i++) {
            for (int j = col / 3 * 3; j <= col / 3 * 3 + 2; j++) {
                if (board[i][j] == ch) {
                    return false;
                }
            }
        }
        return true;
    }
    //mark down the empty place, use a one-dimension array to represent a two-dimension array.
    private List<Integer> getEmptyList(char[][] board) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    res.add(9 * i + j);
                }
            }
        }
        return res;
    }
}
