package questions.Matrix;

import java.util.Stack;

public class MaximumSizeRectangleBinarySubMatrixWithAllOnes {
//    Q - https://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/
    public int solve(int matrix[][], int m, int n) {
        int[] histogramArray = new int[n];

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0)
                    histogramArray[j] += matrix[i][j];
                else
                    histogramArray[j] = 0;

            }

            maxArea = findMaxAreaOfAHistogram(histogramArray, maxArea);
        }
        return maxArea;
    }
    private int findMaxAreaOfAHistogram(int[] arr, int maxSoFar) {
        int[] right = new int[arr.length];
        int[] left = new int[arr.length];

        Stack<Integer> stack = new Stack<>();
//        fill right limit
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();

            right[i] = stack.isEmpty() ? arr.length - 1 : stack.peek() - 1;

            stack.push(i);
        }

        stack.clear();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();

            left[i] = stack.isEmpty() ? 0 : stack.peek() + 1;

            stack.push(i);
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int width = right[i] - left[i] + 1;
            int area = width * arr[i];
            max = Math.max(area, max);
        }
        return Math.max(maxSoFar, max);
    }
}
