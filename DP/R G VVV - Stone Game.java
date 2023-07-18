//Attempt #1 - null
//Link: https://leetcode.com/problems/stone-game/description/

class Solution {
    public boolean stoneGame(int[] p) {
        int n = p.length;
        int[][] dp  = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = p[i];
        for (int d = 1; d < n; d++)
            for (int i = 0; i < n - d; i++)
                dp[i][i + d] = Math.max(p[i] - dp[i + 1][i + d], p[i + d] - dp[i][i + d - 1]);
        return dp[0][n - 1] > 0;
    }
}

/*
What if piles.length can be odd?
What if we want to know exactly the diffenerce of score?
Then we need to solve it with DP.

dp[i][j] means the biggest number of stones you can get more than opponent picking piles in piles[i] ~ piles[j].
You can first pick piles[i] or piles[j].

If you pick piles[i], your result will be piles[i] - dp[i + 1][j]
If you pick piles[j], your result will be piles[j] - dp[i][j - 1]
So we get:
dp[i][j] = max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1])
We start from smaller subarray and then we use that to calculate bigger subarray.

Note that take evens or take odds, it's just an easy strategy to win when the number of stones is even.
*/

//Another Solution

class Solution2 {
    public boolean stoneGame(int[] piles) {
        int a = 0;
        int b = 0;
        int n = piles.length;
        for(int i = 0; i < n/2; i++) {
            int min = piles[i];
            int max = piles[n-1-i];
            a += Math.max(max, min);
            b += Math.min(max, min);
        }
        return a>b;
    }

    public boolean stoneGame2(int[] num) {
        int Asum=0,Bsum=0;
        int n=num.length;
        for(int i=0;i<n;i++)
        {   
            Asum+=Math.max(num[i],num[n-1-i]);            
        }
        for(int i=1;i<n;i++)
        {
            Bsum+=Math.max(num[i],num[n-1-i]);
        }
        if(Asum>Bsum)return true;
        else
        return false;
    }
}