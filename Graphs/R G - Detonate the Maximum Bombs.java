//Attempt #1 - 20mins
//Link: https://leetcode.com/problems/detonate-the-maximum-bombs/description/

class Solution {
    int numBombs = 0;
    public int maximumDetonation(int[][] bombs) {
        ArrayList<Integer> bombGraph[] = new ArrayList[bombs.length];
        //List<List<Integer>> bombGraph = new ArrayList<>(bombs.length - 1);
        for(int i=0; i<bombs.length; i++) {
            bombGraph[i] = new ArrayList<Integer>();
            for(int j=0; j<bombs.length; j++) {
                if(i!=j) {
                    long x1 = bombs[i][0];
                    long y1 = bombs[i][1];
                    long r1 = bombs[i][2];
                    long x = bombs[j][0];
                    long y = bombs[j][1];
                    long distanceSq = (x - x1) * (x - x1) + (y - y1) * (y - y1);
                    if (distanceSq <= r1 * r1) {
                        bombGraph[i].add(j);
                    }
                }
            }
        }

        System.out.println(Arrays.asList(bombGraph));
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<bombs.length; i++) {
            numBombs = 0;
            boolean[] visited = new boolean[bombs.length];
            dfs(bombGraph, visited, i);
            ans = Math.max(ans, numBombs);
        }

        return ans;
    }

    public void dfs(ArrayList<Integer> graph[], boolean[] visited, int cur ) {
        visited[cur] = true;
        numBombs++;
        for(int i=0; i<graph[cur].size(); i++) {
            int val = graph[cur].get(i);
            if(!visited[val]) dfs(graph, visited, val);
        }
    }
}

/*Build a graph such that 
- Each bomb points to bombs that it can detonate

to do this, make a function to see if bomb can detonate another
*/

/*

 */