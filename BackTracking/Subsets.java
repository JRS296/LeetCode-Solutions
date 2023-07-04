//Attempt #1 - 15mins
//Link: https://leetcode.com/problems/subsets/description/

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, new ArrayList<Integer>(), 0);
        return ans;
    }

    public void helper (int nums[], ArrayList<Integer> temp, int x) {
        if(x <= nums.length) {
            ans.add(new ArrayList<Integer>(temp));
        }

        if(x>nums.length) return;

        for( int i=x; i<nums.length; i++) {
            temp.add(nums[i]);
            helper(nums, temp, i+1); //i+1 will give all subsets, x+1 will give all permutations with repition
            temp.remove(temp.size()-1);
        }
    }
}

/*
Runtime
1 ms
Beats
74.42%
Memory
41.8 MB
Beats
98.92%

TC - O(2^n)
 */