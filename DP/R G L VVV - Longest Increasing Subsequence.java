//Attepmt #1 - 10mins
//Link: https://leetcode.com/problems/longest-increasing-subsequence/description/?envType=study-plan-v2&id=dynamic-programming

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i=nums.length-1; i>-1; i--) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] < nums[j]) dp[i] = Math.max(dp[i], 1+dp[j]);
            }
        }

        System.out.println(Arrays.toString(dp));
        return Arrays.stream(dp).max().getAsInt();
    }
}

/*
Runtime
83 ms
Beats
34.21%
Memory
43.2 MB
Beats
50.61%
 */