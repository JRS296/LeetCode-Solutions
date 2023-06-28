//Attempt #1 - 30mins
//Link: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/

import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
          PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> pq = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        int n = nums1.length;
        int m = nums2.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int sum = nums1[i] + nums2[j];

                if (pq.size() < k) {
                    pq.offer(new Pair<>(sum, new Pair<>(nums1[i], nums2[j])));
                } else if (sum < pq.peek().getKey()) {

                    pq.poll();
                    pq.offer(new Pair<>(sum, new Pair<>(nums1[i], nums2[j])));
                } else {
                    break;
                }
            }
        }

        //System.out.println(pq);

        List<List<Integer>> ans = new ArrayList<Integer>();

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.poll().getValue();
            List<Integer> pairList = new ArrayList<Integer>();
            pairList.add(pair.getKey());
            pairList.add(pair.getValue());
            ans.add(pairList);
        }

        return ans;
    }
}

/*
Runtime
143 ms
Beats
7.30%
Memory
60.8 MB
Beats
14.43%
 */