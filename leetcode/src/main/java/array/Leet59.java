package array;

/**
 * Created by xuyaning on 31/12/15.
 */
public class Leet59 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n == 0) {
            return result;
        }
        int x = 0, y = 0;
        int count = 1;
        while (n > 0) {
            if (n == 1) {
                result[x][y] = count;
                break;
            }

            for (int i = 0; i < n - 1; i++) {
                result[x][y++] = count++;
            }

            for (int i = 0; i < n - 1; i++) {
                result[x++][y] = count++;
            }
            for (int i = 0; i < n - 1; i++) {
                result[x][y--] = count++;
            }
            for (int i = 0; i < n - 1; i++) {
                result[x--][y] = count++;
            }
            x++;
            y++;
            n -= 2;
        }
        return result;
    }
}
