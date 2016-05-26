package poj;


import java.util.*;

/**
 * 1) 利用位运算压缩
 * 2) BFS
 */
public class NaiveThePilotsBrotherRefrigeator {

    static class Status {
        int source;
        int pos;
        List<Integer> markList;

        public Status(int source, int pos, List<Integer> markList) {
            this.source = source;
            this.pos = pos;
            this.markList = markList;
        }
    }

    public static void solve() {
        Scanner in = new Scanner(System.in);
        int source = 0;
        for (int i = 0; i < 4; i++) {
            if (in.hasNextLine()) {
                String str = in.nextLine().trim();
                for (int j = 0; j < 4; j++) {
                    source = (source << 1) + (str.charAt(j) == '+'? 1: 0);
                }
            }
        }
        Queue<Status> queue = new LinkedList<Status>();
        queue.offer(new Status(source, -1, new ArrayList<Integer>()));
        while (!queue.isEmpty()) {
            Status status = queue.poll();
            if (NaiveThePilotsBrotherRefrigeator.isOpen(status.source)) {
                System.out.println(status.markList.size());
                for (int i = 0; i < status.markList.size(); i++) {
                    int pos = status.markList.get(i);
                    System.out.println((4 - pos / 4) + " " + (4 - pos % 4));
                }
                return;
            }

            for (int i = status.pos + 1; i < 16; i++) {
                status.pos = i;
                Status newStatus = NaiveThePilotsBrotherRefrigeator.flip(status);
                queue.offer(newStatus);
            }
        }
    }

    public static boolean isOpen(int source) {
        return source == 0;
    }

    public static Status flip(Status status) {
        int source = status.source;
        int pos = status.pos;
        int x = pos / 4;
        int y = pos % 4;
        for (int i = 0; i < 4; i++) {
            source ^= (1 << (4 * x + i));
            source ^= (1 << (4 * i + y));
        }
        source ^= (1 << pos);
        List<Integer> list = new ArrayList<Integer>(status.markList);
        list.add(pos);
        return new Status(source, pos, list);
    }

    public static void main(String[] args) {
        NaiveThePilotsBrotherRefrigeator.solve();
    }

}
