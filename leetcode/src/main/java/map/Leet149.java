package map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuyaning on 27/1/16.
 */
public class Leet149 {
    public int maxPoints(Point[] points) {
        if (points.length <= 2) {
            return points.length;
        }
        int max = 1;
        for (Point firstPoint: points) {
            Map<Double, Integer> map = new HashMap<Double, Integer>();
            int rep = 0;
            int inMax = 1;
            for (Point secondPoint: points) {
                if (firstPoint == secondPoint) {
                    continue;
                }

                if (firstPoint.x == secondPoint.x && firstPoint.y == secondPoint.y) {
                    rep++;
                    continue;
                }

                double ratio = (double) (firstPoint.y - secondPoint.y) / (firstPoint.x - secondPoint.x);
                if (!map.containsKey(ratio)) {
                    map.put(ratio, 2);
                } else {
                    map.put(ratio, map.get(ratio) + 1);
                }
                inMax = Math.max(inMax, map.get(ratio));
            }
            inMax += rep;
            max = Math.max(max, inMax);
        }
        return max;
    }

    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
