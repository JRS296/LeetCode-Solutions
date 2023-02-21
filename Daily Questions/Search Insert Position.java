//Attempt #1 - 3mins
//Link: https://leetcode.com/problems/search-insert-position/description/

class Solution {
    public int searchInsert(int[] nums, int target) {
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]>=target) return i;
        }
        return nums.length;
    }
}

/*
Runtime
0 ms
Beats
100%
Memory
41.9 MB
Beats
50.67%

Time: O(n)
Space: O(1)
 */