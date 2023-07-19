//Attempt #1 - 25mins
//Link: https://leetcode.com/problems/burst-balloons/description/

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = 1;
        arr[arr.length - 1] = 1;
        for(int i = 1; i < arr.length - 1; i++) arr[i] = nums[i-1];

        int[][] dp = new int[arr.length][arr.length];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        return helper(arr, 1, arr.length - 2, dp);
    }

    private int helper(int[] nums, int i, int j, int[][] dp) {
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int max = Integer.MIN_VALUE;
        for(int k = i; k <= j; k++) {
            max = Math.max((nums[i-1] * nums[k] * nums[j+1]) + helper(nums, i, k-1, dp) + helper(nums, k+1, j, dp), max);
        }

        return dp[i][j] = max;
    }
}