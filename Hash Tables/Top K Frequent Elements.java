//Attempt #1 - 20mins
//Link: https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1133/

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for (int x : nums) {
            if (hmap.containsKey(x)) {
                int n = hmap.get(x) + 1;
                hmap.put(x, n);
            } else {
                hmap.put(x, 1);
            }
        }
        // System.out.println(hmap);

        int n1 = -1, n2 = -1;

        Collection<Integer> values = hmap.values();
        ArrayList<Integer> listOfValues = new ArrayList<>(values);
        for (int x : listOfValues) {
            n1 = Math.max(n1, x);
        }

        listOfValues.remove(Integer.valueOf(n1));
        for (int x : listOfValues) {
            n2 = Math.max(n2, x);
        }
        // System.out.println(n1+" " + n2);

        Iterator<Map.Entry<Integer, Integer>> itr = hmap.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<Integer, Integer> entry = itr.next();
            if (entry.getValue() == n1 || entry.getValue() == n2) {
                ans.add(entry.getKey());
            }
        }

        int a[] = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            a[i] = ans.get(i);
        }
        // System.out.println(ans);
        return a;
    }
}

/*
 * 14/21 Test Cases Passed
 * Does not take k into account, just 2 which is wrong.
 */

// Attempt #2 - 13mins

class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        HashSet<Integer> ans = new HashSet<Integer>();
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for (int x : nums) {
            if (hmap.containsKey(x)) {
                int n = hmap.get(x) + 1;
                hmap.put(x, n);
            } else {
                hmap.put(x, 1);
            }
        }
        // System.out.println(hmap);

        ArrayList<Integer> list = new ArrayList<Integer>(Collections.nCopies(k, 0));

        Collection<Integer> values = hmap.values();
        ArrayList<Integer> listOfValues = new ArrayList<>(values);

        for (int i = 0; i < k; i++) {
            for (int x : listOfValues) {
                list.set(i, Math.max(list.get(i), x));
            }
            listOfValues.remove(Integer.valueOf(list.get(i)));
        }
        // System.out.println(list);

        for (int i = 0; i < k; i++) {
            Iterator<Map.Entry<Integer, Integer>> itr = hmap.entrySet().iterator();
            while (itr.hasNext()) {
                Map.Entry<Integer, Integer> entry = itr.next();
                // System.out.println(entry.getValue() + " " + list.get(i));
                if (entry.getValue() == list.get(i)) {
                    ans.add(entry.getKey());
                    continue;
                }
            }
        }

        int a[] = new int[ans.size()];
        int i = 0;
        for (int x : ans) {
            a[i] = x;
            i++;
        }
        // System.out.println(ans);
        return a;
    }
}

/*
 * 21 / 21 test cases passed.
 * Status: Accepted
 * Runtime: 210 ms - Very bad
 * Memory Usage: 51.5 MB - bad
 * 
 * Time Complexity: O(n^2)
 * Space Complexity:
 */

// Optimal Solutions: #1 - Using Quickselect (not quicksort) - also known as
// HOARSE'S SELECTION ALGO to Arrange Cases to get K set of elements:
// Link: https://leetcode.com/problems/top-k-frequent-elements/solution/

class Solution3 {
    int[] unique;
    Map<Integer, Integer> count;

    public void swap(int a, int b) {
        int tmp = unique[a];
        unique[a] = unique[b];
        unique[b] = tmp;
    }

    public int partition(int left, int right, int pivot_index) {
        int pivot_frequency = count.get(unique[pivot_index]);
        // 1. move pivot to end
        swap(pivot_index, right);
        int store_index = left;

        // 2. move all less frequent elements to the left
        for (int i = left; i <= right; i++) {
            if (count.get(unique[i]) < pivot_frequency) {
                swap(store_index, i);
                store_index++;
            }
        }

        // 3. move pivot to its final place
        swap(store_index, right);

        return store_index;
    }

    public void quickselect(int left, int right, int k_smallest) {
        /*
         * Sort a list within left..right till kth less frequent element
         * takes its place.
         */

        // base case: the list contains only one element
        if (left == right)
            return;

        // select a random pivot_index
        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);

        // find the pivot position in a sorted list
        pivot_index = partition(left, right, pivot_index);

        // if the pivot is in its final sorted position
        if (k_smallest == pivot_index) {
            return;
        } else if (k_smallest < pivot_index) {
            // go left
            quickselect(left, pivot_index - 1, k_smallest);
        } else {
            // go right
            quickselect(pivot_index + 1, right, k_smallest);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        // build hash map : character and how often it appears
        count = new HashMap();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // array of unique elements
        int n = count.size();
        unique = new int[n];
        int i = 0;
        for (int num : count.keySet()) {
            unique[i] = num;
            i++;
        }

        // kth top frequent element is (n - k)th less frequent.
        // Do a partial sort: from less frequent to the most frequent, till
        // (n - k)th less frequent element takes its place (n - k) in a sorted array.
        // All element on the left are less frequent.
        // All the elements on the right are more frequent.
        quickselect(0, n - 1, n - k);
        // Return top k frequent elements
        return Arrays.copyOfRange(unique, n - k, n);
    }
}

/*
 * 21 / 21 test cases passed.
 * Status: Accepted
 * Runtime: 9 ms - top 97%
 * Memory Usage: 44.8 MB - top 91%
 * 
 * Time Complexity: O(NlogN)
 * Space Complexity: O(n+k)
 */

//Another Attempt 

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Count the frequency of each element
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        
        // Sort the list based on the frequency in descending order
        entryList.sort((a, b) -> b.getValue() - a.getValue());
        
        // Retrieve the top k elements
        for (int i = 0; i < k; i++) {
            ans[i] = entryList.get(i).getKey();
        }
        
        return ans;
    }
}

/*
Runtime
15 ms
Beats
49.2%
Memory
45.5 MB
Beats
38.49%
 */