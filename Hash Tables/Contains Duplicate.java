//Attempt #1 - 0mins
//Link: https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1112/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet hset = new HashSet<>();
        for (int x : nums) {
            if (hset.contains(x)) {
                return true;
            }
            hset.add(x);
        }
        return false;
    }
}

/*
70 / 70 test cases passed.
Status: Accepted
Runtime: 26 ms
Memory Usage: 68.4 MB
 */