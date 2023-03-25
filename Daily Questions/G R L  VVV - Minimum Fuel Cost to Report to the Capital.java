//Attempt #1 - 120 mins
//Link: 

//Idea: Clear -> Math.ceil of total_nodes (here path) / seats
//Problem -> Handling Branch Cases + Understanding how to best implement this

class Solution {
    private long finAns = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
        int i = 0;
        int nodes = roads.length + 1;
        LinkedList<Integer> list[] = new LinkedList[nodes];
        while (i < list.length) {
            list[i++] = new LinkedList<Integer>();
        }

        for (int j = 0; j < roads.length; j++) {
            list[roads[j][0]].add(roads[j][1]);
            list[roads[j][1]].add(roads[j][0]);
        }
        // System.out.println(Arrays.toString(list));
        dfs(list, 0, 0, 0, seats, 0);
        // System.out.println(finAns);
        return finAns;
    }

    public void dfs(LinkedList<Integer> list[], int node, int arrival, int edgeLength, int seats, int sum) {
        if (seats == 1)
            sum += (edgeLength);
        else
            sum += (edgeLength % seats);

        finAns += sum;
        // System.out.println(node + " " + edgeLength + " " + sum);
        edgeLength++;
        int i = 0;
        while (i < list[node].size()) {
            if (list[node].get(i) != arrival)
                dfs(list, list[node].get(i), node, edgeLength, seats, sum);
            i++;
        }
    }
}

/*
11/121 TC
 */

 //Attempt #2 - Over 2hrs in
 
 class Solution2 {
    private long finAns = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
        int i = 0;
        int nodes = roads.length+1;
        LinkedList<Integer> list[] = new LinkedList[nodes];
        while(i<list.length) {
            list[i++] = new LinkedList<Integer>();
        }

        for(int j=0; j<roads.length; j++)
        {
            list[roads[j][0]].add(roads[j][1]);
            list[roads[j][1]].add(roads[j][0]);
        }
        //System.out.println(Arrays.toString(list));
        //dfs(list, 0, 0, 0, seats, 0);
        dfs(0,-1,list,seats);
        //System.out.println(finAns);
        return finAns;
    }

    // public void dfs(LinkedList<Integer> list[], int node, int arrival, int edgeLength, int seats, int sum) {  
    //     if(seats==1) sum+=(edgeLength);
    //     else sum += (edgeLength%seats);
        
    //     finAns += sum;
    //     //System.out.println(node + " " + edgeLength + " " + sum);
    //     edgeLength++;
    //     int i=0;
    //     while(i < list[node].size()){
    //         if (list[node].get(i) != arrival)
    //             dfs(list, list[node].get(i), node, edgeLength, seats, sum);
    //         i++;
    //     }
    // }

    public int dfs(int node,int parent,LinkedList<Integer> list[],int seats){
        int people=1;
        for(int adjnode:list[node]){
            if(adjnode==parent) continue;
            people+=dfs(adjnode,node,list,seats);
        }
        if(node!=0){
            finAns+=Math.ceil((double)people/seats);
        }
        return people;
    }
}

/*
Runtime
71 ms
Beats
46.60%
Memory
112.6 MB
Beats
13.25%

TC - O(V+E)
SC - Recusive Stack
 */

//Optimal Soln:

class SolutionOpt {
    public long minimumFuelCost(int[][] roads, int seats) {
      List<Integer>[] graph = new List[roads.length + 1];
  
      for (int i = 0; i < graph.length; ++i)
        graph[i] = new ArrayList<>();
  
      for (int[] road : roads) {
        final int u = road[0];
        final int v = road[1];
        graph[u].add(v);
        graph[v].add(u);
      }
  
      dfs(graph, 0, -1, seats);
      return ans;
    }
  
    private long ans = 0;
  
    private int dfs(List<Integer>[] graph, int u, int prev, int seats) {
      int people = 1;
      for (final int v : graph[u]) {
        if (v == prev)
          continue;
        people += dfs(graph, v, u, seats);
      }
      if (u > 0)
        // # of cars needed = ceil(people / seats)
        ans += (people + seats - 1) / seats;
      return people;
    }
  }

//IDK why its better tho

/*
Runtime
52 ms
Beats
89.26%
Memory
97 MB
Beats
62.85%
 */
