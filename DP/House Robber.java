//Attempt #1 - 20mins
//Link: https://leetcode.com/problems/house-robber/description/?envType=study-plan-v2&id=dynamic-programming

class Solution { //Top Down
    public int rob(int[] nums) {
        return helper(nums,nums.length-1);
    }

    public int helper(int nums[], int n) {
        if(n<0) return 0;
        return Math.max(helper(nums,n-2)+nums[n], helper(nums,n-1));
    }
}

//TLE

//Attempt #2 - (recursion + memoization)
class Solution { //Top Down
    int dp[];
    public int rob(int[] nums) {
        dp = new int[nums.length];

        return helper(nums,nums.length-1);
    }

    public int helper(int nums[], int n) {
        if(n<0) return 0;
        if(dp[n]!=0) return dp[n];
        dp[n] = Math.max(helper(nums,n-2)+nums[n], helper(nums,n-1)); 
        return dp[n];
    }
}

//TLE - 67/70

//Attempt #3 - Iterative - bottom up - 20 mins

class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i=2; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        System.out.println(Arrays.toString(dp));

        return dp[nums.length-1];
    }
}

/*
Runtime
1 ms
Beats
100%
Memory
40.6 MB
Beats
9.42%

TC - O(N)
SC - O(n)
 */


