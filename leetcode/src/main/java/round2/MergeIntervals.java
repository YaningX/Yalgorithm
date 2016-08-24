package round2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval inter1, Interval inter2) {
                return inter1.start - inter2.start;
            }
        });
        for (int i = 0; i < intervals.size(); i++) {
            if (i == 0) {
                Interval inter = intervals.get(0);
                result.add(new Interval(inter.start, inter.end));
                continue;
            }
            Interval inter = intervals.get(i);
            Interval pre = result.get(result.size() - 1);
            if (inter.start > pre.end) {
                result.add(new Interval(inter.start, inter.end));
            } else {
                pre.end = Math.max(inter.end, pre.end);
            }
        }
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
}
