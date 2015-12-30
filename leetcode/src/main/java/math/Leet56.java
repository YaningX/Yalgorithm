package math;

import java.util.*;

/**
 * Created by xuyaning on 30/12/15.
 */
public class Leet56 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new LinkedList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }
        Collections.sort(intervals, new IntervalComparator());
        Iterator<Interval> iterator = intervals.iterator();
        Stack<Interval> stack = new Stack<Interval>();
        stack.push(iterator.next());
        while (iterator.hasNext()) {
            Interval preInterval = stack.pop();
            Interval interval = iterator.next();
            if (preInterval.end >= interval.start) {
                stack.push(new Interval(preInterval.start, Math.max(preInterval.end, interval.end)));
                continue;
            }
            stack.push(preInterval);
            stack.push(interval);
        }
        result.addAll(stack);
        return result;
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

    class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval interval1, Interval interval2) {
            return interval1.start - interval2.start;
        }
    }
}
