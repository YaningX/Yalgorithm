import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int minMaze(char[][] maze) {
        List<Integer> emptyList = Main.getEmpty(maze);
        List<List<Integer>> combineList = Main.getCombination(emptyList);
        for (List<Integer> list: combineList) {
            for (int i: list) {
                int x = i / maze.length;
                int y = i % maze.length;
                maze[x][y] = '.';
            }
            if (Main.isOK(maze, 0, 0)) {
                return list.size();
            }
            for (int i: list) {
                int x = i / maze.length;
                int y = i % maze.length;
                maze[x][y] = 'b';
            }
        }
        return -1;
    }

    public static List<Integer> getEmpty(char[][] maze) {
        List<Integer> emptyList = new ArrayList<Integer>();
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 'b') {
                    emptyList.add(maze.length * i + j);
                }
            }
        }
        return emptyList;
    }

    public static List<List<Integer>> getCombination(List<Integer> list) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        for (int i: list) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> tmpList = new ArrayList<Integer>(result.get(j));
                tmpList.add(i);
                result.add(tmpList);
            }
        }
        return result;
    }

    public static boolean isOK(char[][] maze, int x, int y) {
        if (x == maze.length - 1 && y == maze[0].length - 1 && maze[x][y] == '.') {
            return true;
        }
        if (x == maze.length || y == maze.length || maze[x][y] == 'b') {
            return false;
        }
        if (y < maze.length - 1 && maze[x][y + 1] == '.') {
            if ( Main.isOK(maze, x, y + 1)) {
                return true;
            } else {
                return false;
            }
        }  else {
            if (Main.isOK(maze, x + 1, y)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] argvs) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        char[][] maze = new char[a][b];
        for(int i=0; i<a; i++){
            String line = in.nextLine();
            for(int j=0; j<b; j++){
                maze[i][j] = line.charAt(j);
            }
        }
        System.out.println(Main.minMaze(maze));
    }
}