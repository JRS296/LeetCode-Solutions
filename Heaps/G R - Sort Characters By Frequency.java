//Attempt #1 - 20mins
//Link: https://leetcode.com/problems/sort-characters-by-frequency/description/

class Solution {
    public String frequencySort(String s) {
    Map<Character, Integer> map = new HashMap();        
    for (char c : s.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }      
    
    PriorityQueue <Character> pq = new PriorityQueue((a,b) -> map.get(b) - map.get(a));
    for (char c : map.keySet()) {
        pq.offer(c);
    }
    
    StringBuilder sb = new StringBuilder();       
    while (!pq.isEmpty()) {
        char c = pq.poll();
        for (int i = 0; i < map.get(c); i++) {
            sb.append(c);
        }
    }       
    return sb.toString();
}   
}

/*
Runtime
18 ms
Beats
54.69%
Memory
45.2 MB
Beats
6.29%

TC - O(nlogn)
SC - O(log n)
 */