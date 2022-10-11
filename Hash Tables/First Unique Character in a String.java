//Attempt #1 - 12mins
//Link: https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1120/

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (hmap.containsKey(ch)) {
                hmap.put(ch, (hmap.get(ch) + 1));
            } else {
                hmap.put(ch, 1);
            }

        }
        // System.out.println(hmap);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (hmap.get(ch) == 1) {
                return i;
            } else {
                continue;
            }
        }

        return -1;
    }
}

/*
105 / 105 test cases passed.
Status: Accepted
Runtime: 35 ms - beats 48%
Memory Usage: 42.7 MB - beats 93%

Time Complexity: O(n)
Space Complexity: O(1) ???
 */