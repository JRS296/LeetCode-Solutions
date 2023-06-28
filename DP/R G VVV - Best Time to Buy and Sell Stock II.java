//Attempt #1 - 15mins
//Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solutions/803206/python-js-java-go-c-o-n-by-dp-greedy-visualization/

class Solution { 
    public int maxProfit(int[] prices) {
        int hold = -Integer.MAX_VALUE, notHold = 0;
        
        for( int stockPrice : prices ){
            
            int prevHold = hold, prevNotHold = notHold;
            
            // either keep hold, or buy in stock today at stock price
            hold = Math.max(prevHold, prevNotHold - stockPrice);
            
            // either keep not-hold, or sell out stock today at stock price
            notHold = Math.max(prevNotHold, prevHold + stockPrice);
            
        }
        
        // maximum profit must be in not-hold state
        return notHold;
    }
}

/*
Runtime
1 ms
Beats
92.95%
Memory
44.4 MB
Beats
54.68%
 */