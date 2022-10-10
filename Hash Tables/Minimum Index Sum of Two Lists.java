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
82 / 137 test cases passed.
 */