package questions.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KConcatenation {
    //    Q - https://www.codechef.com/JAN18/problems/KCON/
    //    Q - https://leetcode.com/problems/k-concatenation-maximum-sum/
    public int solve(int[] a, int k) {

        long sum = 0;
        for (int val : a) sum += val;

        long max = 0;
        if (k == 1) {
            max = kadane(a);
        } else if (sum < 0) {
            max = kadaneOfTwo(a);
        } else {
            max = kadaneOfTwo(a) + (k - 2) * sum;
        }
//            ANS
        return (int) (max % (Math.pow(10, 9) + 7));
    }
    private long kadaneOfWhole(int[] arr, int k) {
        int[] tempArray = new int[arr.length * k];
        int idx = 0;
        while (k-- > 0) {
            for (int val : arr) {
                tempArray[idx] = val;
                idx++;
            }
        }
        return kadane(tempArray);
    }
    private long kadaneOfTwo(int[] arr) {
        int[] newArray = new int[arr.length * 2];
        int time = 2;
        int idx = 0;
        while (time-- > 0) {
            time--;
            for (int i = 0; i < arr.length; i++) {
                newArray[idx] = arr[i];
            }
        }
        return kadane(newArray);
    }

    private long kadane(int[] arr) {
        long maxSum = Integer.MIN_VALUE;
        long currentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum > maxSum)
                maxSum = currentSum;
            if (currentSum < 0)
                currentSum = 0;
        }
        return maxSum;
    }
}
