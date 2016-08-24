import java.util.*;

public class MSstable {
    static Scanner sc;
    static int memeberNum;
    static ArrayList<Integer>[] fatherList;
    static ArrayList<Integer>[] sonList;
    static int[] needToCheck;
    static boolean[] checked;

    public static void main(String[] args) {
        int result = 0;
        sc = new Scanner(System.in);
        memeberNum = sc.nextInt();
        fatherList = (ArrayList<Integer>[]) new ArrayList[memeberNum+1];
        sonList = (ArrayList<Integer>[]) new ArrayList[memeberNum+1];
        needToCheck = new int[memeberNum+1];
        //checked = new boolean[memeberNum+1];

        LinkedList<Integer> stack = new LinkedList<Integer>();

        for (int i=1; i<=memeberNum; i++) {
            fatherList[i] = new ArrayList<Integer>();
            sonList[i] = new ArrayList<Integer>();
        }

        for (int i=1; i<=memeberNum; i++) {
            int count = sc.nextInt();
            for (int j=0; j<count; j++) {
                int father = sc.nextInt();

                if (father != 0)
                    sonList[father].add(i);
                fatherList[i].add(father);
            }
        }

        for (int i=1; i<=memeberNum; i++) {
            boolean res = true;
            for (int j=1; j<=memeberNum; j++)
                if (j != i)
                    res = res && checkCanReach(i, j);
            if (res)
                result++;
        }
        System.out.println(result);
    }

    public static boolean checkCanReach(int son, int missFather) {
        LinkedList<Integer> s = new LinkedList<Integer>();
        s.add(son);
        while(s.size() != 0) {
            int thisMan = s.pollFirst();
            for (int father: fatherList[thisMan])
                if (father == 0)
                    return true;
                else if (father != missFather)
                    s.add(father);
        }
        return false;
    }

}
