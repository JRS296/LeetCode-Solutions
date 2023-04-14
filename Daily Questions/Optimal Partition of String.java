//Attempt #1 - 20mins
//Link: https://leetcode.com/problems/optimal-partition-of-string/description/

//Idea - Greedy Approach

class Solution {
    public int partitionString(String s) {
        ArrayList<Character> ans = new ArrayList<Character>();
        int finAns = 0;
        for(int i=0; i<s.length(); i++) {
            if(ans.contains(s.charAt(i))) {
                finAns++;
                ans.clear();
            }
            ans.add(s.charAt(i));
            //System.out.println(ans);
        }
        //System.out.println(finAns);
        return finAns+1;
    }
}

/*
Runtime
39 ms
Beats
36.39%
Memory
43 MB
Beats
67.78%

TC - O(n)
SC - O(n)
 */