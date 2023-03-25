//Attempt #1 - 15mins
//Link: https://leetcode.com/problems/number-of-operations-to-make-network-connected/

class Solution { // Cheese Method
    public int makeConnected(int n, int[][] connections) {
        int ans = 0;
        if (connections.length < n - 1)
            return -1;
        else {
            HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++) {
                hmap.put(i, 0);
            }

            for (int i = 0; i < connections.length; i++) {
                int from = connections[i][0];
                int to = connections[i][1];
                hmap.put(from, hmap.getOrDefault(from, 0) + 1);
                hmap.put(to, hmap.getOrDefault(to, 0) + 1);
            }

            List<Integer> valueList = new ArrayList(hmap.values());
            for (int i = 0; i < valueList.size(); i++) {
                int temp = valueList.get(i);
                if (temp == 0)
                    ans++;
            }
            System.out.println(hmap);
        }
        return ans;
    }
}

/*
 * This 88 computers connected in 2 different networks. So, you have 87
 * connected and 2 connected between
 * each other. In a result you need minimum 13 connections.
 */

// 25/36 TC passed

// Optimal Method - 1 -> DFS
class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1)
            return -1;

        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new HashSet<>());
        for (int[] connection : connections) {
            int u = connection[0], v = connection[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] visited = new int[n];
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                components++;
                dfs(i, graph, visited);
            }
        }

        return components - 1;
    }

    private int dfs(int node, List<Set<Integer>> graph, int[] visited) {
        if (visited[node] != 0)
            return 0;
        visited[node] = 1;
        for (int neighbor : graph.get(node))
            dfs(neighbor, graph, visited);
        return 1;
    }
}

/*
Runtime
27 ms
Beats
25.61%
Memory
74 MB
Beats
7.86%

TC - O(N+E)
SC - O(N)
 */


//Optimal #2 - Union Find
//Link: https://leetcode.com/problems/number-of-operations-to-make-network-connected/solutions/3331562/from-75-to-100-union-find-with-images-java-c/

class Solution {
    int[] parent;
    int[] rank;
    int find(int x){
        while(parent[x]!=x){
            x = parent[parent[x]];
        }
        return x;
    }
    int makeUnion(int x, int y){
        int parX = find(x);
        int parY = find(y);
        if(parX == parY){
            return 0;
        }
        else if(rank[parX]<rank[parY]){
            parent[parX] = parY;
        }
        else if(rank[parX]>rank[parY]){
            parent[parY] = parX;
        }
        else{
            parent[parY] = parX;
            rank[parX]++;
        }
        return 1;
    }
    public int makeConnected(int n, int[][] connections) {
        int edges = connections.length;
        if(edges<n-1){
            return -1;
        }
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        int components = n;
        for(int[] con : connections){
            components -= makeUnion(con[0], con[1]);
        }
        return components-1;
    }
}

/*
Runtime
2 ms
Beats
100%
Memory
56.1 MB
Beats
86.55%

Time complexity: O(N+E)
Space complexity: O(N)
 */