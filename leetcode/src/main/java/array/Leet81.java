package array;

/**
 * Created by xuyaning on 7/1/16.
 */
public class Leet81 {
    public boolean search(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < A.length && A[left] == A[left + 1]) {
            left++;
        }

        while (right - 1 > 0 && A[right] == A[right - 1]) {
            right--;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == target) {
                return true;
            }

            if (A[left] <= A[mid]) {
                if (A[left] <= target && target < A[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (A[mid] < A[right]) {
                    if (A[mid] < target && target <= A[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        return false;
    }
}
