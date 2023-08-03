//Attempt #1 - 10mins
//Link: https://leetcode.com/problems/number-of-provinces/description/

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<Integer> graph[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = (new ArrayList<Integer>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    graph[i].add(j);
                    // graph[j].add(i);
                }
            }
        }

        int[] vis = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i] != 1) {
                count++;
                dfs(graph, vis, i);
            }
        }
        return count;
    }

    public void dfs(ArrayList<Integer> graph[], int vis[], int i) {
        vis[i] = 1;
        for (int x : graph[i]) {
            if (vis[x] == 0)
                dfs(graph, vis, x);
        }

        return;
    }
}