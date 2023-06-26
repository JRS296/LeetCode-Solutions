//Attempt #1 - 15mins
//Link: https://leetcode.com/problems/total-cost-to-hire-k-workers/description/

import java.util.PriorityQueue;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long ans = 0;
        PriorityQueue<Integer> left = new PriorityQueue<Integer>();
        PriorityQueue<Integer> right = new PriorityQueue<Integer>();
        int i=0;
        int j=costs.length - 1;

        while(k-- > 0) {
            while(left.size()<candidates && i<=j) {
                left.offer(costs[i++]);
            }

            while(right.size()<candidates && i<=j) {
                right.offer(costs[j--]);
            }

            int t1 = left.size() > 0 ? left.peek() : Integer.MAX_VALUE;
            int t2 = right.size() > 0 ? right.peek() : Integer.MAX_VALUE;

            if (t1 <= t2) {
                ans += t1;
                left.poll();
            } else {
                ans += t2;
                right.poll();
            }
        }


        return ans;
    }
}

/*
Runtime
63 ms
Beats
80.80%
Memory
58.5 MB
Beats
12.25%

TC - O(n)
SC - O(n+m)
 */