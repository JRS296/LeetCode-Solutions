//Attempt #1 - 15mins
//Link: https://leetcode.com/problems/shuffle-the-array/description/

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int ans[] = new int[n*2];
        int k=0;
        for(int i=0, j=n; i<nums.length-n || j<nums.length; i++, j++)
        {
            ans[k] = nums[i];
            ans[k+1] = nums[j];
            k+=2;
        }
        return ans;
    }
}

/*
Runtime
0 ms
Beats
100%
Memory
42.4 MB
Beats
60.91%

Time: O(n)
Space: O(n)
 */