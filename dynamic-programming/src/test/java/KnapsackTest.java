import org.junit.Test;

import java.util.List;

public class KnapsackTest {
    @Test
    public void knapsackTest() {
        Commodity[] commodities = new Commodity[] {new Commodity(6, 10), new Commodity(2, 5),
        new Commodity(5, 3), new Commodity(10, 39)};
        List<Commodity> resultList = Knapsack.knapsack(commodities, 16);
        for (Commodity commodity : resultList) {
            System.out.println(commodity.getWeight());
        }
    }
}
