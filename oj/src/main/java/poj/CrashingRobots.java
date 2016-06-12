package poj;

import java.util.Scanner;

/**
 * http://poj.org/problem?id=2632
 * http://www.acmerblog.com/POJ-2632-Crashing-Robots-blog-822.html
 * 注意: 平面直角坐标系上的 坐标 和 编程中 二维数组的 坐标对应关系 不一致, 需要转换 --- 瞬时针 旋转 90 度;
 */
class Robot {
    int id;
    int x, y;
    char direction;
    public Robot(int id, int x, int y, String direction) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.direction = direction.charAt(0);
    }

    public void move(String command) {
        if (command.equals("F")) {
            switch (direction) {
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
            }
        } else if (command.equals("L")) {
            switch (direction) {
                case 'E':
                    direction = 'N';
                    break;
                case 'N':
                    direction = 'W';
                    break;
                case 'W':
                    direction = 'S';
                    break;
                case 'S':
                    direction = 'E';
                    break;
            }
        } else if (command.equals("R")) {
            switch (direction) {
                case 'E':
                    direction = 'S';
                    break;
                case 'S':
                    direction = 'W';
                    break;
                case 'W':
                    direction = 'N';
                    break;
                case 'N':
                    direction = 'E';
                    break;
            }
        }
    }
}

public class CrashingRobots {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rounds = in.nextInt();
        for (int round = 0; round < rounds; round++) {
            int A = in.nextInt();
            int B = in.nextInt();
            int robotNumber = in.nextInt();
            int instNumber = in.nextInt();
            Robot[] robots = new Robot[robotNumber + 1];
            int[][] warehouse = new int[A + 1][B + 1];
            for (int i = 1; i <= robotNumber; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                String command = in.next().trim();
                robots[i] = new Robot(i, x, y, command);
                warehouse[x][y] = i;
            }

            String result = "OK";
            for (int i = 0; i < instNumber; i++) {
                int id = in.nextInt();
                String inst = in.next().trim();
                int repeat = in.nextInt();
                if (result.charAt(0) != 'O') {
                    continue;
                }
                result = CrashingRobots.solve(robots[id], warehouse, repeat, inst);
            }
            System.out.println(result);
        }
    }

    public static String solve(Robot robot, int[][] warehouse, int repeat, String command) {
        if (!command.equals("F")) {
            repeat %= 4;
        }
        String result = "OK";
        for (int i = 0; i < repeat; i++) {
            warehouse[robot.x][robot.y] = 0;
            robot.move(command);
            if (robot.x <= 0 || robot.x >= warehouse.length || robot.y <= 0 || robot.y >= warehouse[0].length) {
                result = "Robot " + robot.id + " crashes into the wall";
                break;
            }
            if (warehouse[robot.x][robot.y] != 0) {
                result = "Robot " + robot.id + " crashes into robot " + warehouse[robot.x][robot.y];
                break;
            }
            warehouse[robot.x][robot.y] = robot.id;
        }
        return result;
    }
}
