//Attempt #1 - 10mins
//Link: https://leetcode.com/problems/unique-paths/description/

class Solution { //Top Down
    int dp[][];
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        return helper(m-1, n-1);
    }

    public int helper(int i, int j) {
        System.out.println(i+" "+j);
        if(i==0 & j==0) return 1;
        if(i<0 || j<0) return 0;

        if(dp[i][j]!=0) return dp[i][j];
        
        int up = helper(i, j-1);
        int left = helper(i-1, j);

        return dp[i][j] = up+left;
    }
}

class Solution2 { //Bottom Up
    
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i==0 && j==0) {
                    dp[i][j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;
                if(i>0) up = dp[i-1][j];
                if(j>0) left = dp[i][j-1];

                dp[i][j] = up+left;
            }
        }

        return dp[m-1][n-1];
    }
}