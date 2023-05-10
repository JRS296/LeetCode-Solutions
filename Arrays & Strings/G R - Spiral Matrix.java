//Attempt 1 - 30 mins no solution
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        ArrayList<Integer> ans = new ArrayList<Integer>(r*c);
        
//         int count = 0;
//         for(int i=0; i<r*c; i++)
//         {
//             int r1 = i/c;
//             int c1 = i%c;
//         }
        int i=0;
        int j=0;
        for (int l = 0; l < r*c; l++) {
            while(j<c)
            {
                ans.add(matrix[i][j++]);
                //System.out.println(i+" "+j+" ");
            }
            i++;
            j--;
            //System.out.println(i+" "+j);
            while(i<r-1)
            {
                
                //ans.add(matrix[i++][j]);
                //i++;
                System.out.println(i+" "+j+" "+matrix[i][j]);
                ans.add(matrix[i][j]);
                i++;
            }
        }
        System.out.println(ans);
        return ans;
    }
}

//Solution - 4 pointer approach

class Solution2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length == 0 || matrix[0].length == 0) return res;
        
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        
        while(true){
            for(int i = left; i <= right; i++) res.add(matrix[top][i]);
            top++;
            if(left > right || top > bottom) break;
            
            for(int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            right--;
            if(left > right || top > bottom) break;
            
            for(int i = right; i >= left; i--) res.add(matrix[bottom][i]);
            bottom--;
            if(left > right || top > bottom) break;
            
            for(int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            left++;
            if(left > right || top > bottom) break;
        }
        
        return res;
    }
    
}
/*
Runtime: 0 ms
Memory Usage: 42.2 MB
Very Good solution - understand reason behind 4 pointers
 */