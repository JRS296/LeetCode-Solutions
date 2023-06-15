//Attempt #1 - 10mins
//Link: https://leetcode.com/problems/first-missing-positive/description/

class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> hset = new HashSet<Integer>();
        long max = Long.MIN_VALUE;

        for (int x: nums) {
            max = Math.max(max,x);
            hset.add(x);
        }

        for(int i=1; i<=max+1; i++) {
            if(hset.add(i)) return i;
            else if(!hset.add(i)) continue;
        }

        return 1;
    }
}

/*
Runtime
17 ms
Beats
9.16%
Memory
58.7 MB
Beats
20.78%
 */