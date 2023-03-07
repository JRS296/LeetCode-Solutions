//Attempt #1 - 40mins
//Link: https://leetcode.com/problems/basic-calculator-ii/description/

class Solution {
    public int calculate(String s) {
        Stack<Character> stk = new Stack<Character>();
        int flag = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                if (flag == 1) {
                    int val2 = ch - '0';
                    char operand = stk.pop();
                    int val1 = stk.pop() - '0';
                    // System.out.println(val1+" "+operand+" "+val2);
                    int x = helper(operand, val1, val2);
                    ch = (char) (x + '0');
                    flag = 0;
                }
                stk.push(ch);
            } else if (ch == '+' || ch == '-')
                stk.push(ch);
            else if (ch == '/' || ch == '*') {
                flag = 1;
                stk.push(ch);
            }

        }

        if (stk.size() == 1)
            return stk.pop() - '0';

        while (stk.size() > 1) {

            int val2 = stk.pop() - '0';
            char operand = stk.pop();
            int val1 = stk.pop() - '0';

            int x = helper(operand, val1, val2);
            char ch = (char) (x + '0');
            stk.push(ch);
        }

        // System.out.println(stk);

        return stk.pop() - '0';
    }

    public int helper(char operand, int val1, int val2) {
        if (operand == '+')
            return (val1 + val2);
        else if (operand == '-')
            return (val1 - val2);
        else if (operand == '*')
            return (val1 * val2);
        else if (operand == '/')
            return (val1 / val2);
        return 0;
    }
}

/*
 * 5 / 110 testcases passed
 */

// Optimal Solution - addition of if case to add extra digits to number
class Solution2 {
    public int calculate(String s) {

        if (s == null || s.isEmpty())
            return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) { // To handle multiple digit numbers
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-currentNumber); //Smart
                } else if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) { //Because -ve number added to stk
            result += stack.pop();
        }
        return result;
    }
}

/*
 * Runtime
 * 39 ms
 * Beats
 * 39.24%
 * Memory
 * 42.9 MB
 * Beats
 * 95.88%
 */