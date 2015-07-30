import java.util.LinkedList;
import java.util.List;

public class Knapsack {
    public static List<Commodity> knapsack(Commodity[] commodities, int capacity) {
        int[][] opt = new int[capacity + 1][commodities.length + 1];
        for (int i = 0; i <= capacity; i++) {
            opt[i][0] = 0;
        }
        for (int j = 0; j <= commodities.length; j++) {
            opt[0][j] = 0;
        }
        for (int i = 1; i <= capacity; i++) {
            for (int j = 1; j <= commodities.length; j++) {
                opt[i][j] = opt[i][j - 1];
                if (i >= commodities[j - 1].getWeight()) {
                    opt[i][j] = Math.max(opt[i][j], opt[i - commodities[j - 1].getWeight()][j - 1] + commodities[j - 1].getBenefit());
                }
            }
        }
        return findOptimalSlection(opt, commodities, capacity);
    }

    private static List<Commodity> findOptimalSlection(int[][] opt, Commodity[] commodities, int capacity) {
        List<Commodity> resultList = new LinkedList<Commodity>();
        int j = commodities.length;
        while (opt[capacity][j] != 0) {
            if (opt[capacity][j] != opt[capacity][j - 1]) {
                capacity = capacity - commodities[j - 1].getWeight();
                resultList.add(commodities[j - 1]);
            }
            j--;
        }
        return resultList;
    }
}
