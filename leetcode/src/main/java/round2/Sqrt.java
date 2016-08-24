package round2;

/**
 * https://leetcode.com/problems/sqrtx/
 */
public class Sqrt {
    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        int result = -1;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long product = mid * mid;
            if (product < x) {
                long upperBound = (mid + 1) * (mid + 1);
                if (x < upperBound) {
                    result = (int) mid;
                    break;
                }
                low = (int) mid + 1;
            } else if (product > x) {
                high = (int) mid - 1;
            } else {
                result = (int) mid;
                break;
            }
        }
        return result;
    }

    public int mySqrt1(int x) {
        int low = 1;
        int high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int y = x / mid;
            if (y == mid) {
                return mid;
            } else if (y > mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
