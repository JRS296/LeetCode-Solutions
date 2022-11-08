//Attempt #1 - 21mins
//Link: https://leetcode.com/explore/learn/card/binary-search/137/conclusion/977/

class Solution { // 21mins
    public char nextGreatestLetter(char[] letters, char target) {
        ArrayList<Character> ans = new ArrayList<Character>();
        for (int i = 0; i < letters.length; i++) {
            ans.add(letters[i]);
        }
        System.out.println(ans);

        // Case 1 (if target is not present)
        int l = 0;
        int r = ans.size() - 1;
        int tarval = target - '0';
        while (l < r) {
            int mid = l - (r - l) / 2;
            int curval = letters[mid] - '0';
            if (curval <= tarval) {
                if (mid == letters.length - 1) {
                    return letters[0];
                } else {
                    return letters[mid + 1];
                }
            } else if (curval > tarval) {
                l = mid;
            } else if (curval < tarval) {
                r = mid;
            }
        }

        // Case 2 (if target is present)

        // Case 3 (if target is not present but greater than letters[len])

        return letters[0];
    }

}

// Out of Bounds Error

// Solution 1 - linear tume
class Solution1 {
    public char nextGreatestLetter(char[] letters, char target) {
        for (char c : letters)
            if (c > target)
                return c;
        return letters[0];
    }
}

/*
 * 167 / 167 test cases passed.
 * Status: Accepted
 * Runtime: 1 ms
 * Memory Usage: 48.3 MB
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

// Solution 2 - logn time
class Solution2 {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0, hi = letters.length;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (letters[mi] <= target) lo = mi + 1;
            else hi = mi;
        }
        return letters[lo % letters.length];
    }
}

/*
167 / 167 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 42.6 MB

Time Complexity: O(log n)
Space Complexity: O(1)
 */

//This problem is logically incorrect. If letters wrap around, then: 'a'<'b'<'c'<...<'x'<'y'<'z'<'a'<'b'<'c'<... Every letter is larger than any other letter. Then all one needs to do is return letters[0].