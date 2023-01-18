//Attempt #1 - 0
//Link: https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/description/

//Understood how to traverse
//Figured out that DFS is required

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
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

        int x = dfs(list, 0, 0, hasApple);
        //System.out.println(x);
        return x;
    }

    public static int dfs(LinkedList < Integer > list[],int node, int arrival, List<Boolean> hasApple ) {
        //System.out.println(arrival + "--->"+node + " " );
        int total = 0;

        for(int i=0; i<list[node].size(); i++)
        {
            //System.out.println(node+" "+arrival);
            if (list[node].get(i) != arrival)
                total += dfs(list, list[node].get(i), node, hasApple);
        }

        if( node != 0 && (hasApple.get(node) || total > 0)) //VERY IMPORTANT
          total += 2;

        return total;
    }
}

/*
Runtime
26 ms
Beats
94.54%
Memory
85.8 MB
Beats
28.85%

Time: O(v+e)
Space: O(1)
 */