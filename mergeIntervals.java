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
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
       if(intervals.size() == 0 || intervals == null || intervals.size() == 1){
           return intervals;
       }
       Collections.sort(intervals, new IntervalComparator());
       ArrayList<Interval> rst = new ArrayList<Interval>();
       Interval first = intervals.get(0);
       Interval tmp = new Interval();
       
       for(int i = 1; i < intervals.size(); i++){
           Interval curr = intervals.get(i);
           if(curr.start <= first.end){
               first.end = Math.max(first.end, curr.end);
           }else{
               rst.add(first);
               first = curr;
           }
       }
       rst.add(first);
       return rst;
    }
    private class IntervalComparator implements Comparator<Interval>{
        public int compare(Interval a, Interval b){
            return a.start - b.start;
        }
    }
}