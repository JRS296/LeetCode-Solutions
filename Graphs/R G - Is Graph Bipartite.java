//Attempt #1 - 30mins
//Link: https://leetcode.com/problems/is-graph-bipartite/description/

/*
Reference Links:
 - https://www.google.com/search?q=bipartite+graph&rlz=1C1CHBF_enIN922IN922&oq=bipartite&aqs=chrome.0.69i59j69i57j0i512l3j69i60l3.6299j0j7&sourceid=chrome&ie=UTF-8
 - https://takeuforward.org/graph/bipartite-graph-dfs-implementation/
 */

import java.util.Arrays;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int visited[] = new int[graph.length];
        Arrays.fill(visited, -1);

        // for connected components
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == -1) {
                if (dfs(i, 0, visited, graph) == false)
                    return false;
            }
        }
        System.out.println(Arrays.toString(visited));
        return true;
    }

    public boolean dfs(int node, int color, int vis[], int graph[][]) {
        vis[node] = color;
        for (int it : graph[node]) {
            // if uncoloured
            if (vis[it] == -1) {
                if (dfs(it, 1 - color, vis, graph) == false)
                    return false;
            }
            // if previously coloured and have the same colour
            else if (vis[it] == color) {
                return false;
            }
        }

        return true;
    }
}