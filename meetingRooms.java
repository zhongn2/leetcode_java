/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
     class IntervalComparator implements Comparator<Interval>{
        public int compare(Interval int1, Interval int2){
            return int1.start - int2.start;
        }
        
    }
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null) return true;
        if(intervals.length == 1){
            return true;
        }
        Arrays.sort(intervals, new IntervalComparator());
        
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < intervals[i-1].end){
                return false;
            }
        }
        return true;
    }
}