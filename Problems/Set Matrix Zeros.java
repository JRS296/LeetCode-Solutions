//Attempt #1 - 15mins
//Link: https://leetcode.com/problems/set-matrix-zeroes/description/

class Solution {
    public void setZeroes(int[][] matrix) { // https://leetcode.com/problems/set-matrix-zeroes/solutions/2525398/all-approaches-from-brute-force-to-optimal-with-easy-explanation/

        int m = matrix.length, n = matrix[0].length;
        boolean isRow0 = false, isCol0 = false;

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0)
                isRow0 = true;
        }

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0)
                isCol0 = true;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }

        if (isRow0) {
            for (int j = 0; j < n; j++)
                matrix[0][j] = 0;
        }

        if (isCol0) {
            for (int i = 0; i < m; i++)
                matrix[i][0] = 0;
        }
    }
}