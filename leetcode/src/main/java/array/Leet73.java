package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xuyaning on 7/1/16.
 */
public class Leet73 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        Set<Integer> set = new HashSet<Integer>();
        boolean flag = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    set.add(j);
                    flag = true;
                }
            }
            if (flag == true) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
            flag = false;
        }
        for (Integer index: set) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][index] =  0;
            }
        }
    }
}
