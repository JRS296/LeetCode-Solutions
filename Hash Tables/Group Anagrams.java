//Attempt #1 - 1 hour
//Link: https://leetcode.com/explore/learn/card/hash-table/185/hash_table_design_the_key/1124/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lt = new ArrayList<List<String>>();
        for(int i=0; i<strs.length; i++)
        {
            if(hmap.contains)
        }
        boolean x = Anagram("Hello", "lloae");
        System.out.println(x);
        return lt;
    }
    
    public boolean Anagram(String s, String t)
    {
        if(s.length()!=t.length())
        {
            return false;
        }
        
        HashMap<Character,Integer> hmap = new HashMap<Character,Integer>();
        for(int i=0; i<s.length(); i++)
        {
            char ch = Character.toLowerCase(s.charAt(i));
            
            if(hmap.containsKey(ch))
            {
                int temp = hmap.get(ch);
                temp++;
                hmap.put(ch,temp);
                continue;
            }
            hmap.put(ch,1);
        }
        System.out.println(hmap);
        
        int x = 0;
        for(int i=0; i<t.length(); i++)
        {
            char ch = Character.toLowerCase(t.charAt(i));
            
            if(hmap.containsKey(ch))
            {
                x++;
            }
        }
        
        if(x==s.length())
        {
            return true;
        }
        
        return false;
    }
}

/*Overcomplicated Solution due to Late Night Thinking */


//Attempt #2 - Optimal Solution:
//All cases of keys - will always be the same once sorted. Therefore instead of checking for
//anagram case each time, just check for key condition that always satisfies for all o/ps
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

117 / 117 test cases passed.
Status: Accepted
Runtime: 12 ms - beats 80%
Memory Usage: 55.5 MB - beats 71%

Time Complexity: O(n)
Space COmplexity: O(n)
 */