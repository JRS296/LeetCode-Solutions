//Attempt #1 - 10mins
//Link: https://leetcode.com/problems/maximum-subarray/submissions/

class Solution {
    public int maxSubArray(int[] nums) {
        int curMax = 0;
        int max = Integer.MIN_VALUE;

        for(int x : nums) {
            curMax = Math.max(curMax + x, x);
            max = Math.max(curMax, max);
        }

        return max;
    }
}