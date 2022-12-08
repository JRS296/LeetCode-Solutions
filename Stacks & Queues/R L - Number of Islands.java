//Attempt #1 - 15mins (after seeing soln)
//Link: https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1374/

public class Solution { // Using Flood Fill Algorithm - sinking islands 1 by 1 i.e. via DFS

    private int n;
    private int m;

    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0)
            return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
        }
        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1')
            return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }
}

/*
 * Runtime
 * 7 ms
 * Beats
 * 60.74%
 * Memory
 * 58.4 MB
 * Beats
 * 7.57%
 * 
 * Time Complexity: O(mxn)
 * Space Complexity: O(1)
 */

// Optimal Solution #1 - Using BFS
class Solution1 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfsFill(grid, i, j);
                    count++;
                }
            }
        return count;
    }

    private void bfsFill(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        int n = grid.length;
        int m = grid[0].length;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int code = x * m + y;
        queue.offer(code);
        while (!queue.isEmpty()) {
            code = queue.poll();
            int i = code / m;
            int j = code % m;
            if (i > 0 && grid[i - 1][j] == '1') // search upward and mark adjacent '1's as '0'.
            {
                queue.offer((i - 1) * m + j);
                grid[i - 1][j] = '0';
            }
            if (i < n - 1 && grid[i + 1][j] == '1') // down
            {
                queue.offer((i + 1) * m + j);
                grid[i + 1][j] = '0';
            }
            if (j > 0 && grid[i][j - 1] == '1') // left
            {
                queue.offer(i * m + j - 1);
                grid[i][j - 1] = '0';
            }
            if (j < m - 1 && grid[i][j + 1] == '1') // right
            {
                queue.offer(i * m + j + 1);
                grid[i][j + 1] = '0';
            }
        }
    }
}

// Optimal Solution #1 - Using DFS (Basically Flood Fill)
class Solution2 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfsFill(grid, i, j);
                    count++;
                }
            }
        return count;
    }

    private void dfsFill(char[][] grid, int i, int j) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            dfsFill(grid, i + 1, j);
            dfsFill(grid, i - 1, j);
            dfsFill(grid, i, j + 1);
            dfsFill(grid, i, j - 1);
        }
    }
}