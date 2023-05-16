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

//Attempt #2 - 45mins

class Solution {
    public String minWindow(String s, String t) {
        if(s.equals(t)) return s;
        if(s.length()<t.length()) return "";
        if(s.length()==1 && t.length()==1 && !s.equals(t)) return "";

        //Min length & ptr value
        int minLen = Integer.MAX_VALUE;
        int posi = -1;
        int posj = -1;

        //ptr to handle next jump
        int k = -1;
        int jmpFlag = 0;

        //ptr to handle window
        int j=0;
        int i=j; 

        HashMap<Character,Integer> tmap = new HashMap<Character,Integer>();
        for(int a=0;a<t.length();a++){
            char c = t.charAt(a);
            tmap.put(c, tmap.getOrDefault(c,0)+1);
        }

        //Begin looping through string s
        HashMap<Character,Integer> hmap = new HashMap<Character,Integer>(tmap);
        for(j=0; j<s.length(); j++) {
            if(j==-1) break;
            char ch = s.charAt(j);
            if(hmap.containsKey(ch)) {
                jmpFlag++;
                if(hmap.get(ch)>0) {
                    int val = hmap.get(ch) - 1;
                    hmap.put(ch, val);
                }
                if(jmpFlag==2) k=j;
            }

            ArrayList<Integer> values = new ArrayList<Integer>(hmap.values());
            boolean allEqual = Collections.frequency(values, values.get(0)) == values.size();

            
            

            if(allEqual) {
                System.out.println(s.substring(i,j+1));
                if(j+1-i<minLen) {
                    minLen = j+1-i;
                    posi = i;
                    posj = j+1;
                }
                //System.out.println(minLen);
                hmap.clear();
                hmap.putAll(tmap);
                
                
                j = k-1;
                i = j+1;
                jmpFlag = 0;
            }

            
        }
       
        return minLen == Integer.MAX_VALUE ? "" : s.substring(posi,posj);
    }
}

/*
17/256 TC passed - annoying border cases
 */

//Optimal #2 

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

/*
Time complexity: O(N), where N is the length of the string s. We traverse the string s once.
Space complexity: O(M), where M is the length of the string t. We create a frequency map of characters in t.
 */