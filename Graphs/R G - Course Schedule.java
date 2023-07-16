//Solution 1
class Solution { //Cycle Detection
    public boolean detectCycle(List<List<Integer>> v, int src, int[] rst, int[] vis) {
        vis[src] = 1;
        rst[src] = 1;
        for (int x : v.get(src)) {
            if (vis[x] == 0 && detectCycle(v, x, rst, vis)) {
                return true;
            } else if (rst[x] == 1) {
                return true;
            }
        }
        rst[src] = 0;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> v = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            v.add(new ArrayList<>());
        }
        Stack<Integer> s = new Stack<>();
        int[] vis = new int[numCourses];
        int[] rst = new int[numCourses];
        for (int[] x : prerequisites) {
            v.get(x[1]).add(x[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0 && detectCycle(v, i, rst, vis)) {
                return false;
            }
        }
        return true;
    }
}

// class Solution { //Via Kahn Algo - Topo Sort
//     public boolean canFinish(int n, int[][] prerequisites) {
//         List<Integer>[] adj = new List[n];
//         int[] indegree = new int[n];
//         List<Integer> ans = new ArrayList<>();

//         for (int[] pair : prerequisites) {
//             int course = pair[0];
//             int prerequisite = pair[1];
//             if (adj[prerequisite] == null) {
//                 adj[prerequisite] = new ArrayList<>();
//             }
//             adj[prerequisite].add(course);
//             indegree[course]++;
//         }

//         Queue<Integer> queue = new LinkedList<>();
//         for (int i = 0; i < n; i++) {
//             if (indegree[i] == 0) {
//                 queue.offer(i);
//             }
//         }

//         while (!queue.isEmpty()) {
//             int current = queue.poll();
//             ans.add(current);

//             if (adj[current] != null) {
//                 for (int next : adj[current]) {
//                     indegree[next]--;
//                     if (indegree[next] == 0) {
//                         queue.offer(next);
//                     }
//                 }
//             }
//         }

//         return ans.size() == n;
//     }
// }

/*
Yes -- you're right -- topological sort works on a DAG, and if your graph is a DAG, then the topological sort will process all of the nodes. Contrapositive: If the topological sort doesn't process all of the nodes, then the graph is not a DAG. So you can use that to solve the problem with topological sort.

DFS solves it with the same running time complexity, but when I solved it, I chose topological sort to avoid having up to 2000 nested recursive calls with DFS. I think neither solution is better -- just use the one that comes more naturally to you!
*/

/*
Actually there are 2 ways to resolve this problem.
so it depends on which works for you.
We can use DFS to detect cycle in the grahp
or
Use topological sort and check if the sorted length and the numcourse are the same or not. if not that means there are cycles in the grahp
It really depends on which you like
both solution make sense to me.
*/

//Solution #2
class Solution { //Via Kahn Algo - Topo Sort
    public boolean canFinish(int n, int[][] prerequisites) {
        List<Integer>[] adj = new List[n];
        int[] indegree = new int[n];
        List<Integer> ans = new ArrayList<>();

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            if (adj[prerequisite] == null) {
                adj[prerequisite] = new ArrayList<>();
            }
            adj[prerequisite].add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            ans.add(current);

            if (adj[current] != null) {
                for (int next : adj[current]) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }

        return ans.size() == n;
    }
}

/*
Yes -- you're right -- topological sort works on a DAG, and if your graph is a DAG, then the topological sort will process all of the nodes. Contrapositive: If the topological sort doesn't process all of the nodes, then the graph is not a DAG. So you can use that to solve the problem with topological sort.

DFS solves it with the same running time complexity, but when I solved it, I chose topological sort to avoid having up to 2000 nested recursive calls with DFS. I think neither solution is better -- just use the one that comes more naturally to you!
*/

/*
Actually there are 2 ways to resolve this problem.
so it depends on which works for you.
We can use DFS to detect cycle in the grahp
or
Use topological sort and check if the sorted length and the numcourse are the same or not. if not that means there are cycles in the grahp
It really depends on which you like
both solution make sense to me.
*/