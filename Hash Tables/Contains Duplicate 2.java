//Attempt #1 - 15mins
//Link:

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) 
        {
            if (hmap.containsValue(nums[i])) {
                int y = -1;
                for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) 
                {
                    if (entry.getValue() == nums[i]) {
                        y = entry.getKey();
                    }
                    int x = i;
                    
                    //System.out.println(x + " " + y);

                    if (Math.abs(x-y) <= k) {
                        return true;
                    } else {
                        continue;
                    }
                }
                
            }
            hmap.put(i, nums[i]); 
        }
        return false;
    }
}

/*
20 / 52 test cases passed.

Time Limit Exceeded: O(n^2)
 */