package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xuyaning on 25/1/16.
 */
public class Leet130 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0, queue);
            }
            if (board[i][n - 1] == 'O') {
                bfs(board, i, n - 1, queue);
            }
        }

        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                bfs(board, 0, i, queue);
            }
            if (board[m - 1][i] == 'O') {
                bfs(board, m - 1, i, queue);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void bfs(char[][] board, int x, int y, Queue<Integer> queue) {
        fillCell(board, x, y, queue);
        while (!queue.isEmpty()) {
            Integer integer = queue.poll();
            x = integer / board[0].length;
            y = integer % board[0].length;
            fillCell(board, x - 1, y, queue);
            fillCell(board, x + 1, y, queue);
            fillCell(board, x, y - 1, queue);
            fillCell(board, x, y + 1, queue);
        }
    }

    private void fillCell(char[][] board, int x, int y, Queue<Integer> queue) {
        int m = board.length;
        int n = board[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }
        if (board[x][y] == 'O') {
            board[x][y] = '#';
            queue.offer(x * n + y);
        }
    }
}
