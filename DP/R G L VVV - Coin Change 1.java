//Attempt #1 - 20mins
//Link: https://leetcode.com/problems/coin-change/description/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i = 0 ; i<=coins.length ; i++){
            dp[i][0] = 0;
        }
        
        for(int j = 1 ; j<=amount ; j++){
            dp[0][j] = Integer.MAX_VALUE - 1;
        }
        
        for(int i = 1 ; i<=coins.length ; i++){
            for(int j = 1 ; j<=amount ; j++){
                
                if(coins[i - 1] <= j){
                    dp[i][j] = Math.min( 1+ dp[i][j-coins[i-1]] , dp[i-1][j]); 
                }
                else
                    dp[i][j] = dp[i-1][j]; 
            }
        }

        if(dp[coins.length][amount] > amount)
                 return -1 ;
        return dp[coins.length][amount] ;
    }
}

/*
Runtime
20 ms
Beats
49.20%
Memory
43.9 MB
Beats
9.65%

T.C: O(n*m)
S.C: O(n*M)
 */