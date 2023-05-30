//Attempt #1 - 5mins
//Link: https://leetcode.com/problems/last-stone-weight/description/

class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while (maxHeap.size() != 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            maxHeap.offer(Math.abs(stone1 - stone2));
        }
        return maxHeap.poll();
    }
}

/*
TC - O(nlogn)
SC - O(n)
 */