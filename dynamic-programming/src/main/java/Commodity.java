/**
 * Serve for knapsack problem
 */
public class Commodity {
    private int weight;
    private int benefit;

    public Commodity(int weight, int benefit) {
        this.benefit = benefit;
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getBenefit() {
        return this.benefit;
    }
}
