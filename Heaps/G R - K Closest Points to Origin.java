//Attempt #1 - 12mins
//Link: https://leetcode.com/problems/k-closest-points-to-origin/description/

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if(k == points.length) return points;
        HashMap<Double, int[]> hmap = new HashMap<Double, int[]>(points.length);
        for(int x[] : points) {
            double dist = Math.sqrt(Math.pow(x[0],2)+Math.pow(x[1],2));
            hmap.put(dist, x);
        }

        PriorityQueue<Double> pq = new PriorityQueue<Double>();
        for (double val : hmap.keySet()) {
            pq.offer(val);
        }

        int ans[][] = new int[k][2];
        for(int i=0; i<k; i++) {
            int arr[] = hmap.get(pq.poll());
            ans[i] = arr;
        }

        return ans;
    }
}

//85/87 - error in o/p format

//Optimal Soln

class Solution {
    public int[][] kClosest(int[][] points, int K) {
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
    for (int[] p : points) {
        pq.offer(p);
        if (pq.size() > K) {
            pq.poll();
        }
    }
    int res[][] = new int[K][2];
    while (K > 0) {
        res[--K] = pq.poll();
    }
    return res;
}
}

/*
Runtime
40 ms
Beats
46.59%
Memory
47 MB
Beats
97.45%

TC - nlogn
SC - log n
 */