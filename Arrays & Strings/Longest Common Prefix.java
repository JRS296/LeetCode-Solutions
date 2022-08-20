//Attemp #1 - Time taken 30 mins
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        ans.append(strs[0]);
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() == 0) {
                return "";
            }
            for (int j = 0; j < strs[i].length(); j++) {
                if (j == ans.capacity() - 1) {
                    break;
                } else if (ans.charAt(j) != strs[i].charAt(j) && j == 0) {
                    return "";
                    // break;
                } else if (ans.charAt(j) != strs[i].charAt(j)) {
                    ans.delete(j, ans.capacity() - 1);
                    break;
                }
            }
            if (ans.capacity() == 0) {
                return "";
            }
        }
        String s = ans.toString();
        return s;
    }
}
/*
 * 34 / 124 test cases passed.
 * Took too much time, need to improve
 */

// Solution:
class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        return prefix;
    }
}
/*
Time Taken: 0ms
Space: 42mb
Time Complexity: O(n^2) or O(S) where S=sum of all characters
 */