//Attempt #1 - DNA
//Link: https://leetcode.com/problems/maximum-alternating-subsequence-sum/description/

class Solution {
    public long maxAlternatingSum(int[] nums) {
        long dp[][] = new long[nums.length][2];
        return fun(0, nums, 1, dp);
    }

    long fun(int i, int[] nums, int prev, long[][] dp) {
        if (i >= nums.length)
            return 0;
        if (dp[i][prev] != 0)
            return dp[i][prev];
        long a = 0, b = 0;
        if (prev == 1) {
            a = fun(i + 1, nums, 0, dp) + nums[i];
            b = fun(i + 1, nums, 1, dp);
        } else {
            a = fun(i + 1, nums, 1, dp) - nums[i];
            b = fun(i + 1, nums, 0, dp);
        }
        return dp[i][prev] = Math.max(a, b);
    }
}