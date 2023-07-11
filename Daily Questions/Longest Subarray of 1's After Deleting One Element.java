//Attempt #1 - 12mins
//Link: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/

class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;

        int left = 0;
        int zeros = 0;
        int ans = 0;

        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > 1) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1 - zeros);
        }
        return (ans == n) ? ans - 1 : ans;
    }
}

/*
Runtime
2 ms
Beats
84.58%
Memory
53.1 MB
Beats
52.90%

TC - O(N)
SC - O(1)
 */