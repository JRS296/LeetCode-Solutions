class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int ans[] = new int[r*c];
        int k=0;
        for(int count = 0; count<r+c-1; count++)
        {
            if(count%2==0)
            {
                for(int i=r*c-1; i>-1; i--)
                {
                    int r1 = i/c;
                    int c1 = i%c;
                    if(r1+c1==count)
                    {
                        ans[k++] = mat[r1][c1];
                    }
                }
            }
            else if(count%2!=0)
            {
                for(int i=0; i<r*c; i++)
                {
                    int r1 = i/c;
                    int c1 = i%c;
                    if(r1+c1==count)
                    {
                        ans[k++] = mat[r1][c1];
                    }
                }
            }
            
        }
        
        //System.out.println(Arrays.toString(ans));
        
        return ans;
    }
}

/*
All test Cases passed, but time limit exceeded:
O(n^2)
 */

class Solution2 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return new int[0];
        } 

        //Idea is the following
        //notice all values in the same diagonal share the same sum value of x index + y index
        //direction of going up right or going down left depends whether the index sum is even or odd
        //for each even or odd diagonal, there are three cases:
        // 1. there is room to go that direction 
        // 2. there is no row space to go further but there is col space 
        // 3. there is no col space to go further but there is row space
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] res = new int[rows * cols];
        int r = 0;
        int c = 0;
        for (int i = 0; i < rows * cols; i++) {
          res[i] = matrix[r][c];
          // even sum diagonal
          if ((r + c) % 2 == 0) {
            if (r - 1 >= 0 && c + 1 < cols) {
              c = c + 1;
              r = r - 1;
            } else if (r - 1 < 0 && c + 1 < cols) {
              c = c + 1;
            } else if (r + 1 < rows && c + 1 > cols - 1) {
              r = r + 1;
            }
          }
          // odd sum diagonal
          else if ((r + c) % 2 != 0) {
            if (r + 1 < rows && c - 1 >= 0) {
              c = c - 1;
              r = r + 1;
            } else if (r + 1 < rows && c - 1 < 0) {
              r = r + 1;
            } else if (r + 1 > rows - 1 && c +1 < cols) {
              c = c + 1;
            }
          }
        }
        return res;
    }
}

/*
Runtime: 5 ms (beats 45%)
Memory Usage: 54.5 MB (beats 71%)

Good Solution, understand the logic behind diagonal traversal.
 */