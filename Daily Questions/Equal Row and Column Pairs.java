//Attempt #1 - 25mins
//Link: https://leetcode.com/problems/equal-row-and-column-pairs/description/

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for(int [] row: grid){
            String rowStr = Arrays.toString(row);
            hashMap.put(rowStr, hashMap.getOrDefault(rowStr,0)+1);
        }
        
        int count = 0;
        for(int j = 0;j<n;j++){
            int [] col = new int[n];
            for(int i = 0;i<n;i++){
                col[i] = grid[i][j];
            }
            count+=hashMap.getOrDefault(Arrays.toString(col),0);
        }
        return count;
    }
}

/*
Runtime
49 ms
Beats
48.20%
Memory
46.1 MB
Beats
96.55%

TC - O(n^2)
SC - O(n^2)
 */