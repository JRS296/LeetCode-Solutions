//Attempt #1 - 40mins
//Link: https://leetcode.com/problems/greatest-common-divisor-of-strings/description/

class Solution {
    public static String gcdOfStrings(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();

        ArrayList<String> testCases = new ArrayList<String>();
        if(l2<=l1)
        {
            for(int i=0; i<l2; i++) //Case A, AB, ABA, ABAB
            {
                String test = str2.substring(0,i+1);
                testCases.add(test);
            }
        }
        else
        {
            for(int i=0; i<l1; i++) //Case A, AB, ABA, ABAB
            {
                String test = str1.substring(0,i+1);
                testCases.add(test);
            }
        }

        for(String x:testCases)
        {
            int l = x.length();
            int c = 0, b = 0;
           for(int i=0; i<l1; i+=l) //Case A, AB, ABA, ABAB
            {
                if(i+l>l1)
                    continue;
                //System.out.println(str1.substring(i, i+l) + " " + x);
                b++;
                if((str1.substring(i, i+l)).equals(x))
                {
                    c++;
                }
            } 
            if(b==c)
            {
                return x;
            }
            else
                continue;
            //System.out.println(c + " " + b);
        }

        return "";
    }
}

/*
66 / 114 testcases passed
 */

//Optimal Solution - Insane Approach
//Link: https://leetcode.com/problems/greatest-common-divisor-of-strings/solutions/3124997/super-easy-solution-fully-explained-c-python3-java/

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // Check if concatenated strings are equal or not, if not return ""
        if (!(str1 + str2).equals(str2 + str1))
            return "";
        // If strings are equal than return the substring from 0 to gcd of size(str1), size(str2)
        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

/*
Runtime
1 ms
Beats
85.83%
Memory
41.7 MB
Beats
84.84%

Time complexity: O(1)
Space complexity: O(1)
 */