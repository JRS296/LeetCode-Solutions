//Attempt #1 - 10mins
//Link: https://leetcode.com/problems/permutations/description/

class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        
        helper(nums, new ArrayList<Integer>(), 0);

        return ans;
    }

    public void helper(int nums[], List<Integer> temp, int x) {
        if(x==nums.length) ans.add(new ArrayList<Integer>(temp));

        for(int i=0; i<nums.length; i++) {
            if(temp.contains(nums[i])) continue; //If temp already contains, skip - Permutations law
            temp.add(nums[i]);
            helper(nums, temp, x+1);
            temp.remove(temp.size()-1);
        } 
    }
}

/*
Runtime
2 ms
Beats
41.81%
Memory
44.5 MB
Beats
5.31%

TC - O(2^n)
 */