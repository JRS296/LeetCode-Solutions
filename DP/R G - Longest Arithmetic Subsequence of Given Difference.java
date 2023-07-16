//Attempt #1 - 10mins
//Link: https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/description/

class Solution { //34/39
    public int longestSubsequence(int[] nums, int difference) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i=nums.length-1; i>-1; i--) {
            for(int j=i+1; j<nums.length; j++) {
                if((nums[j] - nums[i]) == difference) dp[i] = Math.max(dp[i], 1+dp[j]);
            }
        }

        //System.out.println(Arrays.toString(dp));
        return Arrays.stream(dp).max().getAsInt();
    }
}

/*
TLE - 34/39
 */

//Solution
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        Map<Integer, Integer> dp = new HashMap<>(); // Stores the maximum length at each index
        
        int ans = 1; // Initialize with the minimum length of 1
        
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if (dp.containsKey(num - difference)) {
                dp.put(num, dp.get(num - difference) + 1);
            } else {
                dp.put(num, 1);
            }
            
            ans = Math.max(ans, dp.get(num));
        }
        
        return ans;
    }
}