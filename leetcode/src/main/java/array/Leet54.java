package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuyaning on 29/12/15.
 */
public class Leet54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();

        if (matrix.length == 0) {
            return result;
        }

        int x = 0;
        int y = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        while (m > 0 && n > 0) {
            if (m == 1) {
                for (int i = 0; i < n; i++) {
                    result.add(matrix[x][y++]);
                }
                return result;
            } else if (n == 1) {
                for (int i = 0; i < m; i++) {
                    result.add(matrix[x++][y]);
                }
                return result;
            }

            //top---to right
            for (int i = 0; i < n - 1; i++) {
                result.add(matrix[x][y++]);
            }

            //right----to down
            for (int i = 0; i < m - 1; i++) {
                result.add(matrix[x++][y]);
            }

            //bottom----to left
            for (int i = 0; i < n - 1; i++) {
                result.add(matrix[x][y--]);
            }

            //left---to top
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
