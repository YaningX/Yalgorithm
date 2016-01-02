package dp;

/**
 * Created by xuyaning on 2/1/16.
 */
public class Leet62 {
    public int recUniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return recUniquePaths(m - 1, n) + recUniquePaths(m, n - 1);
    }

    public int iterUniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            paths[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            paths[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] = paths[i][j - 1] + paths[i - 1][j];
            }
        }
        return paths[m - 1][n - 1];
    }
}
