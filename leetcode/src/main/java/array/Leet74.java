package array;

/**
 * Created by xuyaning on 7/1/16.
 */
public class Leet74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int low = 0;
        int high = matrix.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                if (mid + 1 < matrix.length && matrix[mid + 1][0] > target) {
                    break;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        int index = mid;
        low = 0;
        high = matrix[0].length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (matrix[index][mid] == target) {
                return true;
            } else if (matrix[index][mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

}
