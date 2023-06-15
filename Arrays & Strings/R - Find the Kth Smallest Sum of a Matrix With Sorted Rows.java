//Attempt #1 - 25mins
//Link: https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/description/

class Solution {
    public int kthSmallest(int[][] mat, int k) {
	int col = Math.min(mat[0].length, k);

	PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	pq.add(0);
	for (int[] row : mat) {
		// max priority queue for the i-th row
		PriorityQueue<Integer> nextPq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i : pq) {
			for (int c = 0; c < col; c++) {
				nextPq.add(i + row[c]);
				// keep pq size <= k
				if (nextPq.size() > k) {
					nextPq.poll();
				}
			}
		}
		pq = nextPq;
	}
	return pq.poll();
}
}

/*
Runtime
365 ms
Beats
18.39%
Memory
44.3 MB
Beats
13.79%

TC - O(m * n * c * log(n))
 */