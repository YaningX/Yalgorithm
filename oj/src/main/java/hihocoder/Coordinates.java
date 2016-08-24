package hihocoder;

import java.util.*;

public class Coordinates {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int P = in.nextInt();
        int Q = in.nextInt();
        List<Integer> pList = getDivisors(P);
        List<Integer> qList = getDivisors(Q);
        for (int i: pList) {
            for (int j: qList) {
                System.out.println(i + " " + j);
            }
        }
    }

    public static List<Integer> getDivisors(int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                set.add(i);
                set.add(n / i);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }
}
