//Attempt #1 - 34mins
//Link: https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1177/

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int l1 = list1.length;
        int l2 = list2.length;

        HashMap<String, Integer> hmap = new HashMap<String, Integer>(l1);
        HashMap<Integer, String> h2 = new HashMap<Integer, String>();

        for (int i = 0; i < l1; i++) {
            hmap.put(list1[i], i);
        }

        int least = 99999;
        for (int i = 0; i < l2; i++) {
            String ex = list2[i];
            int x = 0;
            if (hmap.containsKey(ex)) {
                x = hmap.get(ex) + i;
                System.out.println(x + " " + ex);
                h2.put(x, ex);
                if (x < least)
                    least = x;
            }
        }

        // for(Map.Entry<Integer,String> m : h2.entrySet())
        // {
        // if(m.getKey()!=least)
        // h2.remove(m.getKey());
        // } Casuses java.util.ConcurrentModificationException

        Iterator<Map.Entry<Integer, String>> itr = h2.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<Integer, String> entry = itr.next();
            if (least != entry.getKey()) {
                System.out.println(entry.getKey());
                itr.remove();
            }
        }

        System.out.println(least);

        String[] values = h2.values().toArray(new String[0]);

        System.out.println(hmap);
        System.out.println(h2);
        return values;
    }
}

/*
 * 82 / 137 test cases passed.
 */

// Attempt #2 - 15mins
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int l1 = list1.length;
        int l2 = list2.length;

        HashMap<String, Integer> hmap = new HashMap<String, Integer>(l1);
        HashMap<String, Integer> h2 = new HashMap<String, Integer>();

        for (int i = 0; i < l1; i++) {
            hmap.put(list1[i], i);
        }

        int least = 99999;
        for (int i = 0; i < l2; i++) {
            String ex = list2[i];
            int x = 0;
            if (hmap.containsKey(ex)) {
                x = hmap.get(ex) + i;
                // System.out.println(x + " " + ex);
                h2.put(ex, x);

                if (x < least)
                    least = x;
            }
        }

        // for(Map.Entry<Integer,String> m : h2.entrySet())
        // {
        // if(m.getKey()!=least)
        // h2.remove(m.getKey());
        // } Casuses java.util.ConcurrentModificationException

        Iterator<Map.Entry<String, Integer>> itr = h2.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, Integer> entry = itr.next();
            if (least != entry.getValue()) {
                itr.remove();
            }
        }

        // System.out.println(least);

        String[] values = h2.keySet().toArray(new String[0]);

        // System.out.println(hmap);
        // System.out.println(h2);
        return values;
    }
}

/*
 * 137 / 137 test cases passed.
 * Status: Accepted
 * Runtime: 25 ms - beats 35%
 * Memory Usage: 54.4 MB - beats 52%
 * 
 * Time Complexity: O(n)
 * Space Complexity:
 */

// Given Solution:
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (!map.containsKey(i + j))
                        map.put(i + j, new ArrayList<String>());
                    map.get(i + j).add(list1[i]);
                }
            }
        }
        int min_index_sum = Integer.MAX_VALUE;
        for (int key : map.keySet())
            min_index_sum = Math.min(min_index_sum, key);
        String[] res = new String[map.get(min_index_sum).size()];
        return map.get(min_index_sum).toArray(res);
    }
}

/*
 * 137 / 137 test cases passed.
 * Status: Accepted
 * Runtime: 253 ms - beats 7%
 * Memory Usage: 54.5 MB - beats 52%
 * 
 * Time Complexity: O(l1*l2*x)
 * Space Complexity: O(l1*l2*x)
 */

// Given Solution #2 - Linear with HashMap
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < list1.length; i++)
            map.put(list1[i], i);
        List<String> res = new ArrayList<>();
        int min_sum = Integer.MAX_VALUE, sum;
        for (int j = 0; j < list2.length && j <= min_sum; j++) {
            if (map.containsKey(list2[j])) {
                sum = j + map.get(list2[j]);
                if (sum < min_sum) {
                    res.clear();
                    res.add(list2[j]);
                    min_sum = sum;
                } else if (sum == min_sum)
                    res.add(list2[j]);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}

/*
 * 137 / 137 test cases passed.
 * Status: Accepted
 * Runtime: 12 ms - 84%
 * Memory Usage: 54.6 MB - 34%
 * 
 * Time Complexity: O(l1+l2)
 * Space Complexity: O(l1*x)
 */