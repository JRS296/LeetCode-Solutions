//Attempt #1 - 22mins
//Link: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n= matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        
        while(low < high){
            int mid = low + (high - low)/2;
            int count = lessEqual(matrix,mid);
            if(count < k){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return low;
        
    }
    
    //from left bottom or right top we can count how many numbers are equal or less than our target
    
    public int lessEqual(int[][] matrix, int target){
        int count = 0 , len = matrix.length, i = len-1, j=0;
        
        while(i >=0 && j<len){
            if(matrix[i][j] > target){
                i--;
            }
            else
            {
                count = count + i +1;
                j++;
            }
        }
        return count;
    }
}

/*
Runtime
0 ms
Beats
100%
Memory
47.1 MB
Beats
84.30%

TC - O(low * high)
SC - O(low * high)
 */