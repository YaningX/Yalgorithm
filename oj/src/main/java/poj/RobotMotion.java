package poj;

import java.util.Scanner;

/**
 * http://poj.org/problem?id=1573
 */
public class RobotMotion {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();
        int start = in.nextInt();
        while (!(rows == 0 && cols == 0 && start == 0)) {
            char[][] grid = new char[rows + 1][cols + 1];
            for (int i = 1; i <= rows; i++) {
                String line = in.next().trim();
                for (int j = 1; j <= cols; j++) {
                    grid[i][j] = line.charAt(j - 1);
                }
            }
            String result = RobotMotion.solve(grid, start);
            System.out.println(result);
            rows = in.nextInt();
            cols = in.nextInt();
            start = in.nextInt();
        }
    }


    public static String solve(char[][] grid, int start) {
        int[][] trace = new int[grid.length][grid[0].length];
        for (int i = 1; i < trace.length; i++) {
            for (int j = 1; j < trace[0].length; j++) {
                trace[i][j] = -1;
            }
        }
        int x = 1;
        int y = start;
        String result = "";
        int step = 0;
        while (true) {
            if (x <= 0 || x >= trace.length || y <= 0 || y >= trace[0].length) {
                result = step + " step(s) to exit";
                break;
            }

            if (trace[x][y] != -1) {
                result = trace[x][y] + " step(s) before a loop of " + (step - trace[x][y]) + " step(s)";
                break;
            }

            trace[x][y] = step;
            switch (grid[x][y]) {
                case 'S':
                    x++;
                    break;
                case 'N':
                    x--;
                    break;
                case 'E':
                    y++;
                    break;
                case 'W':
                    y--;
                    break;
            }
            step++;
        }
        return result;
    }

}
