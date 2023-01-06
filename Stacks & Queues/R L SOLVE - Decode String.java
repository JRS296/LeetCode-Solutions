//Attempt #1 - 45mins+
//Link:
// Have good idea, just no time to solve

// class Solution {
//     public String decodeString(String s) {
//         Stack<String> stk = new Stack<String>();
//         String sans = "";
//         for(int i=0; i<s.length(); i++)
//         {
//             if(s.charAt(i)==']')
//             {
//                 System.out.println(stk.peek());
//                 String s2 = "";
//                 while(stk.peek()!="[")
//                 {
//                     s2+=stk.pop();
//                 }
//                 stk.pop();
//                 StringBuilder input1 = new StringBuilder();
//                 input1.append(s2);
//                 input1.reverse();
//                 System.out.println(input1);
                
//                 int x = Integer.parseInt(stk.pop());
//                 for(int j=0; j<x; j++)
//                 {
//                     stk.push(input1.toString());
//                 }
                
//             }
//             else
//             {
//                 String x = "";
//                 x += s.charAt(i);
//                 stk.push(x);
//             }
//             //System.out.println(stk);
//         }
        
//         return sans;
//     }
// }
public class Solution {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();
        int i = 0;
        result.push("");
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int start = i;
                while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
                count.push(Integer.parseInt(s.substring(start, i + 1)));
            } else if (ch == '[') {
                result.push("");
            } else if (ch == ']') {
                String str = result.pop();
                StringBuilder sb = new StringBuilder();
                int times = count.pop();
                for (int j = 0; j < times; j += 1) {
                    sb.append(str);
                }
                result.push(result.pop() + sb.toString());
            } else {
                result.push(result.pop() + ch);
            }
            i += 1;
        }
        return result.pop();
    }
}

/*
Runtime
11 ms
Beats
6.58%
Memory
42.3 MB
Beats
28.41%
 */

 