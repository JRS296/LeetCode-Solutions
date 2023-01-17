//Attempt #1 - infinity
//Link: https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/description/

// TC: O(e + v), SC: (e + v)

class Solution {
    int ans[]
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        LinkedList <Integer> list[] = new LinkedList[n + 1];
        int i=0;
        while(i < list.length){
            list[i] = new LinkedList <Integer> ();
            i++;
        }

        for(int[] x:edges){
            list[x[0]].add(x[1]);
            list[x[1]].add(x[0]);
        }

        dfs(list, 0, 0);
        return new int[5];
    }

    /*
Use DFS for Traversal
Each node should return an array of size 26 to the parent, containing count of all labels in the subtree of that node.
store that count for each node label in the output array
    */

    public static void dfs(LinkedList <Integer> list[],int node, int arrival) {
        System.out.println(node);
        int i=0;
        while(i < list[node].size()){
            if (list[node].get(i) != arrival)
                dfs(list, list[node].get(i), node);
            i++;
        }
    }
}




//Attempt #2
class Solution {
    // globally declaring the ans array and adjacency list 
    private int[] ans; 
    private List<Integer>[] adj;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        adj = new List[n];     // initialising the adjacency list
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {     // populating the adjacency list
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        ans = new int[n];      // initialising the answer array
        dfs(0, -1, labels);    // calling the dfs
        return ans;
    }

    private int[] dfs(int currNode, int parent, String labels) {
        // Our DFS will go to the depth and bring us frequencies of characters present in each subtree, 
        // go to bottom and come back to top with frequencies
        int[] currSubtreeFreq = new int[26];    // records the frequency of all characters in the current node's subtree
        for (int child : adj[currNode]) {       // we look at all the nodes connected to our current node
            // we don't want to go back to parent node where we came from
            if (child == parent) {  // so keep iterating if child is equal to parent              
                continue;
            }
            // we now call dfs to record the frequencies of all characters present in the subtree of the child
            int[] childSubtreeFreq = dfs(child, currNode, labels);     // child becomes new the currentNode, currentNode becomes the new parent
            // we update our currSubtreeFreq array after we get childSubtreeFreq array populated
            // because child's subtree is a part of our current node's subtree
            for (int i = 0; i < 26; i++) {      
                currSubtreeFreq[i] += childSubtreeFreq[i];
            }
        }
        // the current node is also associated to a character so we update currSubtreeFreq
        currSubtreeFreq[labels.charAt(currNode) - 'a']++;
        // now, currSubtreeFreq contains the frequency of all characters present in subtree.
        // but now we just need the frequency of that particular character which is associated to our current node
        // say current node value is 1 and the letter associated is 'a'. 
        // so we need the frequency of 'a's that are in the subtree
        ans[currNode] = currSubtreeFreq[labels.charAt(currNode) - 'a'];
        return currSubtreeFreq;    // we return the current subtree frequency array which will be utilised upon backtracking
    }
}

/*
Runtime
68 ms
Beats
76.23%
Memory
108.3 MB
Beats
84.84%

Time Complexity: O(v+e)
 */