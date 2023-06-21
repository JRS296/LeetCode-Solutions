//Attempt #1 - 1hr50mins
//Link: https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/

//Bit round about, but wanted a backtracking soln to print all LIS

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    ArrayList<ArrayList<Integer>> LIS = new ArrayList<ArrayList<Integer>>();
    public int findNumberOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        //List<Integer> ans = new ArrayList<Integer>();
        Arrays.fill(dp, 1);
        for(int i=nums.length-1; i>-1; i--) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] < nums[j]) dp[i] = Math.max(dp[i], 1+dp[j]);
            }
        }
        //To find one of the subsequences
        int i = Arrays.stream(dp).max().getAsInt();
        int ptr = 0;

        int a = 0;
        for(int x:dp) {
            if(x==1) a++;
        }
        if(a == dp.length) return a;

        AIS(i, ptr, new ArrayList<Integer>(), dp, nums);
        return LIS.size();
    }

    public void AIS(int i, int ptr, ArrayList<Integer> temp, int dp[], int nums[]) { //All Increasing Subsequences (does not work for [2,2,2,2,2])
        if(i==1 && dp[ptr]==i) {
            temp.add(nums[ptr]);
            LIS.add(new ArrayList<Integer>(temp));
            return;
        }

        for(int x=ptr; x<dp.length-1; x++) {
            if(dp[x]!=dp[x+1]) break;
            AIS(i, x+1, new ArrayList<Integer>(temp), dp, nums);
        }

        if(dp[ptr]!=i) AIS(i, ptr+1, temp, dp, nums);
        if (dp[ptr]==i) {
            temp.add(nums[ptr]);
            AIS(i-1, ptr+1, temp, dp, nums);
        }
        return;
    }
}

//23/223

//Optimal Soln:

class Solution2 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, max_len = 0;
        int[] len =  new int[n], cnt = new int[n];
        for(int i = 0; i<n; i++){
            len[i] = cnt[i] = 1;
            for(int j = 0; j <i ; j++){
                if(nums[i] > nums[j]){
                    if(len[i] == len[j] + 1)cnt[i] += cnt[j];
                    if(len[i] < len[j] + 1){
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            
            if(max_len == len[i])res += cnt[i];
            if(max_len < len[i]){
                max_len = len[i];
                res = cnt[i];
            }
            // System.out.println(Arrays.toString(len));
            // System.out.println(Arrays.toString(cnt) + " " + res);
        }
        return res;
    }
        // System.out.println(Arrays.toString(dp));
}

/*
[1, 0, 0, 0, 0]
[1, 0, 0, 0, 0] 1
[1, 2, 0, 0, 0]
[1, 1, 0, 0, 0] 1
[1, 2, 3, 0, 0]
[1, 1, 1, 0, 0] 1
[1, 2, 3, 3, 0]
[1, 1, 1, 1, 0] 2
[1, 2, 3, 3, 4]
[1, 1, 1, 1, 2] 2

[1, 0, 0, 0, 0]
[1, 0, 0, 0, 0] 1
[1, 1, 0, 0, 0]
[1, 1, 0, 0, 0] 2
[1, 1, 1, 0, 0]
[1, 1, 1, 0, 0] 3
[1, 1, 1, 1, 0]
[1, 1, 1, 1, 0] 4
[1, 1, 1, 1, 1]
[1, 1, 1, 1, 1] 5
 */