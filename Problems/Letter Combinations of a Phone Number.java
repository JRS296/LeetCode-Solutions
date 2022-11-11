//Attempt #1 - 40mins
//Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, ArrayList<String>> hmap = new HashMap<Character, ArrayList<String>>();
        List<String> ans = new ArrayList<String>();
        if (digits.length() == 0) {
            // List<String> x2 = new ArrayList<String>();
            return ans;
        }

        hmap.put('2', new ArrayList<String>(Arrays.asList("a", "b", "c")));
        hmap.put('3', new ArrayList<String>(Arrays.asList("d", "e", "f")));
        hmap.put('4', new ArrayList<String>(Arrays.asList("g", "h", "i")));
        hmap.put('5', new ArrayList<String>(Arrays.asList("j", "k", "l")));
        hmap.put('6', new ArrayList<String>(Arrays.asList("m", "n", "o")));
        hmap.put('7', new ArrayList<String>(Arrays.asList("p", "q", "r", "s")));
        hmap.put('8', new ArrayList<String>(Arrays.asList("t", "u", "v")));
        hmap.put('9', new ArrayList<String>(Arrays.asList("w", "x", "y", "z")));

        System.out.println(hmap);
        ans = null;
        for (int i = 0; i < digits.length(); i++) {
            char s = digits.charAt(i);
            System.out.println(hmap.get(s));
            ans = API(ans, hmap.get(digits.charAt(i)));
        }

        return ans;
    }

    public List<String> API(List<String> x, ArrayList<String> y) {
        // System.out.println(y);
        List<String> x2 = new ArrayList<String>();
        if (x == null) {
            return y;
        } else {

            for (int i = 0; i < x.size(); i++) {
                for (int j = 0; j < y.size(); j++) {
                    String fin = "";
                    fin = x.get(i) + y.get(j);
                    x2.add(fin);
                }
            }
        }
        return x2;
    }
}

/*
 * Runtime: 7 ms, faster than 37.84% of Java online submissions for Letter
 * Combinations of a Phone Number.
 * Memory Usage: 43 MB, less than 26.06% of Java online submissions for Letter
 * Combinations of a Phone Number.
 * 
 * Time Complexity: O(2^n) ??
 * Space Complexity: O(n)
 */

// Optimal Solution: (Using Recursion)
public class Solution {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> ret = new LinkedList<String>();
        if (digits.length() == 0) {
            // List<String> x2 = new ArrayList<String>();
            return ret;
        }
        combination("", digits, 0, ret);
        return ret;
    }

    private void combination(String prefix, String digits, int offset, List<String> ret) {
        if (offset >= digits.length()) {
            ret.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, ret);
        }
    }
}

/*
 * Runtime: 11 ms, faster than 14.93% of Java online submissions for Letter
 * Combinations of a Phone Number.
 * Memory Usage: 42.9 MB, less than 34.22% of Java online submissions for Letter
 * Combinations of a Phone
 * 
 * Time Complexity: O(4^n)
 * Space Complexity: O(n);
 */
