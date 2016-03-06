package math;


public class Leet48 {
    //(i, n - 1 -j) ====>> (n- 1 - j, n - 1 - i)
    // (x, y) ===> (y, x) ===> (y, n - x - 1)
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int bound = n / 2;
        for (int i = 0; i <= bound; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j -1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    }
}
