package array;

import java.util.HashSet;
import java.util.Set;

public class Leet36 {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }

        for (int i = 0; i <= 8; i++) {
            Set<Character> rowSet = new HashSet<Character>();
            Set<Character> colSet = new HashSet<Character>();
            for (int j = 0; j <= 8; j++) {
                if (rowSet.contains(board[i][j]) && board[i][j] != '.') {
                    return false;
                } else {
                    rowSet.add(board[i][j]);
                }
                if (colSet.contains(board[j][i]) && board[j][i] != '.') {
                    return false;
                } else {
                    colSet.add(board[j][i]);
                }
            }
        }

        for (int i = 0; i <= 6; i += 3) {
            for (int j = 0; j <= 6; j += 3) {
                Set<Character> set = new HashSet<Character>();
                for (int m = i; m <= i + 2; m++) {
                    for (int n= j; n <= j + 2; n++) {
                        if (set.contains(board[m][n]) && board[m][n] != '.') {
                            return false;
                        } else {
                            set.add(board[m][n]);
                        }
                    }
                }
            }
        }
        return true;
    }
}
