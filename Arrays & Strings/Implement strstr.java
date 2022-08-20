class Solution {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length();
        int l2 = needle.length();
        if(l2>l1)
        {
            return -1;
        }
        if(l2==0)
        {
            return 0;
        }
        int ans = 0;
        for(int i=0; i<l1+1-l2; i++)
        {
            //System.out.println(haystack.substring(i,i+l2));
            if(haystack.substring(i,i+l2).equals(needle))
            {
                //System.out.println("Heya");
                ans = i;
                break;
            }
            else
            {
                ans = -1;
            }
        }
        
        return ans;
    }
}

/*
Runtime: 0 ms
Memory Usage: 41.6 MB
Completed in: 16 mins (bit poor)
Very Good solution, beats purpose as inbuilt functions are used
 */

 //Solution: Simple Version'
 class Solution2 {
 public int strStr(String haystack, String needle) {
    for (int i = 0; ; i++) {
      for (int j = 0; ; j++) {
        if (j == needle.length()) return i;
        if (i + j == haystack.length()) return -1;
        if (needle.charAt(j) != haystack.charAt(i + j)) break;
      }
    }
  }
}

  //Another way of doing this: KMP Algorithm for pattern matching