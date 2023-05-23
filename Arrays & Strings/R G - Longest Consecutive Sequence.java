//Attempt #1 - 32mins
//Link: https://leetcode.com/problems/longest-consecutive-sequence/description/

class Solution { //32mins - 69/73
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hset = new HashSet<Integer>();
        for(int x: nums) {
            hset.add(x);
        }

        HashMap<Integer, HashSet<Integer>> hmap = new HashMap<Integer, HashSet<Integer>>();
        for(int x: nums) {
            if(!hset.contains(x-1)) {
                hmap.put(x, new HashSet<Integer>());
            }
        }

        for(int x: nums) {
            if(hset.contains(x-1)) {
                int val = x;
                while(hset.contains(val)) {
                    val--;
                }
                val+=1;
                HashSet<Integer> temp = hmap.get(val);
                temp.add(x);
                hmap.put(val,temp);
            }
        }

        int res = 0;
        //System.out.println(hmap);

        for (Map.Entry<Integer,HashSet<Integer>> entry : hmap.entrySet()) 
            res = Math.max(res, entry.getValue().size());

        return nums.length==0 ? 0 : res+1;
    }

    //Trick 1 - Check if arr[i] - 1 exists in HashSet, if not - start of sequence
}

//TLE, 69/73 TC's passed

//Optimal Solution:

class Solution {
    public int longestConsecutive(int[] nums) {
        // if array is empty, return 0
        if (nums.length == 0) 
        {
            return 0;
        }
        Set<Integer> set = new HashSet<Integer>();
        int max = 1;
        for (int e : nums)
            set.add(e);
        for (int e : nums) 
        {
            int left = e - 1;
            int right = e + 1;
            int count = 1;
            while (set.contains(left)) 
            {
                count++;
                set.remove(left);
                left--;
            }
            while (set.contains(right)) 
            {
                count++;
                set.remove(right);
                right++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}

/*
Runtime
41 ms
Beats
53.8%
Memory
59.4 MB
Beats
42.59%
 */