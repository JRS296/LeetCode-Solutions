//Attempt #1 - 10mins
//Link: https://leetcode.com/problems/kth-largest-element-in-a-stream/description/

import java.util.*;
class KthLargest {
    private PriorityQueue<Integer> heap = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (var n : nums) add(n);
    }
    
    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) heap.poll();
        return heap.peek();
    }

    /*
    Use a min heap and maintain its size at k elements. By doing this we ensure that the root node of the heap is always the kth largest element.
    */
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

 /*
Runtime
17 ms
Beats
66.67%
Memory
48.8 MB
Beats
53.78%
  */