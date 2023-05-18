//Attempt #1 - 10mins
//Link: https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/description/https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/description/

//Learn what indegree and outdegree is - https://www.google.com/search?q=what+is+indegree+and+outdegree+of+a+graph&rlz=1C1CHBF_enIN922IN922&oq=what+is+indeggree&aqs=chrome.1.69i57j0i13i512l3j0i13i30l2j0i13i15i30j0i8i13i30j0i390i650.4706j0j7&sourceid=chrome&ie=UTF-8

class Solution { // Concept of inedges and outedges
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int arr[] = new int[n];
        for(List<Integer> x : edges) {
            arr[x.get(1)]++;
        }
        //System.out.println(Arrays.toString(arr));

        List<Integer> ans = new ArrayList<Integer>();

        for(int i=0; i<arr.length; i++) {
            if(arr[i]==0) ans.add(i);
        }

        return ans;
    }
}

/*
Runtime
11 ms
Beats
77.29%
Memory
79 MB
Beats
78.78%

TC - O(N)
SC - O(n)
 */