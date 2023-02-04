//Attempt #1 - 4mins
//Link: https://leetcode.com/problems/permutation-in-string/description/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //Use an ArrayList for S1
        //2 ptrs, make another arraylist for tracking each corresponding true/false value (i.e. 1:1 relationship between keys & values to support duplication, which hashmap cannot)
        ArrayList<Character> a1 = new ArrayList<Character>();
        ArrayList<Boolean> a2 = new ArrayList<Boolean>();
        for(int i=0; i<s1.length(); i++)
        {
            a1.add(s1.charAt(i));
            a2.add(false);
        }
        System.out.println(a1);
        int min = 9999;
        int max = -1;

        for(int j=0; j<s2.length(); j++)
        {
            if(a1.contains(s2.charAt(j)))
            {
                System.out.println(j);
                min = Math.min(min,j);
                max = Math.max(max,j);
            }
        }
        System.out.println(max-min);

        if(max-min==a1.size()-1)
            return true;
        else
            return false;
    }
}

/*
63/107
Cheese technique, probably wouldnt have worked anyway
 */

//Attempt #2 - 15mins
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //Get permutations -> Crosscheck each substring
        ArrayList<String> a1 = new ArrayList<String>();
        int len = s1.length();
        generatePermutation(s1, 0, len, a1);  
        boolean ans = false;
        for(int i=0; i<=s2.length()-len; i++)
        {
            String temp = s2.substring(i,i+len);
            //System.out.println(temp);
            if(a1.contains(temp))
            {
                ans = true;
            }
        }
         return ans;
    }

    //Eg: 123 -> 123, 231, 321...
    public static void generatePermutation(String str, int start, int end, List<String> ans) {
        if (start == end - 1)
        {
            ans.add(str);
        }
            
        else {
            for (int i = start; i < end; i++) {
                str = swapString(str, start, i); 
                generatePermutation(str, start + 1, end, ans); 
                str = swapString(str, start, i);
            }
        }
    }
    
    private static String swapString(String stri, int i, int j) {
        char[] str = stri.toCharArray();
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
        return String.valueOf(str);
    }
}

/*
Works, but TLE
 */

//Answer #1 - Brute Force (count of Characters)
//Link: https://leetcode.com/problems/permutation-in-string/solutions/3138510/easy-solution-c-java-python-beginner-friendly-brute-to-best-method/
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] cnt = new int[26];
        for(char x: s1.toCharArray()){
            cnt[x - 'a']++;
        }

        int n1 = s1.length(), n2 = s2.length();

        for(int i = 0; i < n2 - n1 + 1; i++){
            int[] cnt2 = new int[26];
            for(int j = i; j < i + n1; j++){
                cnt2[s2.charAt(j) - 'a']++;
            }
            if(Arrays.equals(cnt, cnt2)) return true;
        }
        return false;
    }
}
/*
Runtime
135 ms
Beats
24.39%
Memory
42.7 MB
Beats
41.61%
 */

//Answer #2 - Optimized - Sliding Window Character Count
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2){
            return false;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (char ch : s1.toCharArray()){
            arr1[ch - 'a']++;
        }
        for (int i = 0; i < n2; i++)
        {
            arr2[s2.charAt(i) - 'a']++;
            if (i >= n1){
                arr2[s2.charAt(i - n1) - 'a']--;
            }
            if (Arrays.equals(arr1, arr2))
                return true;
        }
        return false;
    }
}

/*
Runtime
3 ms
Beats
99.34%
Memory
42 MB
Beats
92.17%
 */
