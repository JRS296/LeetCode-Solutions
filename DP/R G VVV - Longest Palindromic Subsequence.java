//Attempt #1 - 10mins
//Link: https://leetcode.com/problems/longest-palindromic-subsequence/description/

class Solution { //LCS with string and reverse of string -> LPS
    public int longestPalindromeSubseq(String s) {
        StringBuilder temp = new StringBuilder(s.length());
        temp.append(s).reverse();
        String str1 = s;
        String str2 = temp.toString();
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[str1.length()][str2.length()];
    }
}

/*
Runtime
110 ms
Beats
17.51%
Memory
54.5 MB
Beats
35.46%
 */