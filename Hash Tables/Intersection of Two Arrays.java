//Attempt #1 - 20mins
//Link: https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1105

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }
}

/*
55 / 55 test cases passed.
Status: Accepted
Runtime: 2 ms
Memory Usage: 42.4 MB

Time Complexity: O(n) - very good
Space Complexity: O(n+m) - very good
*/