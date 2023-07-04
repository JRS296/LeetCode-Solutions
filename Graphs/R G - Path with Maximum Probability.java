//Attempt #1 - 15mins
//Link: https://leetcode.com/problems/path-with-maximum-probability/description/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Pair<Integer,Double> pr = new Pair(5,0.0);
        /*
        1. Create Adjacency List for All edges
        2. Create a max prob for each node traversing from 0 to n
        3. BFS, update array at each iteration
        */ 

        ArrayList<Pair<Integer,Double>> ad[] = new ArrayList[n];
        for(int j=0;j<n;j++) {
            ad[j] = new ArrayList<>();
        }
        int i=0;
        for(int arr[] : edges) {
            int n1 = arr[0];
            int n2 = arr[1];
            double p = succProb[i++];
            ad[n1].add(new Pair(n2,p));
            ad[n2].add(new Pair(n1,p));
        }

        //BFS
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        double distances[] = new double[n];
        distances[start] = 1;

        while(!q.isEmpty()) {
            int currNode = q.poll();
            for(Pair<Integer,Double> pair : ad[currNode]) {
                int n1 = currNode;
                int n2 = pair.getKey();
                double p = pair.getValue();
                double newProb = distances[n1] * p;

                if(newProb > distances[n2]) {
                    distances[n2] = newProb;
                    q.add(n2);
                }
            }
        }


        return distances[end];
    }
}