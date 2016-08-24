package round2;

/**
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int i, char[][] board, String word) {
        if (i == word.length()) {
            return true;
        }

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }

        if (board[x][y] == word.charAt(i)) {
            char tmp = board[x][y];
            board[x][y] = '#';
            if (dfs(x - 1, y, i + 1, board, word) || dfs(x + 1, y, i + 1, board, word) || dfs(x, y - 1, i + 1, board, word) || dfs(x, y + 1, i + 1, board, word)) {
                return true;
            }
            board[x][y] = tmp;
        }
        return false;
    }
}
