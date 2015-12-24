import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Backtracking Algorithm for Subset Sum
 *
 * Subset sum problem is to find subset of elements
 * that are selected from a given set whose sum adds up to a given number K.
 * We are considering the set contains non-negative values.
 * It is assumed that the input set is unique (no duplicates are presented).
 */
public class SubSetSum {

    public static List<List<Integer>> recSubsetSum0(int[] array, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (array == null || array.length == 0) {
            return result;
        }
        List<Integer> currentList = new LinkedList<Integer>();
        doRecSubsetSum(array, target, 0, currentList, result);
        return result;
    }

    private static void doRecSubsetSum(int[] array, int target, int j, List<Integer> currentList, List<List<Integer>> result) {
        if (target == 0) {
            List<Integer> tmpList = new LinkedList<Integer>(currentList);
            result.add(tmpList);
            return;
        }
        for (int i = j + 1; i < array.length; i++) {
            if (target < array[i]) {
                return;
            }
            currentList.add(array[i]);
            doRecSubsetSum(array, target - array[i], i, currentList, result);
            currentList.remove(currentList.size() - 1);
        }
    }

    public static List<List<Integer>> recSubsetSum(int[] array, int sum) {
        Arrays.sort(array);
        List<Integer> intList = new LinkedList<Integer>();
        for (int i = 0; i < array.length; i++) {
            intList.add(array[i]);
        }
        return doRecSubsetSum(intList, sum);
    }

    private static List<List<Integer>> doRecSubsetSum(List<Integer> intList, int sum) {

        List<List<Integer>> resultList = new LinkedList<List<Integer>>();
        for (int i = 0; i < intList.size(); i++) {
            if (intList.get(i) == sum) { // base case
                List<Integer> innerList = new LinkedList<Integer>();
                innerList.add(sum);
                resultList.add(innerList);
            } else if (intList.get(i) < sum) {
                List<List<Integer>> nextList =
                        doRecSubsetSum(intList.subList(i + 1, intList.size()), sum - intList.get(i));
                for (int j = 0; j < nextList.size(); j++) {
                    List<Integer> innerList = new LinkedList<Integer>();
                    innerList.add(intList.get(i));
                    innerList.addAll(nextList.get(j));
                    resultList.add(innerList);
                }
            } else {
                break;
            }
        }
        
        return resultList;
    }

    public static List<List<Integer>> iterSubsetSum(int[] array, int sum) {
        Arrays.sort(array);
        List<Integer> intList = new LinkedList<Integer>();
        for (int i = 0; i < array.length; i++) {
            intList.add(array[i]);
        }
        return doIterSubsetSum(intList, sum);
    }

    private static List<List<Integer>> doIterSubsetSum(List<Integer> intList, int sum) {
        return null;
    }
}
