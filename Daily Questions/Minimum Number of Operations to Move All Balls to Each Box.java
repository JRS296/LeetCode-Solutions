//Attempt #1 - 10mins
//Link: https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description/

class Solution {
    public int[] minOperations(String boxes) {
        int len=boxes.length();
        int ans[]=new int[len];

        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(boxes.charAt(j)=='1' && i!=j){
                    ans[i]+=Math.abs(i-j);
                }
            }
        }
        return ans;

        
    }
}