//Attempt #1 - 35 mins - 16/294 test cases passed

class Solution {
    public String addBinary(String a, String b) {
        String ans = "";
        String big = "", small = "";
        int bi, sm;
        int x = length(a);
        int y = length(b);
        if(x > y)
        {
            bi = x; sm = y;
            big = a;
            small = b;
        }
        else
        {
            bi = y; sm = x;
            big = b;
            small = a;
        }
        //System.out.println(bi+" "+sm+" "+big+" "+small);
        int temp = 0;;
        for(int i=0; i<bi; i++)
        {
            
            int y1 = big.charAt(i)-48;
            if(i<sm)
            {
                int x1 = small.charAt(i)-48;
                if(x1+y1+temp==0)
                {
                    ans+="0";
                    temp = 0;
                }
                else if(x1+y1+temp==1)
                {
                    ans+="1";
                    temp = 0;
                }
                else if(x1+y1+temp>1)
                {
                    ans+="0";
                    temp = 1;
                }
            }
            else
            {
               if(y1+temp==0)
                {
                    ans+="0";
                    temp = 0;
                }
                else if(y1+temp==1)
                {
                    ans+="1";
                    temp = 0;
                }
                else if(y1+temp>1)
                {
                    ans+="0";
                    temp = 1;
                } 
            }
        }
        if(temp==1)
        {
            ans+="1";
        }
        
        
        return reverse(ans);
    }
    
    public int length(String s)
    {
        int ans = 0;
        for(char x : s.toCharArray())
        {
            ans++;
        }
        return ans;
    }
    public static String reverse(String str) 
    { 
        if(str == null || str.isEmpty()){ return str; } 
        char[] characters = str.toCharArray(); 
        int i = 0; int j = characters.length - 1; 
        while (i < j) { swap(characters, i, j); i++; j--; } 
        return new String(characters); 
    }
    private static void swap(char[] str, int i, int j) { char temp = str[i]; str[i] = str[j]; str[j] = temp; }

}

/*
 * Pretty bad, like really BAD. Took too much time, logic not sound, too many functions.
 */

 //Solution: UNderstamd how Binary Addition works
class Solution2 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}

/*
Takeaway - Learn String Builder - reattempt
 */