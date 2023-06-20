//Attempt #1 - 17mins
//Link: https://leetcode.com/problems/k-radius-subarray-averages/description/

import java.util.Arrays;

class Solution {
    public int[] getAverages(int[] nums, int k) {
        System.out.println(nums.length);
        int ans[] = new int[nums.length];
        Arrays.fill(ans, -1);
        int j=0;
        long sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
            if(i>=(k*2)) {
                // System.out.println(i-k + " " + sum/(k*2 + 1));
                ans[i-k] = (int)(sum/(k*2 + 1));
                sum-=nums[j++];
            }
        }
        return ans;
    }
}

/*
Runtime
13 ms
Beats
21.97%
Memory
60.5 MB
Beats
72.49%

TC - O(n)
SC - O(1)
 */