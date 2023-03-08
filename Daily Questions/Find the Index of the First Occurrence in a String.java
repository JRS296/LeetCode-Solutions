//Attempt #1 - 15mins
//Link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/

class Solution {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length();
        int l2 = needle.length();
        if (l2 > l1) {
            return -1;
        }
        if (l2 == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < l1 + 1 - l2; i++) {
            // System.out.println(haystack.substring(i,i+l2));
            if (haystack.substring(i, i + l2).equals(needle)) {
                // System.out.println("Heya");
                ans = i;
                break;
            } else {
                ans = -1;
            }
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
41 MB
Beats
10.89%
 */
