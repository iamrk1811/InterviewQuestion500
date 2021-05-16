package questions.Greedy;

import java.util.Arrays;

public class MinimumSumOfAbsoluteDifferenceOfPairsOfTwoArrays {
    //    Q - https://www.geeksforgeeks.org/minimum-sum-absolute-difference-pairs-two-arrays/
    public int solve(int[] arr1, int[] arr2) {
        int sum = 0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        ;

        for (int i = 0; i < arr1.length; i++) {
            sum += Math.abs(arr1[i] - arr2[i]);
        }
        return sum;
    }
}
