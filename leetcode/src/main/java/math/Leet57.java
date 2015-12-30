package math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuyaning on 30/12/15.
 */
public class Leet57 {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        for(Interval interval: intervals) {
            if(interval.end < newInterval.start){
                result.add(interval);
            } else if(interval.start > newInterval.end){
                result.add(newInterval);
                newInterval = interval;
            } else {
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(newInterval.end, interval.end));
            }
        }
        result.add(newInterval);
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
