package Intervals;
//Attempt #1 - null
//Link: https://leetcode.com/problems/insert-interval/description/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> left = new ArrayList<>();
        List<int[]> right = new ArrayList<>();
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            if (intervals[i][1] < newInterval[0]) {
                left.add(intervals[i]);
            } else if (intervals[i][0] > newInterval[1]) {
                right.add(intervals[i]);
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        int[][] result = new int[left.size() + 1 + right.size()][2];
        for (int i = 0; i < left.size(); i++) {
            result[i] = left.get(i);
        }
        result[left.size()] = newInterval;
        for (int i = 0; i < right.size(); i++) {
            result[left.size() + 1 + i] = right.get(i);
        }
        return result;
    }
}

/*
CHAT GPT:
This solution uses two separate lists left and right to store the intervals
 that are completely to the left and right of the new interval, respectively.
  Then, it iterates through the original list of intervals, merging any 
  interval that overlaps with the new interval. Finally, it returns the 
  concatenated result of the three lists.
 */

/*
Runtime
1 ms
Beats
98.54%
Memory
44.3 MB
Beats
93.47%

Time: O(n)
Space: O(n)
 */