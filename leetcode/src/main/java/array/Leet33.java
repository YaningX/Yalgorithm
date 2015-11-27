package array;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 http://www.zgxue.com/164/1643191.html

 Key idea: figure out the three situations, analyze it, and then code http://www.zgxue.com/164/1643191.html

 */
public class Leet33 {
    public int search(int[] A, int target) {
        int len = A.length;
        if (len == 0) {
            return -1;
        }
        return doSearch(A, target, 0, len - 1);
    }

    private int doSearch(int A[], int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (A[left] == target) {
            return left;
        }
        if (A[right] == target) {
            return right;
        }
        if (A[mid] == target) {
            return mid;
        }

        if (A[left] < A[right]) {
            if (A[mid] > target) {
                return doSearch(A, target, left + 1, mid - 1);
            } else {
                return doSearch(A, target, mid + 1, right - 1);
            }
        } else if (A[left] < A[mid]) {
            if (A[mid] > target && A[left] < target) {
                return doSearch(A, target, left + 1, mid - 1);
            } else {
                return doSearch(A, target, mid + 1, right - 1);
            }
        } else {
            if (target > A[mid] && target < A[right]) {
                return doSearch(A, target, mid + 1, right - 1);
            } else {
                return doSearch(A, target, left + 1, mid - 1);
            }
        }
    }

    //Use binary search
    public int iterSearch(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == target) {
                return mid;
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
        return -1;
    }
}
