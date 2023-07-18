//Attempt #1 - 35mins
//Link: https://leetcode.com/problems/edit-distance/

class Solution {
    public int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();

    int[][] dp = new int[m + 1][n + 1];

    for (int i = 0; i <= m; i++) {
        dp[i][0] = i;
    }

    for (int j = 0; j <= n; j++) {
        dp[0][j] = j;
    }

    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1];
            } else {
                dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
    }

    return dp[m][n];
}

//https://leetcode.com/problems/edit-distance/solutions/3230613/day-57-recursive-memoization-dp-c-easiest-beginner-friendly-sol/
}

/*
Runtime
6 ms
Beats
68.90%
Memory
42.9 MB
Beats
96.96%
 */