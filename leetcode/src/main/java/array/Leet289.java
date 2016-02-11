package array;

/**
 * Created by xuyaning on 11/2/16.
 */
public class Leet289 {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = count(board, i, j);
                if (board[i][j] == 1) {
                    if (count == 2 || count == 3) {
                        board[i][j] += 2;
                    }
                } else {
                    if (count == 3) {
                        board[i][j] += 2;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int count(int[][] board, int x, int y) {
        int result = 0;
        int xlow = x > 0 ? x - 1: x;
        int xhigh = x < board.length - 1 ? x + 1: x;
        int ylow = y > 0 ? y - 1: y;
        int yhigh = y < board[0].length - 1 ? y + 1: y;
        for (int i = xlow; i <= xhigh; i++) {
            for (int j = ylow; j <= yhigh; j++) {
                if (i == x && j == y) {
                    continue;
                }
                if ((board[i][j] & 1) == 1) {
                    result++;
                }
            }
        }
        return result;
    }
}
