//Attempt #1 - 5mins
//Link: https://leetcode.com/problems/find-the-highest-altitude/description/

class Solution {
    public int largestAltitude(int[] gain) {
        int highest = 0;
        int curVal = 0;
        for(int i=0; i<gain.length; i++) { 
            curVal += gain[i];
            highest = Math.max(curVal, highest);
        }
        return highest;
    }
}

/*
Runtime
0 ms
Beats
100%
Memory
40.2 MB
Beats
82.89%

TC - O(n)
SC - O(1)
 */