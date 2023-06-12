//Attempt #1 - 20mins
//Link: https://leetcode.com/problems/summary-ranges/description/

class Solution {
    public List<String> summaryRanges(int[] nums) {
       ArrayList<String> al=new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            int start=nums[i];
            while(i+1<nums.length && nums[i]+1==nums[i+1])
                i++;
            
            if(start!=nums[i]){
                al.add(Integer.toString(start)+"->"+Integer.toString(nums[i]));
            }
            else{
                al.add(Integer.toString(start));
            }
        }
        return al;
    }
}

/*
Runtime
6 ms
Beats
33.52%
Memory
40.9 MB
Beats
73.61%
 */