import java.util.LinkedList;
import java.util.List;

/**
 *Problem description, seen in backtracking.
 */
public class DPSubSetSum {
    public static List<Integer> dpSubsetSum(int[] array, int target) {
        boolean[][] subset = new boolean[target + 1][array.length + 1];
        int[] set = new int[array.length + 1];
        System.arraycopy(array, 0, set, 1, array.length);

        //base case
        for (int i = 0; i <= array.length; i++) {
            subset[0][i] = true;
        }
        for (int j = 1; j <= target; j++) {
            subset[j][0] = false;
        }

        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= array.length; j++) {
                subset[i][j] = subset[i][j-1];
                if (i >= set[j]) {
                    subset[i][j] = subset[i][j] || subset[i - set[j]][j - 1];
                }
            }
        }

        return findSubset(subset, set,target);
    }

    private static List<Integer> findSubset(boolean[][] subset, int[] set, int target) {
        List<Integer> resultList = new LinkedList<Integer>();
        if (subset[target][set.length - 1] == false) {
            return resultList;
        }
        int j = set.length - 1;
        while (target != 0) {
            if (subset[target][j - 1] == true) {
                j--;
            } else {
                target = target - set[j];
                resultList.add(set[j]);
                j--;
            }
        }
        return resultList;
    }
}
