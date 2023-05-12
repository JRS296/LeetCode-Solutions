//Attempt #1 - atleast 50mins
//Link: https://leetcode.com/problems/minimum-window-substring/

// class Solution {
//     public String minWindow(String s, String t) {
//         if(s.equals(t)) return s;
//         if(s.length()<t.length()) return "";

//         HashMap<Character,Integer> hmap = new HashMap<Character,Integer>();
//         for(int i=0;i<t.length();i++){
//             char c = t.charAt(i);
//             hmap.put(c, hmap.getOrDefault(c,0)+1);
//         }

//         HashMap<Integer,String> ans = new HashMap<Integer,String>();
//         ans.put(Integer.MAX_VALUE,"");

//         HashMap<Character,Integer> hmap1 = new HashMap<Character,Integer>(hmap);
//         int i=0;
//         for(int j=0; j<s.length(); j++) {
//             char ch = s.charAt(j);
//             if(hmap.containsKey(ch)) {
//                 int val = hmap.get(ch) - 1;
//                 hmap.put(ch, val);
//             }

//             ArrayList<Integer> values = new ArrayList<Integer>(hmap.values());
//             boolean allEqual = Collections.frequency(values, values.get(0)) == values.size();

            
//             System.out.println(allEqual + " " + values );

//             if(allEqual) {
//                 hmap.clear();
//                 hmap.putAll(hmap1);
//                 System.out.println(s.substring(i,j+1));
//                 while(i<=j) i++;
//             }
//         }

//         return "";
//     }
// }

/*
The frequency of a value in a list will be the same as the size of the list.

boolean allEqual = Collections.frequency(templist, list.get(0)) == templist.size()
*/

class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int count=0,start=0,min_length = Integer.MAX_VALUE, min_start = 0;
        for(int end=0; end<s.length(); end++){
            if(map.containsKey(s.charAt(end))){
                if(map.get(s.charAt(end))>0){
                    count++;
                }
                map.put(s.charAt(end), map.get(s.charAt(end))-1); 
            }
            if(count == t.length()) { 
                while(start < end && (!map.containsKey(s.charAt(start)) || map.get(s.charAt(start)) < 0)){
                    if(map.containsKey(s.charAt(start))){
                        map.put(s.charAt(start), map.get(s.charAt(start))+1);
                    }
                    start++;
                } 
                if(min_length > end-start+1){
                    min_length = end-(min_start=start)+1; 
                }
                if(map.containsKey(s.charAt(start))){
                    map.put(s.charAt(start), map.get(s.charAt(start))+1);
                }
                count--;
                start++;
            }
        }
        return min_length == Integer.MAX_VALUE ? "" : s.substring(min_start, min_start+min_length);
    }
}

//REVISE