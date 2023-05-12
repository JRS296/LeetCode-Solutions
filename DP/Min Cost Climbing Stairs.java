//Attempt #1 - 16mins
//Link: https://leetcode.com/problems/min-cost-climbing-stairs/description/?envType=study-plan-v2&id=dynamic-programming

//Bottom Up Iterative
class Solution { // 16mins
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n];
        int minCost = 0;

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        // System.out.println(Arrays.toString(cost));
        // System.out.println(Arrays.toString(dp));
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}

/*
 * Runtime
 * 1 ms
 * Beats
 * 64.38%
 * Memory
 * 42.7 MB
 * Beats
 * 19.79%
 * 
 * TC - O(n)
 * SC - O(n)
 */

// Attempt #2 - 5 mins
class Solution {
    // Top Down Memoization - O(n) 1ms
    int[] dp;

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        return Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
    }

    private int minCost(int[] cost, int n) {
        if (n < 0)
            return 0;
        if (n == 0 || n == 1)
            return cost[n];
        if (dp[n] != 0)
            return dp[n];
        dp[n] = cost[n] + Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
        return dp[n];
    }
}

/*
Runtime
1 ms
Beats
64.38%
Memory
42 MB
Beats
90.95%

TC - O(n)
SC - Recursive Stk
 */