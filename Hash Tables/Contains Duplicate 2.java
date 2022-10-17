//Attempt #1 - 15mins
//Link:

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hmap.containsValue(nums[i])) {
                int y = -1;
                for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
                    if (entry.getValue() == nums[i]) {
                        y = entry.getKey();
                    }
                    int x = i;

                    // System.out.println(x + " " + y);

                    if (Math.abs(x - y) <= k) {
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
 * 20 / 52 test cases passed.
 * 
 * Time Limit Exceeded: O(n^2)
 */

// Attempt #2 - 40mins
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, ArrayList<Integer>> hmap = new HashMap<Integer, ArrayList<Integer>>();
        int x = 99999;
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> y = new ArrayList<Integer>();
            hmap.put(nums[i], y);
        }

        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> y = hmap.get(nums[i]);
            y.add(i);
            y.sort(Comparator.naturalOrder());
            hmap.put(nums[i], y);
        }

        for (int i = 0; i < nums.length; i++) {
            if (hmap.get(nums[i]).size() == 2) {
                int num = hmap.get(nums[i]).get(0) + hmap.get(nums[i]).get(1);
                if (num < x) {
                    x = num;
                }
            }
        }
        if (x <= k) {
            return true;
        } else {
            return false;
        }
    }
}

/*
 * 35 / 52 test cases passed.
 * 1ms
 */

// Attempt #3 - 10mins
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2)
            return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k)
                    return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}

/*
52 / 52 test cases passed.
Status: Accepted
Runtime: 53 ms - O(n)
Memory Usage: 93.5 MB - O(n)
 */