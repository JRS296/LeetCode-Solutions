//Attempt #1 - null
//Link: https://leetcode.com/problems/basic-calculator/

//Idea -> Stack

class Solution {
    public int calculate(String s) {
        return evaluate(s);
    }

    public static int evaluate(String expression) {
        char[] tokens = expression.toCharArray();

        Stack<Integer> values = new Stack<Integer>();
        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ')
                continue;

            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuffer sbuf = new StringBuffer();

                // There may be more than one digits in number
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                values.push(Integer.parseInt(sbuf.toString()));

                i--; // Offset correction
            } else if (tokens[i] == '(') { // Current token is an opening brace, push it to 'ops'
                ops.push(tokens[i]);
            } else if (tokens[i] == ')') { // Closing brace encountered, solve entire brace
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }

            // Current token is an operator.
            else if (tokens[i] == '+' ||
                    tokens[i] == '-' ||
                    tokens[i] == '*' ||
                    tokens[i] == '/') {
                // While top of 'ops' has same
                // or greater precedence to current
                // token, which is an operator.
                // Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                // Push current token to 'ops'.
                ops.push(tokens[i]);
            }
        }

        while (!ops.empty()) // For remaining expression evaluation
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));

        return values.pop();
    }

    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(
            char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') &&
                (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    public static int applyOp(char op,
            int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }
}

/*
 * 11 / 44 testcases passed
 */

// Optimal Solution:
class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>(); // to handle parenthesis
        int n = s.length();
        int sum = 0;
        int sign = 1; // if we have to do addition of negative number
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int val = 0;
                while (i < n && Character.isDigit(s.charAt(i))) { // if digit length>1
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--; // to move i pointer to previous position
                     // or you can use new pointer then we dont have to do it
                val = val * sign;
                sign = 1;
                sum += val;
            } else if (ch == '(') { // parenthesis handle
                st.push(sum);
                st.push(sign);
                sum = 0;
                sign = 1;
            } else if (ch == ')') {
                sum *= st.pop();
                sum += st.pop();
            } else if (ch == '-') {
                sign *= -1;
            }
        }
        return sum;
    }
}

/*
Runtime
11 ms
Beats
44.71%
Memory
42.3 MB
Beats
76.59%
 */