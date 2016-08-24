package round2;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = 0;

        while (m > 0 && n > 0) {
            if (m == 1) {
                for (int i = 0; i < n; i++) {
                    result.add(matrix[x][y++]);
                }
                break;
            }

            if (n == 1) {
                for (int i = 0; i < m; i++) {
                    result.add(matrix[x++][y]);
                }
                break;
            }
            for (int i = 0; i < n - 1; i++) {
                result.add(matrix[x][y++]);
            }

            for (int i = 0; i < m - 1; i++) {
                result.add(matrix[x++][y]);
            }

            for (int i = 0; i < n - 1; i++) {
                result.add(matrix[x][y--]);
            }
            for (int i = 0; i < m - 1; i++) {
                result.add(matrix[x--][y]);
            }
            x++;
            y++;
            m -= 2;
            n -= 2;
        }
        return result;
    }
}
