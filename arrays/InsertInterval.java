"""
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Two intervals are considered overlapping if they share at least one point.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti
and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place.
You can make a new array and return it.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
"""

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        boolean inserted = false;

        for(int i=0 ; i < intervals.length ; i++){

            // if the interval is completely before newInterval
            if(intervals[i][1] < newInterval[0]){
                result.add(intervals[i]);
            }
            // if the interval is completely after newInterval
            else if(intervals[i][0] > newInterval[1]){
                if(!inserted){
                    result.add(newInterval);
                    inserted = true;
                }
                result.add(intervals[i]);
            }
            // if the intervals overlap
            else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        // check if the interval was not added
        if(!inserted){
            result.add(newInterval);
        }

        return result.toArray(new int[result.size()][]);
    }
}