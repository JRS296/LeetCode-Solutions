//Attempt #1 - 2mins
//Link: https://leetcode.com/problems/matrix-diagonal-sum/description/

//Std O(n^2) soln

//Optimal (O(n))
class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for (int i = 0, end = mat.length - 1; i < mat.length; i++, end--) {
            sum += mat[i][i] + mat[i][end];
            if (i == end)
                sum -= mat[i][end];
        }
        return sum;
    }
}

/*
Runtime
0 ms
Beats
100%
Memory
42.5 MB
Beats
70.46%

TC - O(n)
SC - O(1)
 */