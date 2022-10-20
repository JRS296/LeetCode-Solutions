//Attempt #1 - 8mins
//Link: https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1135/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> x = new HashSet<Character>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (x.contains(s.charAt(i))) {
                ans.add(length);
                length = 0;
                x.clear();
            } else {
                x.add(s.charAt(i));
                length++;
            }
        }
        ans.add(length);

        int great = -1;
        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i) > great) {
                great = ans.get(i);
            }
        }

        return great;
    }
}

/*
317 / 987 test cases passed.
 */

//Attempt #2 - 10mins

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> x = new HashSet<Character>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int length = 0;
        for(int i=0; i<s.length(); i++)
        {
            if(x.contains(s.charAt(i)))
            {
                ans.add(length);
                length = 0;
                x.clear();
                x.add(s.charAt(i));
            }
            else
            {
                x.add(s.charAt(i));
                length++;
            }
            //System.out.println(x);
            ans.add(x.size());
        }
        ans.add(length);
        ans.add(x.size());
        //System.out.println(ans);
        int great = -1;
        for(int i=0; i<ans.size(); i++)
        {
            if(ans.get(i)>great)
            {
                great = ans.get(i);
            }
        }
        
        return great;
    }
}

/*
407 / 987 test cases passed.
 */