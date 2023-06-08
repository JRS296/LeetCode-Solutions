//Attempt #1 - 5mins
//Link: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/

class Solution {
    public int countNegatives(int[][] grid) {
         int rows = grid.length;
         int columns = grid[0].length;
         
         //start position in the left bottom (but it can be right top)
         int i = rows - 1;
         int j = 0;
         
         int result = 0;
         while(i>=0 && j<columns) {
             if(grid[i][j]<0) {
                 i--;                         //switch to the upper row
                 result += columns - j;       //add to result count of all numbers from current ot the end of row (because of sorted row)
             } else {
                 j++;                         //switch to the right column
             }
         }
         
         return result;
     }
 }

/*
TC - O(log n)
SC - O(1)
 */