//Attempt #1 - 20mins
//Link: 

//Idea - general floodfill
class Solution {
    private int minValue = Integer.MAX_VALUE;

    public int minPathSum(int[][] grid) {
        List<Integer> list = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        printMatrix(grid, m - 1, n - 1, 0, 0, list, 0);
        return minValue;
    }

    private void printMatrix(int mat[][], int m, int n, int i, int j, List<Integer> list, int sum) {
        // return if i or j crosses matrix size
        if (i > m || j > n)
            return;
        // list.add(mat[i][j]);
        sum += mat[i][j];
        if (i == m && j == n) {
            minValue = Math.min(minValue, sum);
        }
        printMatrix(mat, m, n, i + 1, j, list, sum);
        printMatrix(mat, m, n, i, j + 1, list, sum);
        // list.remove(list.size()-1);
    }
}

/*
 * 25/61 - TLE
 * 24 if using ArrayList
 */

// Attempt #2 - DP Answer
// https://leetcode.com/problems/minimum-path-sum/solutions/3345656/python-java-c-simple-solution-easy-to-understand/

/*
 * Video: https://www.youtube.com/watch?v=t1shZ8_s6jc
 * 
 * Approach:
 * The code implements a dynamic programming approach to find the minimum path
 * sum in a grid.
 * 
 * The algorithm uses a 2D array to store the minimum path sum to reach each
 * position (i, j) in the grid, where i represents the row and j represents the
 * column.
 * 
 * The minimum path sum to reach each position (i, j) is computed by taking the
 * minimum of the path sum to reach the position above (i-1, j) and the position
 * to the left (i, j-1), and adding the cost of the current position (i, j).
 * 
 * The minimum path sum to reach the bottom-right corner of the grid is stored
 * in the last element of the array (grid[m-1][n-1]), where m is the number of
 * rows and n is the number of columns in the grid.
 * 
 * Intuition:
 * The intuition behind the dynamic programming approach is that the minimum
 * path sum to reach a position (i, j) in the grid can be computed by
 * considering the minimum path sum to reach the positions (i-1, j) and (i,
 * j-1).
 * 
 * This is because the only two possible ways to reach the position (i, j) are
 * either by moving down from (i-1, j) or moving right from (i, j-1).
 * 
 * By computing the minimum path sum to reach each position in the grid, the
 * algorithm can find the minimum path sum to reach the bottom-right corner of
 * the grid by simply looking at the last element of the array (grid[m-1][n-1]).
 */

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0]; //Filling up special case where only single path is optimal
        }

        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[m - 1][n - 1];
    }
}

/*
Runtime
2 ms
Beats
76.27%
Memory
45.1 MB
Beats
61.91%

TC-O(m*n)
SC-O(m*n)
 */