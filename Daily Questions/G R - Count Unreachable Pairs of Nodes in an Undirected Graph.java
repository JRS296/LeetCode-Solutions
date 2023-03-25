//Attempt #1 - 30mins
//Link: https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/

class Solution {
    //private HashSet<Integer> visited = new HashSet<Integer>();
    //private ArrayList<Integer> number = new ArrayList<Integer>();

    public long countPairs(int n, int[][] edges) {
        long ans = 0;
        LinkedList<Integer> list[] = new LinkedList[n];
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();

        for(int i=0; i<list.length; i++) {
            list[i] = new LinkedList<Integer>();
        }
        for(int i=0; i<edges.length; i++) {
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);
        }

        //System.out.println(Arrays.toString(list));

        for(int i=0; i<list.length; i++) {
            //System.out.println(list[i]);
            if(!hmap.containsKey(list[i].size())) hmap.put(list[i].size(), 1);
            else {
                hmap.put(list[i].size(),hmap.get(list[i].size()) + 1);
            }
        }

        ArrayList<Integer> valueList = new ArrayList<Integer>(hmap.values());

        //System.out.println(valueList);

        for(int i=0; i<valueList.size(); i++) {
            for(int j=i+1; j<valueList.size(); j++) {
                ans += (valueList.get(i) * valueList.get(j));
            }
        }

        return ans;
    }
}

/*
6/66 TC passed
 */

//Optimal Solution:


public class Solution {

    private List<Integer>[] graph;

    public long countPairs(int n, int[][] edges) {
        createGraph(n, edges);
        boolean[] visited = new boolean[n];
        int numVisitedNodes = 0;
        long numUnreachablePairsOfNodes = 0;

        for (int node = 0; node < n; ++node) {
            if (!visited[node]) {
                int numNodesInCurrentGroup = depthFirstSearch_countConnectedNodesInCurrentGroup(node, visited);
                numUnreachablePairsOfNodes += (long) numNodesInCurrentGroup * numVisitedNodes;
                numVisitedNodes += numNodesInCurrentGroup;
            }
        }
        return numUnreachablePairsOfNodes;
    }

    private int depthFirstSearch_countConnectedNodesInCurrentGroup(int node, boolean[] visited) {
        visited[node] = true;
        int numConnectedNodes = 1;

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                numConnectedNodes += depthFirstSearch_countConnectedNodesInCurrentGroup(neighbor, visited);
            }
        }
        return numConnectedNodes;
    }

    private void createGraph(int n, int[][] edges) {
        graph = new List[n];
        for (int node = 0; node < n; ++node) {
            graph[node] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; ++i) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
    }
}

//TC: O(V+E)
//SC: O(V)