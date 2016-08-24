import java.util.*;

public class Main {
    static Scanner sc;
    static String[] constraints;
    static int charcterNumer;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int constraintsNum = sc.nextInt();
        constraints = new String[constraintsNum];
        for (int i=0; i<constraintsNum; i++)
            constraints[i] = sc.next();
        charcterNumer = getCharacterNumber();

        int checkTimes = sc.nextInt();
        for (int i=0; i<checkTimes; i++) {
            if (check())
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }

    public static int getCharacterNumber() {
        int count = 0;
        boolean[] used = new boolean[26];
        for (String con: constraints) {
            for (int i=0; i<con.length(); i++) {
                if (con.charAt(i)>='A' && con.charAt(i)<='Z' && !used[con.charAt(i)-'A']) {
                    used[con.charAt(i) - 'A'] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean check() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0; i<charcterNumer; i++) {
            String s = sc.next();
            map.put(s, sc.nextInt());
        }

        for (String con: constraints) {
            int last = -1;
            boolean equal = false;
            for (int i=0; i<con.length(); i++) {
                int num = 0;
                if (con.charAt(i) == '<')
                    continue;
                else if (con.charAt(i) == '=') {
                    equal = true;
                    continue;
                } else if (con.charAt(i) >= '0' && con.charAt(i) <= '9') {
                    while (i < con.length() && con.charAt(i) >= '0' && con.charAt(i) <= '9') {
                        num = num * 10 + con.charAt(i) - '0';
                        i++;
                    }
                } else {
                    num = map.get(Character.toString(con.charAt(i)));
                }
                //System.out.println(last + " " + equal + " " + num);
                if (equal && num < last)
                    return false;
                else if (!equal && num <= last)
                    return false;
                last = num;
                equal = false;
            }
        }
        return true;
    }
}
