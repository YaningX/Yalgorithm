import org.junit.Test;

public class DiceRollGameTest {

    @Test
    public void recDiceRollTest() {
        System.out.println(DiceRollGame.recDiceRoll(3).size());
    }

    @Test
    public void recDiceSumTest() {
        System.out.println(DiceRollGame.recDiceSum(21, 100));
    }
}
