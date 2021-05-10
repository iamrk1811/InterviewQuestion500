package questions.StackAndQueue;

import java.util.Stack;

public class EvaluationOfPostfixExpression {
//    Q - https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/
    public int solve(String exp) {
        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int data1 = stack.pop();
                int data2 = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(data2 + data1);
                        break;
                    case '-':
                        stack.push(data2 - data1);
                        break;
                    case '*':
                        stack.push(data2 * data1);
                        break;
                    case '/':
                        stack.push(data2 / data1);
                        break;

                }
            }
        }
        return stack.peek();
    }
}
