package poj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 *  1) BSF
 *  2) 用位运算减少计算量和存储空间
 */
public class FlipGame {

    static class Status {
        int source;
        int pos;
        public Status(int source, int pos) {
            this.source = source;
            this.pos = pos;
        }
    }

    public static void solve() {
        Scanner in = new Scanner(System.in);
        int source = 0;
        for (int i = 0; i < 4; i++) {
            if (in.hasNextLine()) {
                String str = in.nextLine().trim();
                for (int j = 0; j < 4; j++) {
                    source = (source << 1) + (str.charAt(j) == 'b'? 1: 0);
                }
            }
        }
        Queue<Status> queue = new LinkedList<Status>();
        queue.offer(new Status(source, -1));
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Status status = queue.poll();
                if (FlipGame.isSingleColor(status.source)) {
                    System.out.println(level);
                    return;
                }
                for (int j = status.pos + 1; j < 16; j++) {
                    status.pos = j;
                    Status newStatus = flip(status);
                    queue.offer(newStatus);
                }

            }
            level++;
        }
        System.out.println("Impossible");
    }

    public static Status flip(Status status) {
        int source = status.source;
        int pos = status.pos;
        source ^= (1 << pos);
        if (pos / 4 > 0) {
            source ^= (1 << (pos - 4));
        }
        if (pos /4 < 3) {
            source ^= (1 << (pos + 4));
        }
        if (pos % 4 > 0) {
            source ^= (1 << (pos - 1));
        }
        if (pos % 4 < 3) {
            source ^= (1 << (pos + 1));
        }
        return new Status(source, pos);
    }

    public static boolean isSingleColor(int source) {
        return source == 0xffff || source == 0;
    }

    public static void main(String[] args) {
        FlipGame.solve();
    }

}
