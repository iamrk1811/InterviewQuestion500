package questions.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeInterval {
//    Q - https://www.geeksforgeeks.org/merging-intervals/
    public int[][] solve2(int[][] arr) {
//        solved using constant space
        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
           public int compare(int[] a, int[] b) {
               return a[0] - b[0];
           }
        });
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[index][1] > arr[i][0]) {
//                merging is possible
                arr[index][1] = Math.max(arr[index][1], arr[i][1]);
            } else {
                index++;
                arr[index][0] = arr[i][0];
                arr[index][1] = arr[i][1];
            }
        }
        int[][] res = new int[index + 1][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }
    public int[][] solve(int[][] arr) {
//        solution using stack
        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        Stack<int[]> stack = new Stack<>();

        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int[] temp = stack.peek();
            int[] curr = arr[i];

            if (temp[1] > curr[0]) {
                temp[1] = Math.max(temp[1], curr[1]);
                stack.pop();
                stack.push(temp);
            } else {
                stack.push(curr);
            }
        }
        int[][] res = new int[stack.size()][2];
        int idx = 0;
        while (!stack.isEmpty()) {
            res[idx] = stack.pop();
            idx++;
        }
        return res;
    }
}
