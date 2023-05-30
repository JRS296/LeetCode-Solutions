//Attempt #1 - 15mins
//Link: https://leetcode.com/problems/coin-change-ii/description/

//See this YT Vid VVVV Imp - https://www.youtube.com/watch?v=DJ4a7cmjZY0

class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length + 1][amount + 1];
        for(int i=0; i<=amount; i++) {
            dp[0][i] = 0;
        }

        for(int i=0; i<=coins.length; i++) {
            dp[i][0] = 1;
        }


        for(int i=1; i<=coins.length; i++) {
            for(int j=1; j<=amount; j++) {
                int include = 0;
                int exclude = 0;
                if(j-coins[i-1] < 0) exclude = dp[i-1][j];
                else {
                    include = dp[i][j - coins[i-1]];
                    exclude = dp[i-1][j];
                }

                dp[i][j] = include + exclude;
            }
        }

        // for(int x[] : dp) {
        //     System.out.println(Arrays.toString(x));
        // }

        return dp[coins.length][amount];
    }
}

/*
[1, 0, 0, 0, 0, 0]
[1, 1, 1, 1, 1, 1]
[1, 1, 2, 2, 3, 3]
[1, 1, 2, 2, 3, 4]
 */

/*
Runtime
9 ms
Beats
30.87%
Memory
46.2 MB
Beats
52.92%

TC - O(m*n)
SC - O(m*n)
 */