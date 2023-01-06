//Attempt #1 - 5mins
//Link: https://leetcode.com/problems/maximum-ice-cream-bars/

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for (int x : costs) {
            coins -= x;
            if (coins >= 0) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}

/*
 * Runtime
 * 60 ms
 * Beats
 * 12.32%
 * Memory
 * 74.9 MB
 * Beats
 * 31.99%
 * 
 * Time Complexity: O(nlogn)
 * Space Complexity: O(1)
 */

// Optimized Solution:

class Solution2 {
    // This method takes an array of ice cream costs and an amount of coins as input
    // and returns the maximum number of ice creams that can be bought with the
    // given coins
    public int maxIceCream(int[] costs, int coins) {
        // Initialize an array "count" to store the frequency of each cost in the input
        // array
        int[] count = new int[100001];
        // Iterate through the input array and increment the count of each cost
        for (int i = 0; i < costs.length; i++) {
            count[costs[i]]++;
        }
        // Initialize the answer (number of ice creams bought) to 0
        int answer = 0;
        // Iterate through the count array and try to buy as many ice creams of each
        // cost as possible

        for (int i = 1; i < 100001; i++) {
            // If there are ice creams of this cost available
            if (count[i] > 0) {
                // Calculate the maximum number of ice creams of this cost that can be bought
                // if coins are sufficient to buy all the ice cream at ith index then we can buy
                // all the ice cream at ith index else we can only buy coins / i ice cream
                int use = Math.min(coins / i, count[i]);
                // Subtract the cost of the ice creams from the coins
                coins -= use * i;
                // Add the number of ice creams bought to the answer
                answer += use;
            }
        }
        // Return the final answer
        return answer;
    }

}

/*
 * Runtime
 * 28 ms
 * Beats
 * 96.68%
 * Memory
 * 95.6 MB
 * Beats
 * 5.21%
 */