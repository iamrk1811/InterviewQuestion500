package questions.StackAndQueue;

import java.util.Stack;

public class InfixToPostfix {
//    Q - https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
    public String solve(String exp) {
        Stack<Character> stack = new Stack<>();

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (isCharacter(ch))
                res.append(ch);
            else {
                if (ch == '(') {
                    stack.push(ch);

                } else if (ch == ')') {

                    while (!stack.isEmpty() && stack.peek() != '(') {
                        res.append(stack.pop());
                    }

                    if(!stack.isEmpty())
                        stack.pop();

                } else {
                    while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                        res.append(stack.pop());
                    }
                    stack.push(ch);
                }
            }
        }
        while(!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.toString();
    }
    private int precedence(char ch) {
        if (ch == '^') return 3;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '+' || ch == '-') return 1;
        return -1;
    }
    private boolean isCharacter(char ch) {
        if (ch >= 65 && ch < 65 + 26) return true;
        if (ch >= 97 && ch < 97 + 26) return true;
        return false;
    }
}

