import java.util.*;

class Solution { //My solution: Memory Efficient(0.1 percentile), not space efficient (95 percentile)
    public int removeDuplicates(int[] nums) {
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++)
        {
            a1.add(nums[i]);
        }
        ArrayList<Integer> uq = unique(a1, a1.size());
        System.out.println(uq);
        for(int i=0; i<uq.size(); i++)
        {
            nums[i] = uq.get(i);
        }
        return(uq.size());
    }
    
    public static ArrayList<Integer> unique(ArrayList<Integer> arr, int len) {
        ArrayList<Integer> uq = new ArrayList<Integer>();
        for (int i = 0; i < len; i++) {
            if (uq.contains(arr.get(i))) {
                continue;
            } else {
                uq.add(arr.get(i));
            }
        }
        return uq;
    }
}