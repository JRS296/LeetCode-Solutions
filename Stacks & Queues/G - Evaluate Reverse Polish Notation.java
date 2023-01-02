//Attempt #1 - 24mins
//Link: https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1394/

class Solution {
    public int evalRPN(String[] tokens) {
        int ans = 0;
        String regex1 = "{[0-9]{1,3}:[0-9]{1,3}}";
        Stack<String> stk = new Stack<String>();
        for(int i=0; i<tokens.length; i++)
        {
            if(isNumeric(tokens[i]))
            {
                stk.push(tokens[i]);
                //System.out.println("Number" + tokens[i]);
            }
            else
            {
                //System.out.println("Character" + tokens[i]);
                int y = Integer.parseInt(stk.pop());
                int x = Integer.parseInt(stk.pop());
                if(tokens[i].equals("+"))
                {
                    stk.push(String.valueOf(x+y));
                }
                else if(tokens[i].equals("-"))
                {
                    stk.push(String.valueOf(x-y));
                }
                else if(tokens[i].equals("/"))
                {
                    stk.push(String.valueOf(x/y));
                }
                else if(tokens[i].equals("*"))
                {
                    stk.push(String.valueOf(x*y));
                }
            }
            //System.out.println(stk);
        }
        
        ans = Integer.parseInt(stk.pop());
        return ans;
    }
    
    public static boolean isNumeric(String string) {
    int intValue;
    if(string == null || string.equals("")) {
        return false;
    }
    
    try {
        intValue = Integer.parseInt(string);
        return true;
    } catch (NumberFormatException e) {
    }
    return false;
}
}

/*
Runtime
24 ms
Beats
10.2%
Memory
43.7 MB
Beats
38.90%

Time Complexity: O(n)
Space Complexity: O(n)

Low Performance due to String functions
 */

//Optimized Solution - using minimal String functions
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack();
        String oprtr="+-*/";
        for(String s:tokens)
        {
            if(oprtr.contains(s)&&!stack.isEmpty()){
              int op1=stack.pop();
              int op2=stack.pop();
              int ans=help(op2,s,op1);
              stack.push(ans);
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();

    }
    public int help(int op2,String s,int op1)
    {
        if(s.equals("+"))return op2+op1;
        else if(s.equals("-"))return op2-op1;
        else if(s.equals("/"))return op2/op1;
        return op2*op1;
    }
}

/*
Runtime
5 ms
Beats
94.78%
Memory
42 MB
Beats
73.66%

**Highly Optimized**
Time Complexity: O(n)
Space Complexity: O(n)
 */