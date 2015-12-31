package array;

/**
 * Created by xuyaning on 31/12/15.
 */
public class Leet59 {
    public int[][] generateMatrix(int n) {
        n = Math.abs(n);
        int[][] result = new int[n][n];
        int x = 0;
        int y = 0;
        int limit = n;
        int value = 1;

        while (limit > 0) {
            if (limit == 1) {
                result[x][y] = value;
                return result;
            }

            //top---to right
            for (int i = 0; i < limit - 1; i++) {
                result[x][y++] = value++;
            }

            //right---to down
            for (int i = 0; i < limit - 1; i++) {
                result[x++][y] = value++;
            }

            //bottom---to left
            for (int i = 0; i < limit - 1; i++) {
                result[x][y--] = value++;
            }

            //left---to up
            for (int i = 0; i < limit - 1; i++) {
                result[x--][y] = value++;
            }


            limit -= 2;
            x++;
            y++;
        }
        return result;
    }
}
