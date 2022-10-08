//Attempt #1 - 16mins
//Link: https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1117/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hmap = new HashMap<>();
        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (hmap.containsKey(c1)) {
                if (hmap.get(c1) != c2) {
                    return false;
                }
                // else if()
                // {

                // }
                // System.out.println("*");
            } else {

                // System.out.println("**");
                hmap.put(c1, c2);
            }
        }
        System.out.println(hmap);

        return true;
    }
}

/*
 * 37 / 44 test cases passed.
 */

// Attempt #2 - 10mins
class Solution {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length())
            return false;

        HashMap<Character, Character> hmap = new HashMap<Character, Character>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (hmap.containsKey(c1)) {
                if (hmap.get(c1) != c2) {
                    return false;
                }
                // else if()
                // {

                // }
                // System.out.println("*");
            } else {
                HashSet<Character> x = new HashSet<Character>(hmap.values());
                // System.out.println(x);
                hmap.put(c1, c2);

                if (x.contains(hmap.get(c1))) {
                    // System.out.println("LMao");
                    return false;
                }
            }
        }
        // System.out.println(hmap);
        return true;
    }
}

/*
44 / 44 test cases passed.
Status: Accepted
Runtime: 12 ms
Memory Usage: 43.9 MB

Time Complexity: O(n) - beats 66% - WEll done
Space Complexity: O(n+n) - beats 14%
 */

