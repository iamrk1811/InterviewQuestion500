package questions.StackAndQueue;

import java.util.Stack;

public class StackPermutations {
//    Q - https://www.geeksforgeeks.org/stack-permutations-check-if-an-array-is-stack-permutation-of-other/
//    Q - https://leetcode.com/problems/validate-stack-sequences/
    public boolean solve(int[] pushArray, int[] popArray) {
        if (pushArray.length == 0 || popArray.length == 0) return true;
        Stack<Integer> stack = new Stack<>();

        int i = 1, j = 0;

        stack.push(pushArray[0]);

        while (j < popArray.length) {
            if (!stack.isEmpty() && stack.peek() == popArray[j]) {
                stack.pop();
                j++;
            } else {
                if (i >= pushArray.length) {
                    return false;
                }
                stack.push(pushArray[i]);
                i++;
            }
        }
        return stack.size() == 0;
    }
}
