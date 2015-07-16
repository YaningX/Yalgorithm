import java.util.LinkedList;
import java.util.List;

public class DiceRollGame {

    /**
     * Write a method diceRoll recursively that accepts an integer parameter representing
     * a number of 6-sided dice to roll, and output all possible combinations
     * of values that could appear on the dice.
     * @param k , the times to roll a dice.
     * @return
     */
    public static List<List<Integer>> recDiceRoll(int k) {
        List<List<Integer>> diceList = new LinkedList<List<Integer>>();
        //bound condition is very important here, if k == 0 is the bound condition, then return a empty list,
        // then to keep the same efficiency, k == 1 must stay here.
        if (k == 1) {
            for (int i = 1; i <= 6; i++) {
                List<Integer> integerList = new LinkedList<Integer>();
                integerList.add(i);
                diceList.add(integerList);
            }
            return diceList;
        }

        List<List<Integer>> subDiceList = recDiceRoll(k - 1);
        //If inner and outer loop exchange, then the efficiency is more different.
        for (List<Integer> tmpList : subDiceList) {
            for (int i = 1; i <= 6; i++) {
                List<Integer> inList = new LinkedList<Integer>();
                inList.add(i);
                inList.addAll(tmpList);
                diceList.add(inList);
            }
        }
        return diceList;
    }

    /**
     * Write a method diceRoll iteratively that accepts an integer parameter representing
     * a number of 6-sided dice to roll, and output all possible combinations
     * of values that could appear on the dice.
     * @param k , the times to roll a dice.
     * @return
     */
    public static List<List<Integer>> iteDiceRoll(int k) {
        //TODO
        return null;
    }

    
    /**
     * Write a method diceSum similar to diceRoll,
     * but it also accepts a desired sum and prints
     * only combinations that add up to exactly that sum.
     * @param k , the times to roll
     * @param sum , the sum
     * @return
     */
    public static List<List<Integer>> recDiceSum(int k, int sum) {
        if (k > sum || 6 * k < sum) {
            return null;
        }

        List<List<Integer>> diceList = new LinkedList<List<Integer>>();
        if (k == 1 &&  sum >= 1 && sum <= 6) {
            List<Integer> initList = new LinkedList<Integer>();
            initList.add(sum);
            diceList.add(initList);
            return diceList;
        }

        boolean flag = false;
        for (int i = 1; i <= 6; i++) {
            List<List<Integer>> subDiceList = recDiceSum(k - 1, sum - i);
            if (subDiceList != null) {
                flag = true;
                for (List<Integer> integerList : subDiceList) {
                    List<Integer> list = new LinkedList<Integer>();
                    list.add(i);
                    list.addAll(integerList);
                    diceList.add(list);
                }
            }
        }
        if (flag == false) {
            return null;
        }
        return diceList;
    }
}
