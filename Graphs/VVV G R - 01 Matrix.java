//Attempt #1 - whole day
//Link: https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1388

//Flood fill BFS, not working for second test case due to stack overflow, cant
//ascertain reason yet

class Solution {
    public int[][] updateMatrix(int[][] mat) { //Using Flood Fill
        int ans[][] = new int[mat.length][mat[0].length];
        for(int i=0; i<mat.length; i++)
        {
            for(int j=0; j<mat[0].length; j++)
            {
                if(mat[i][j]==0)
                    continue;
                
                int dist = fill(mat, i, j);
                //System.out.println(dist + "" + i + " " + j);
                ans[i][j] = dist;
            }
        }
        
        return ans;
    }
    
    public int fill(int[][] image, int sr, int sc) {
        int sum = 0;
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] == 0) return 0;
        else if (image[sr][sc] == 1) 
        {
            // count++;
            //System.out.println(image[sr][sc] + " " + sr + " " + sc+" ");
            
            return fill(image, sr + 1, sc)+fill(image, sr - 1, sc)+fill(image, sr, sc + 1)+fill(image, sr, sc - 1) + 1;
            
        } 
        return 1;
    }
}

//Solution: 
public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
                else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n || 
                    matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) continue;
                queue.add(new int[] {r, c});
                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
            }
        }
        
        return matrix;
    }
}
//REDO