
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        List<Node> list = Main.getNode(N);
        for (int i = 0; i < M; i++) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            int count = 0;
            for (Node node: list) {
                if (node.x >= x1 && node.x <= x2 && node.y >= y1 && node.y <= y2) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static List<Node> getNode(int N) {
        List<Node> result = new ArrayList<Node>();
        dfs(N, 0, 0, result);
        return result;
    }

    private static void dfs(int N, int x, int y, List<Node> result) {
        result.add(new Node(x, y));
        if (N == 1) {
            return;
        }

        if (N == 2) {
            dfs(N - 1, x + 2, y + 2, result);
            dfs(N - 1, x + 2, y - 2, result);
            return;
        }

        int K = 3 * (int) Math.pow(2, N - 3);
        dfs(N - 1, x + K, y + K, result);
        dfs(N - 1, x + K, y - K, result);
    }


}
