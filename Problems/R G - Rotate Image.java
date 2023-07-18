//Attempt #1 - 10mins
//Link: https://leetcode.com/problems/rotate-image/description/

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        //Column Reverse
        for(int i = 0; i < n; i++){
            int a = 0;
            int b = n-1;
            while(a <= b){
               int temp = matrix[a][i];
                matrix[a][i] = matrix[b][i];
                 matrix[b][i] = temp;
                 a++;
                 b--;
            }
            
        }
           
        //Transpose
        for(int i = 0; i < n; i++){
            for(int j =i+1; j< n; j++){
                int temp =  matrix[i][j];
                 matrix[i][j] =  matrix[j][i];;
                 matrix[j][i] = temp;
            }
        }
        
    }
}