import org.junit.Test;

public class DiceRollGameTest {

    @Test
    public void recDiceRollTest() {
        System.out.println(DiceRollGame.iteDiceRoll(3).size());
    }

    @Test
    public void recDiceSumTest() {
        System.out.println(DiceRollGame.iteDiceSum(6, 30).size());
    }
}
