//Attempt #1 - 45mins
//Link: https://leetcode.com/problems/delete-and-earn/description/?envType=study-plan-v2&id=dynamic-programming

//Fibonacci type

class Solution {
    int dp[];
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        dp = new int[nums.length];
        return recursion (nums, 0);
    }

    public int recursion(int nums[], int x) {
        if(x>=nums.length) return 0;

        if(dp[x]!=0) return dp[x];


        int index = x+1;
        int curSum = nums[x];
        int curVal = nums[x];

        //Add all same numbers
        while(index<nums.length && nums[index] == curVal) {
            curSum += nums[index];
            index++;
        }

        //Skip all index+1 nums
        while(index<nums.length && nums[index]==curVal+1) {
            index++;
        }

        dp[x] = Math.max(curSum + recursion(nums, index), recursion(nums, x+1));

        

        return dp[x];
    }
}

/*
Runtime
11 ms
Beats
47.83%
Memory
43.1 MB
Beats
56.98%

TC - O(n)
SC - O(n)
 */