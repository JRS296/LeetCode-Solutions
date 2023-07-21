//Attempt #1 - DNA
//Link: https://leetcode.com/problems/interleaving-string/description/

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        dp = new int[s1.length() + 1][s2.length() + 1];
        return helper(0, 0, 0);
    }

    String s1;
    String s2;
    String s3;
    int[][] dp;

    private boolean helper(int i, int j, int k) {
        boolean isMatch = false;
        // base case
        if(k == s3.length()) return true;
        
        // we don't have to calculate it again, just return result
        if(dp[i][j] != 0) return dp[i][j] == 1;

        // if s1 matches pick s1
        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            isMatch = isMatch || helper(i + 1, j, k + 1);
        }

        // if s2 matches pick s2
        if(j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            isMatch = isMatch || helper(i, j + 1, k + 1);
        }

        // memorize the final answer
        dp[i][j] = isMatch ? 1 : -1;

        return isMatch;
    }   
}