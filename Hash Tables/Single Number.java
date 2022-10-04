//Attempt #1 - 10mins
//Link: https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1176

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();

        for (int x : nums) {
            if (hmap.containsKey(x)) {
                hmap.put(x, hmap.get(x) + 1);
                continue;
            }
            hmap.put(x, 1);
        }

        for (int x : nums) {
            if (hmap.get(x) == 1) {
                return x;
            }
        }
        return 0;
    }
}

/*
61 / 61 test cases passed.
Status: Accepted
Runtime: 11 ms - Not Optimal, but its something
Memory Usage: 42.6 MB - Good

Time Complexity: O(n)
Space Complexity: O(n)
 */