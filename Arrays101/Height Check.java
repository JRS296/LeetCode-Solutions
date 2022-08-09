class Solution {
    public int heightChecker(int[] heights) {
        int arr[] = new int[heights.length];
        for(int i=0; i<heights.length;i++)
        {
            arr[i] = heights[i];
        }
            
        int ans = 0;
            
        int size = heights.length;
        for (int step = 0; step < size - 1; step++) {
            int min_idx = step;
            for (int i = step + 1; i < size; i++) {
                if (arr[i] < arr[min_idx]) {
                    min_idx = i;
                }
            }
            int temp = arr[step];
            arr[step] = arr[min_idx];
            arr[min_idx] = temp;
        }
            
        for(int i=0; i<size; i++)
        {
            if(arr[i]!=heights[i])
            {
                ans+=1;
            }
        }
            
        return ans;
    }
}

/*
Runtime: 2 ms (beats 75%)
Memory Usage: 41.8 MB (beats 65%)

Overall Good Solution
 */