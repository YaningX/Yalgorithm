package recursive;

/**
 * Created by xuyaning on 7/1/16.
 */
public class Leet79 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board[0].length == 0) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }

        if (board[i][j] == word.charAt(k)) {
            char tmp = board[i][j];
            board[i][j] = '#';
            if (k == word.length() - 1) {
                return true;
            } else if (dfs(board, word, i - 1, j, k + 1)
                    || dfs(board, word, i, j - 1, k + 1)
                    || dfs(board, word, i + 1, j, k + 1)
                    || dfs(board, word, i, j + 1, k + 1)){
                return true;
            }
            board[i][j] = tmp;
        }

        return false;
    }
}
