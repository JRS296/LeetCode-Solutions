//Attempt #1 -20mins
//Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maximumProfit = 0, minStockVal = Integer.MAX_VALUE;
        int i = 0;
        while (i < n) {
            minStockVal = Math.min(minStockVal, prices[i]);
            // whenever the price of current stock is greater then then the stock value which we bought then only we will sell the stock 
            if (prices[i] >= minStockVal)
                maximumProfit = Math.max(maximumProfit, prices[i] - minStockVal);
            i++;
        }
        return maximumProfit;
    }
}

/*
Runtime
3 ms
Beats
21.67%
Memory
59 MB
Beats
64.97%
 */

//Attempt #2 - got the idea down, just got confused with O(n) implementations

class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int profit = 0;

        for(int i=0; i<prices.length ; i++) {
            buy = Math.min(buy,prices[i]);
            profit = Math.max(profit,prices[i]-buy);
            //System.out.println(buy + " " + profit);
        }

        return profit;
    }
}

/*
Runtime
2 ms
Beats
92.89%
Memory
59.5 MB
Beats
20.38%
 */