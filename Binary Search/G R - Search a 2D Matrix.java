//Attempt #1 - 15mins
//Link: https://leetcode.com/problems/search-a-2d-matrix/description/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m*n - 1;

        while(low <= high) {
            int mid = low+(high-low)/2; //Never use (high-low)/2
            int val = matrix[mid/n][mid%n];
            //System.out.println(val + " " + high + " " + low);
            if(val == target) return true;
            else if (val > target) high = mid-1;
            else if (val < target) low = mid+1;
        }

        return false;
    }
}

/*Remember:
2d matrix of m*n
no. of rows = mid/n
no. of cols= mid%n

mid = M*n/2
*/

/*
Runtime
0 ms
Beats
100%
Memory
41.3 MB
Beats
97.43%
 */