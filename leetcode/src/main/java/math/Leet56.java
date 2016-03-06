package math;

import java.util.*;

/**
 * Created by xuyaning on 30/12/15.
 */
public class Leet56 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if (intervals.size() == 0) {
            return result;
        }
        Collections.sort(intervals, new IntervalComparator());
        for (Interval interval: intervals) {
            if (result.size() == 0) {
                result.add(new Interval(interval.start, interval.end));
                continue;
            }
            Interval pre = result.get(result.size() - 1);
            if (pre.end < interval.start) {
                result.add(new Interval(interval.start, interval.end));
            } else {
                pre.end = Math.max(pre.end, interval.end);
            }
        }
        return result;
    }

    class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval val1, Interval val2) {
            return val1.start - val2.start;
        }
    }

    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval( int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
