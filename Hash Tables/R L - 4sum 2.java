//Attempt #1 - null
//Link: https://leetcode.com/problems/4sum-ii/discuss/1740606/Going-from-O(N4)-greater-O(N3)-greater-O(N2)-JavaC%2B%2B

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int k : nums3)
            for(int l : nums4)
                map.put(k + l, map.getOrDefault(k + l, 0) + 1);
        int count = 0;
        for(int i : nums1)
            for(int j : nums2)
                        count += map.getOrDefault(-(i + j), 0);
        return count;
    }
}

/*

132 / 132 test cases passed.
Status: Accepted
Runtime: 228 ms
Memory Usage: 56.9 MB
 */

//Study this one PROPERLY