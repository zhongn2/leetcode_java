/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 // the solution is not hard to come update
 // two ways: 
 // 1. change intervals itself
 // make a new empty space to store the new arraylist
 // when updating intervals, i should be i-- and insert the new interval into right place
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(newInterval == null){
            return intervals;
        }
        int i;
        for(i = 0; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            
            if (curr.end < newInterval.start) continue; //nonoverlap, newInterval is behind current, continue;
            
            if(newInterval.end < curr.start) break; //nonoverlap, newInterval is before current, jump out of loop
            
            newInterval.start = Math.min(curr.start, newInterval.start); //overlap, update newInterval and remove current
            newInterval.end = Math.max(curr.end, newInterval.end);
            intervals.remove(i);
            i--;
        }
        intervals.add(i, newInterval);
        return intervals;
        
            
            
        }
        
    }
