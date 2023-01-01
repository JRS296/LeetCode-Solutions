//01.01.23 - Word Pattern
//Link: https://leetcode.com/problems/word-pattern/

//Attempt #1 - 27mins
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String arr[] = pattern.split("");
        String ar2[] = s.split(" ");
        boolean finAns = true;
        if(arr.length != ar2.length)
        {
            return false;
        }
        HashMap<String,String> ans = new HashMap<String,String>();
        HashSet<String> checklist = new HashSet<String>();
        for(int i=0; i<arr.length; i++)
        {
            if(!ans.containsKey(arr[i]))
            {
                ans.put(arr[i], ar2[i]);
                // if(checklist.add(ar2[i]))
                // {
                //     finAns = false;
                //     break;
                // }
            }
            else if(ans.containsKey(arr[i]))
            {
                System.out.println(ans.get(arr[i]));
                System.out.println(ar2[i]);
                if(!ans.get(arr[i]).equals(ar2[i]))
                {
                    finAns = false;
                    break;
                    //System.out.println("Trigger" + ar2[i]);
                }
            }
        }

        //System.out.println(ans);
        return finAns;
    }
}

/*
34/37 cases passed
Time Complexity: O(n)
Space Complexity: O(n)
 */

//Attempt #2 - Optimal Solution following same approach
class Solution2 {
    public boolean wordPattern(String pattern, String s) {
        String [] arr = s.split(" ");
        if(pattern.length()!=arr.length)return false;
        HashMap<Character,String> map = new HashMap<>(); 
        for(int i = 0; i<pattern.length(); i++){
            char ch = pattern.charAt(i);
            boolean containsKey = map.containsKey(ch);
            if(map.containsValue(arr[i]) && !containsKey)return false;
            if(containsKey && !map.get(ch).equals(arr[i]))return false;
            else map.put(ch,arr[i]);
        }
        return true;
    }
}

/*
Runtime
1 ms
Beats
95.36%
Memory
40 MB
Beats
95.5%
 */