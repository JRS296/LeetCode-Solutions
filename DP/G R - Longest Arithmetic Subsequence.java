//Attempt #1 - null
//Link: https://leetcode.com/problems/longest-arithmetic-subsequence/description/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if (n <= 2)
            return n;

        int longest = 2;
        Map<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                longest = Math.max(longest, dp[i].get(diff));
            }
        }

        return longest;
    }
}

/*
Runtime
652 ms
Beats
46.60%
Memory
70.7 MB
Beats
22.45%

TC - O(n^2)
 */