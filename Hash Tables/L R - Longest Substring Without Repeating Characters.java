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

//Answer:
//Link: https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1135/discuss/2133524/JavaC++-A-reall-Detailed-Explanation

//VERY VERY IMPORTANT: How to Solve Sliding Window Problems

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while(j < s.length()){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if(map.size() == j - i + 1){
                max = Math.max(max, j - i + 1);
                j++;
            }
            else if(map.size() < j - i + 1){
                while(map.size() < j - i + 1){
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if(map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
                    i++;
                }
                j++;
            }
        }
        return max;
    }
}

/*
987 / 987 test cases passed.
Status: Accepted
Runtime: 23 ms
Memory Usage: 44.7 MB

TC - O(n)
SC - O(n)
 */