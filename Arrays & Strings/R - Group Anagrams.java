//Attemt #1 - 15mins
//Link: https://leetcode.com/problems/group-anagrams/description/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        
        for(int i=0;i<strs.length;i++){
            String s1=strs[i];
            char[] arr=s1.toCharArray();
            Arrays.sort(arr);
            String str=new String(arr);
            
            if(map.containsKey(str)){
                map.get(str).add(s1); 
            }else{
                map.put(str,new ArrayList<>());
                map.get(str).add(s1);
            }
        }
        return new ArrayList<>(map.values());
    }
}

/*
Runtime
12 ms
Beats
33.71%
Memory
55.5 MB
Beats
5.16%
 */

//Attempt #2 

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);

            if(map.containsKey(s)) {
                List<Integer> ls = map.get(s);
                ls.add(i);

                map.put(s, ls);
            } else {
                map.put(s, new ArrayList<>(Arrays.asList(i)));
            }
        }

        for(List<Integer> list : map.values()) {
            List<String> ls = new ArrayList<>();
            for(int i = 0; i < list.size(); i++) {
                ls.add(strs[list.get(i)]);
            }
            ans.add(ls);
        }

        return ans;
    }
}

/*
Runtime
9 ms
Beats
39.63%
Memory
46.5 MB
Beats
26.96%
 */

//Failed Attempt

