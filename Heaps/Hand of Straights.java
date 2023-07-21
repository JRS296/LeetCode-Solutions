//Attempt #1 - 5mins
//Link: https://leetcode.com/problems/hand-of-straights/description/

class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if(hand.length % W != 0) return false;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int elem: hand) minHeap.add(elem);

        while(!minHeap.isEmpty()){
            int head = minHeap.poll();
            for(int i=1; i<W; i++)
                if(!minHeap.remove(head+i)) return false;
        }
        return true;
    }
}