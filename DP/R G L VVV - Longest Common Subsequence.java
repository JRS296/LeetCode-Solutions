//Attempt #1 - 5mins
//Link: https://leetcode.com/problems/longest-common-subsequence/description/?envType=study-plan-v2&id=dynamic-programming

class Solution {
    public int longestCommonSubsequence(String str1, String str2) {
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
35 ms
Beats
41.42%
Memory
48.1 MB
Beats
89.15%
 */

 //Soln that gives string as well

 class Solution2 {
    public int longestCommonSubsequence(String str1, String str2) {
        String dp[][] = new String[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = "";
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + str1.charAt(i - 1);
                else
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
            }
        }
        return dp[str1.length()][str2.length()].length();
    }
}

//MLE - 46/48