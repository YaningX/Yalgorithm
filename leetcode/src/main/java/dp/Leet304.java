package dp;

/**
 * Created by xuyaning on 12/2/16.
 */
public class Leet304 {
    public class NumMatrix {
        private int[][] sum;
        public NumMatrix(int[][] matrix) {
            if (matrix.length > 0 && matrix[0].length > 0) {
                sum = new int[matrix.length][matrix[0].length];
                sum[0][0] = matrix[0][0];
                for (int i = 1; i < matrix.length; i++) {
                    sum[i][0] = sum[i - 1][0] + matrix[i][0];
                }
                for (int i = 1; i < matrix[0].length; i++) {
                    sum[0][i] = sum[0][i - 1] + matrix[0][i];
                }
                for (int i = 1; i < matrix.length; i++) {
                    for (int j = 1; j < matrix[0].length; j++) {
                        sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i][j];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (row1 == 0 && col1 == 0) {
                return sum[row2][col2];
            } else if (row1 == 0) {
                return sum[row2][col2] - sum[row2][col1 - 1];
            } else if (col1 == 0) {
                return sum[row2][col2] - sum[row1 - 1][col2];
            } else {
                return sum[row2][col2] + sum[row1 - 1][col1 - 1] - sum[row2][col1 - 1] - sum[row1 - 1][col2];
            }
        }
    }
}
