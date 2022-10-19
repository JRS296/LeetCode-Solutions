//Attempt #1 - 8mins
//Link: https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1136/

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> hs = new HashSet<Character>(jewels.length());
        int ans = 0;
        for (int i = 0; i < jewels.length(); i++) {
            hs.add(jewels.charAt(i));
        }

        for (int i = 0; i < stones.length(); i++) {

            if (hs.contains(stones.charAt(i))) {
                ans++;
            }
        }
        // System.out.println(hs);

        return ans;
    }
}

/*
255 / 255 test cases passed.
Status: Accepted
Runtime: 3 ms - beats 35%
Memory Usage: 42.4 MB - beats 50%

Time Complexity: O(n)
Space Complexity: O(n)
 */