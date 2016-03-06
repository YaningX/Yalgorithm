package array;

/**
 * Created by xuyaning on 7/1/16.
 */
public class Leet74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
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



    public boolean searchMatrix0(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int len = matrix.length * matrix[0].length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
