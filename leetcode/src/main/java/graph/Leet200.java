package graph;

/**
 * Created by xuyaning on 1/2/16.
 */
public class Leet200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '#') {
                    grid[i][j] = '1';
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '#';
            dfs(grid, x - 1, y);
            dfs(grid, x + 1, y);
            dfs(grid, x, y - 1);
            dfs(grid, x, y + 1);
        }
    }
}
