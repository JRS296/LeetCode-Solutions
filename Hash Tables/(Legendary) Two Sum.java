//Attempt #1 - 10mins
//Link: https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1115/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];
        HashMap<Integer, Integer> hmap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            hmap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int b = target - a;
            if (hmap.containsKey(b) && hmap.get(b) != i) {
                ans[0] = i;
                ans[1] = hmap.get(b);
            }
        }

        return ans;
    }
}

/*
57 / 57 test cases passed.
Status: Accepted
Runtime: 4 ms (beats 86%)
Memory Usage: 43.1 MB (beats 84%)

Time Complexity: O(n) - Very good solution
Space Complexity: O(n)
 */