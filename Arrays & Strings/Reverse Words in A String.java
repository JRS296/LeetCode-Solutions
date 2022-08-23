import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Attempt #1 - rougly 25mins
class Solution {
    public String reverseWords(String s) {
        ArrayList<String> sans = new ArrayList<String>(); //to store tokenized words
        StringBuilder sb = new StringBuilder();
        s.trim();
        int j = 0;
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)==' ')
            {
                sans.add(s.substring(j,i));
                j=i;
            }
            else if(i==s.length()-1)
            {
                sans.add(s.substring(j,i+1));
                j=i;
                break;
            }
        }
        sans.removeAll(Collections.singleton(" "));
        for(int i=sans.size()-1; i>-1;  i--)
        {
            sb.append((sans.get(i)).trim() + " ");
        }
        String ans = sb.toString();
        //System.out.println(sans);
        return ans.trim();
    }
}
/*

58 / 58 test cases passed.
Status: Accepted
Runtime: 15 ms (beats 45%)
Memory Usage: 45.3 MB (beats 35%)

Overall not bad, solid.

Time Complexity: O(n^2)?? because add is O(n) is capacity is unknown
 */

 //Solution: Clean Java w/ functions
 class Solution2 {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    } 
}
/*
58 / 58 test cases passed.
Status: Accepted
Runtime: 10 ms
Memory Usage: 43.6 MB
 */