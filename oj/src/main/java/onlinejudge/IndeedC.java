package onlinejudge;

import java.util.*;

public class IndeedC {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        char[][] array = new char[x][y];
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < x; i++) {
            String str = in.next();
            for (int j = 0; j < y; j++) {
                char ch = str.charAt(j);
                if (ch == '?') {
                    list.add(i * y + j);
                }
                array[i][j] = ch;
            }
        }
        List<String> combinations = new ArrayList<>();
        dfs(list.size(), combinations, "");
        double sum = 0;
        for (int i = 0; i < combinations.size(); i++) {
            char[] chars = new char[list.size()];
            String string = combinations.get(i);
            for (int j = 0; j < list.size(); j++) {
                int index = list.get(j);
                int xx = index / array[0].length;
                int yy = index % array[0].length;
                chars[j] = array[xx][yy];
                array[xx][yy] = string.charAt(j);
            }
            sum += touchCount(array);
            for (int j = 0; j < list.size(); j++) {
                int index = list.get(j);
                int xx = index / array[0].length;
                int yy = index % array[0].length;
                array[xx][yy] = chars[j];
            }
        }
        System.out.println(sum / combinations.size());
    }

    private static double touchCount(char[][] array) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                int index = i * array[0].length + j;
                if (set.contains(index)) {
                    continue;
                } else {
                    int x = i;
                    int y = j;
                    count++;
                    while (x < array.length && y < array[0].length) {
                        char ch = array[x][y];
                        set.add(index);
                        if (ch == 'R') {
                            y++;
                        } else if (ch == 'C') {
                            x++;
                        }
                        index = x * array[0].length + y;
                    }
                }
            }
        }

        return (double) count;
    }

    private static void dfs(int k, List<String> result, String current) {
        if (k == 0) {
            result.add(current);
            return;
        }
        dfs(k - 1, result, current + 'R');
        dfs(k - 1, result, current + 'C');
    }
}
