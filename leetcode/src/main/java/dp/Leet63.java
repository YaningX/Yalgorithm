package dp;

/**
 * Created by xuyaning on 2/1/16.
 */
public class Leet63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        if (obstacleGrid[0][0] == 0) {
            paths[0][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                paths[i][0] = paths[i - 1][0];
            }
        }

        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                paths[0][i] = paths[0][i - 1];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }

        return paths[m - 1][n -1];
    }
}
