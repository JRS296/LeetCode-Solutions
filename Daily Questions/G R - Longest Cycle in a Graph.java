//Attempt #1 - 20mins
//Link: https://leetcode.com/problems/longest-cycle-in-a-graph/

class Solution {
    private int longestCycleVal = -1;

    public int longestCycle(int[] edges) {
        ArrayList<Integer> visited = new ArrayList<Integer>();
        for (int i = 0; i < edges.length - 1; i++) {
            if (visited.contains(i))
                continue;
            dfs(i, visited, 0, edges);
            System.out.println("Hello - " + i);
            System.out.println(visited);
        }
        return longestCycleVal;
    }

    public void dfs(int curr, ArrayList<Integer> visited, int sum, int[] edges) {
        System.out.println(curr + " " + sum);
        if (visited.contains(curr)) {
            longestCycleVal = Math.max(sum, longestCycleVal);
            return;
        }

        visited.add(curr);
        dfs(edges[curr], visited, sum += 1, edges);

    }
}

/*
Not sure if this was the right track
 */

//Optimal Soln 

class Solution {
    public int longestCycle(int[] edges) {
      int ans = -1; // Initialize the answer to -1
      int time = 1; // Initialize the current time step to 1
      int[] timeVisited = new int[edges.length]; // Initialize an array to store the time at which each node was first visited
  
      // Iterate through each node in the graph
      for (int i = 0; i < edges.length; ++i) {
        if (timeVisited[i] > 0) // If the node has already been visited, skip it
          continue;
        final int startTime = time; // Record the start time of the current traversal
        int u = i; // Initialize the current node to the ith node
        // Traverse the graph until the end of the path is reached or a visited node is encountered
        while (u != -1 && timeVisited[u] == 0) {
          timeVisited[u] = time++; // Record the current time step and increment time
          u = edges[u]; // Move to the next node in the path
        }
        // If a cycle is found that includes the current node, update the answer
        if (u != -1 && timeVisited[u] >= startTime)
          ans = Math.max(ans, time - timeVisited[u]);
      }
  
      return ans; // Return the length of the longest cycle found
    }
  }

/*
Runtime
11 ms
Beats
100%
Memory
53.3 MB
Beats
96.53%

TC: - O(N)
SC - O(N)
 */

//Attempt #2 - 20 mins

class Solution {
  private int longestCycleVal = -1;

  public int longestCycle(int[] edges) {
      ArrayList<Integer> visited = new ArrayList<Integer>();
      int timer[] = new int[edges.length];
      for (int i = 0; i < edges.length - 1; i++) {
          if (visited.contains(i))
              continue;
          dfs(i, visited, 0, edges, timer);
          //System.out.println("Hello - " + i + " " + longestCycleVal);
          //System.out.println(visited);
      }
      return longestCycleVal;
  }

  public void dfs(int curr, ArrayList<Integer> visited, int time, int[] edges, int[] timer) {
      
      //System.out.println(curr + " " + Arrays.toString(timer) + " " + time);
      if(curr==-1) return;
      if (visited.contains(curr)) { //condition if curr becomes -1?
          longestCycleVal = Math.max((time-timer[curr]), longestCycleVal);
          return;
      }
      timer[curr] = time;
      visited.add(curr);
      dfs(edges[curr], visited, time += 1, edges, timer);

  }
}

/*
50/76 TC passed
 */