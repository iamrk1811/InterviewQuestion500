package questions.array;

import java.util.Stack;

public class FormMinimumNumberFromGivenSequence {
//    Q - https://www.geeksforgeeks.org/form-minimum-number-from-given-sequence/
    public String solve(String str) {
        StringBuilder tempRes = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int val = 1;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'D') {
                stack.push(val);
                val++;

            } else if (ch =='I') {
                stack.push(val);
                val++;

                while (!stack.isEmpty()) {
                    tempRes.append(stack.pop());
                }
            }
        }
        stack.push(val);
        while (!stack.isEmpty()) {
            tempRes.append(stack.pop());
        }
        return tempRes.toString();
    }
}
