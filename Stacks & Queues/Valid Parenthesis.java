//Attempt #1 - 20mins
//Link: https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1361

class Solution{
    public boolean isValid(String s) {
	Stack<Character> stack = new Stack<Character>();
	for (char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();
}
}

// class Solution {
//     public boolean isValid(String s) {
//         Stack<Character> stk = new Stack<Character>();
//         if(s.charAt(0)==')' || s.charAt(0)=='}' || s.charAt(0)==']')
//         {
//             return false;
//         }
//         for(int i=0; i<s.length(); i++)
//         {
//             System.out.println(s.charAt(i));
//             if(s.charAt(i)=='(')
//             {
//                 stk.push(')');
//             }
//             else if(s.charAt(i)=='{')
//             {
//                 stk.push('}');
//             }
//             else if(s.charAt(i)=='[')
//             {
//                 stk.push(']');
//             }
//             else
//             {
//                 if(stk.pop()!=s.charAt(i) || stk.isEmpty())
//                 {
//                     return false;
//                 }
//             }
//             System.out.println(stk);
//         }
//         return stk.isEmpty();
//     }
// }

/*
Runtime
4 ms
Beats
56.81%
Memory
42.4 MB
Beats
21.16%
 */