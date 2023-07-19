package Intervals;

//Attempt #1 - 20mins
//Link: https://leetcode.com/problems/non-overlapping-intervals/submissions/

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        //If Meeting of next set is greater than previous - meeting can be scheduled
        // [1,2] [2,3] [1,3] [3,4]
        // Here, 3rd one can't e scheduled because of 3 from [2,3] > 1 from [1,3]

        int prev = 0;
        int count = 1;
        for(int i=1; i<n; i++) {
            if(intervals[prev][1] <= intervals[i][0]) {
                prev = i;
                count++;
            }
        }
        //count is total num of meetings that can be scheduled
        //n-count - num of meetings that cannot be scheduled (here) overlapping intervals
        return n-count;
    }
}
