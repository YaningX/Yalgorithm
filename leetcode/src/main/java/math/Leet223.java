package math;

/**
 * Created by xuyaning on 10/2/16.
 */
public class Leet223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int xMin = Math.max(A, E);
        int xMax = Math.min(C, G);
        int yMin = Math.max(B, F);
        int yMax = Math.min(D, H);
        int overlap = 0;
        if (xMax > xMin && yMax > yMin) {
            overlap = (xMax - xMin) * (yMax - yMin);
        }
        return (C - A) * (D - B) + (G - E) * (H - F) - overlap;
    }
}
