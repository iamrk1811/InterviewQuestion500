package questions.StackAndQueue;

import java.util.Stack;

public class TheCelebrityProblem {
//    Q - https://www.geeksforgeeks.org/the-celebrity-problem/
    public int solve2(int[][] matrix, int n) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() != 1) {
            int personA = stack.pop();
            int personB = stack.pop();

            if (knows(matrix, personA, personB)) {
                stack.push(personB);
            } else {
                stack.push(personA);
            }
        }

        int possibleAns = stack.pop();

        for (int i = 0; i < n; i++) {
            if (i != possibleAns && (knows(matrix, possibleAns, i) || knows(matrix, i, possibleAns) == false)) return -1;
        }
        return possibleAns;
    }
    public int solve(int[][] matrix, int n) {
        int personA = 0, personB = n - 1;

        while (personA < personB) {
            if (knows(matrix, personA, personB)) {
                personA++;
            } else {
                personB--;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != personA && (knows(matrix, personA, i)) || knows(matrix, i, personA) == false)
                return -1;
        }

        return personA;
    }

    private boolean knows(int[][] matrix, int personA, int personB) {
        return matrix[personA][personB] == 1;
    }
}
