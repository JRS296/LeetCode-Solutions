import java.util.*;

class Solution { // My solution: Memory Efficient(0.1 percentile), not space efficient (95
                 // percentile)
    public int removeDuplicates(int[] nums) {
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            a1.add(nums[i]);
        }
        ArrayList<Integer> uq = unique(a1, a1.size());
        System.out.println(uq);
        for (int i = 0; i < uq.size(); i++) {
            nums[i] = uq.get(i);
        }
        return (uq.size());
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

/*
 * Runtime: 41 ms
 * Memory Usage: 49.6 MB
 * 
 * Not as efficient
 */
class solution3 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        System.out.println(Arrays.toString(nums)); //use Arrays.deepToString()
        return i + 1;
    }
}

/*
 * Runtime: 11 ms
 * Memory Usage: 48.6 MB
 * 
 * Very Effiecient
 */